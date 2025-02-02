/*
 * Decompiled with CFR 0_118.
 */
package unit;

import abilities.Ability;
import abilities.WerewolfAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import java.awt.Image;
import java.net.URL;
import java.util.HashSet;
import javax.swing.ImageIcon;
import main.Main;
import state.State;
import unit.Classes;

public abstract class Unit {
    protected int step;
    protected Classes unit_class;
    protected String name;
    protected State state;
    protected Ability ability;
    protected HashSet<Unit> observers = new HashSet();
    protected Ability vampireAbility;
    protected State altState;
    protected Ability altAbility;
    protected boolean switch_form = false;
    protected String image;
    protected String aboutUnit;
    private String altImage = "WerewolfTransform";

    public Unit(String name, int hp, int step) throws FielBusyException, InvalidParamException {
        this(name, hp, 0, step);
    }

    public Unit(String name, int hp, int mana, int step) throws FielBusyException, InvalidParamException {
        this.state = new State(hp, mana);
        this.name = name;
        if (step < 1) {
            throw new InvalidParamException();
        }
        this.step = step;
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
        return this.vampireAbility;
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
        this.isAlive();
        this.state.hp -= damage;
        if (this.state.hp <= 0) {
            this.state.hp = 0;
        }
    }

    public void takeMagicDamage(int damage) throws UnitIsDeadException, ItIsBerserkException {
        if (this.switch_form) {
            this.takeDamage(damage * 2);
        } else {
            this.takeDamage(damage);
        }
    }

    public void takeHeal(int heal) throws UnitIsDeadException {
        this.isAlive();
        this.state.hp += heal;
        if (this.state.hp > this.state.maxhp) {
            this.state.hp = this.state.maxhp;
        }
    }

    public void addObserver(Unit unit) {
        this.observers.add(unit);
    }

    public void die() throws UnitIsDeadException {
        for (Unit u : this.observers) {
            u.takeHeal(30);
        }
    }

    public void isAlive() throws UnitIsDeadException {
        if (this.state.hp == 0) {
            this.die();
            throw new UnitIsDeadException();
        }
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        this.isAlive();
        this.ability.action(enemy);
    }

    public void transform() {
        if (this.state.isWerewolf) {
            State tempState = this.state;
            Ability tempAbility = this.ability;
            String tempImage = this.image;
            this.image = this.altImage;
            this.altImage = tempImage;
            if (!this.switch_form) {
                this.altAbility = new WerewolfAttack(this, this.ability.getDamage() * 2);
                this.altState = new State(this.state.maxhp * 2);
                this.switch_form = true;
            } else {
                this.altAbility = new WerewolfAttack(this, this.ability.getDamage() / 2);
                this.altState = new State(this.state.maxhp / 2);
                this.switch_form = false;
            }
            this.state = this.altState;
            this.ability = this.altAbility;
            this.altAbility = tempAbility;
            this.altState = tempState;
            this.state.hp = this.state.maxhp * this.altState.hp / this.altState.maxhp;
            this.state.isWerewolf = true;
        }
    }

    public Image getUnitImage() {
        Image img = new ImageIcon(Main.class.getResource("/image/units/" + this.image + ".png")).getImage();
        return img;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("hp: ");
        str.append(this.getState().hp);
        str.append("/");
        str.append(this.getState().maxhp);
        return str.toString();
    }
}

