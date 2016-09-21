package spells;

import java.awt.Image;

import javax.swing.ImageIcon;

import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import main.Main;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public abstract class Spell {
	protected Spellcaster owner;
	public int spellpower;
	public int spellcost;
	protected String image;
	
	public Spell(Spellcaster owner, int spellpower, int spellcost) {
		this.spellpower = spellpower;
		this.spellcost = spellcost;
		this.owner = owner;
	}
	
	
	public String getImage() {
		return this.image;
	}
	
	public abstract void action(Unit target) throws UnitIsDeadException, ItIsBerserkException;
	
	public Image getSpellImage() {
		return  new ImageIcon(Main.class.getResource("/image/spells/" + image + ".png")).getImage();
	}
}


