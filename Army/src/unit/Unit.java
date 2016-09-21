package unit;

import java.awt.Image;
import java.util.HashSet;

import javax.swing.ImageIcon;


import abilities.Ability;
import abilities.WerewolfAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import main.Main;
import state.State;


public abstract class Unit {
	protected int step;
	protected Classes unit_class;
	protected String name;
	protected State state;
	protected Ability ability;
	protected HashSet<Unit> observers = new HashSet<Unit>();
	protected Ability vampireAbility;
	protected State altState;
	protected Ability altAbility;
	protected boolean switch_form = false;
	protected String image;
	protected String aboutUnit;
	private String altImage = "WerewolfTransform";

	public Unit(String name, int hp,  int step) throws FielBusyException, InvalidParamException {
		this(name, hp, 0,  step);
	}
	
	public Unit(String name, int hp, int mana,  int step) throws FielBusyException, InvalidParamException {
		state = new State(hp, mana);
		this.name = name;
		if ( step < 1 ) {
			throw new InvalidParamException();
		} else {
			this.step = step;
		}
		
//		if ( Board.board[location.getX()][location.getY()] == 1 ) {
//			throw new FielBusyException();
//		} else {
//			Board.board[location.getX()][location.getY()] = 1;
//		}
	}
	
	public State getState() {
		return this.state;
	}
	public String getName() {
		return this.name;
	}
	public Ability getAbility() {
		return this.ability;
	}
	public Classes getUnit_class() {
		return this.unit_class;
	}
	public Ability getVampireAbility() {
		return vampireAbility;
	}
	public int getStep() {
		return this.step;
	}
	public String getAboutUnit() {
		return this.aboutUnit;
	}
	
	
	public void setUnit_class(Classes unit_class) {
		this.unit_class = unit_class;
	}
	public void setAbility(Ability otherAbility) {
		this.ability = otherAbility;
	}
	
	public void takeDamage(int damage) throws UnitIsDeadException {
		isAlive();
		this.state.hp -= damage;
		if (this.state.hp <= 0) {
			this.state.hp = 0;
		}
	}

	public void takeMagicDamage(int damage) throws UnitIsDeadException, ItIsBerserkException {
		if (switch_form == true) {
			takeDamage(damage * 2);
		} else {
			takeDamage(damage);
		}
	}

	public void takeHeal(int heal) throws UnitIsDeadException {
		isAlive();
		this.state.hp += heal;
		if (this.state.hp > this.state.maxhp)
			this.state.hp = this.state.maxhp;
	}

	public void addObserver(Unit unit) {
		observers.add(unit);
	}

	public void die() throws UnitIsDeadException {
		for (Unit u : this.observers) {
			u.takeHeal(30);
		}
	}

	public void isAlive() throws UnitIsDeadException {
		if (this.state.hp == 0) {
			die();
			throw new UnitIsDeadException();
		}
	}

	public void	attack(Unit enemy) throws UnitIsDeadException {
		isAlive();
		ability.action(enemy);
	}

	public void transform() {
		if ( state.isWerewolf ) {
			State tempState = state;
			Ability tempAbility = ability;
			String tempImage = image;

			image = altImage;
			altImage = tempImage;
			
			if ( switch_form == false) {
			altAbility = new WerewolfAttack(this, ability.getDamage() * 2);
			altState = new State(state.maxhp * 2);
			switch_form = true;
			} else {
				altAbility = new WerewolfAttack(this, ability.getDamage() / 2);
				altState = new State(state.maxhp / 2);
				switch_form = false;
			}
			
			state = altState;
			ability = altAbility;
			altAbility = tempAbility;
			altState = tempState;
		
			state.hp = state.maxhp * altState.hp / altState.maxhp;
			state.isWerewolf = true;
		}
	}

	public Image getUnitImage() {
		Image img = new ImageIcon(Main.class.getResource("/image/units/" + image + ".png")).getImage();
		
//		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g = (Graphics2D) bi.getGraphics();
//		g.drawImage(img, 0, 0, null);
		return  img;
	}
	
		
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("hp: ");
		str.append(getState().hp);
		str.append("/");
		str.append(getState().maxhp);

		return str.toString();
	}
}

