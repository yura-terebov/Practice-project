package unit.spellcaster;

import java.util.HashMap;
import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import spells.Spell;
import spells.Spells;
import unit.Unit;

public abstract class Spellcaster extends Unit {
	public boolean isBattleMagician;
	protected HashMap<Spells, Spell> spells = new HashMap<Spells, Spell>();
	public static final int RADIUSALLSPELLS = 3;
	public static Spells activeSpell = null;
    
    public Spellcaster(String name, int hp, int mana) throws FielBusyException, InvalidParamException {
    	super(name, hp, mana, 2);
    	ability = new DefaultAttack(this, 16);
    }
    
    public HashMap<Spells, Spell> getSpells() {
    	return this.spells;
    }
    
	public void spendMana(int amount) throws NotEnoughManaException {
		int newManaAmount = state.mana - amount;
		
		if ( newManaAmount < 0) {
			throw new NotEnoughManaException();
		}
		
		state.mana = newManaAmount;
	}
	
	public void cast(Spells spell, Unit target) throws Exception {
		Spell currentSpell = spells.get(spell);

		currentSpell.action(target);
		spendMana(currentSpell.spellcost);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(" hp: ");
		str.append(getState().hp);
		str.append("/");
		str.append(getState().maxhp);
		str.append(String.format("%nmp: "));
		str.append(System.lineSeparator() + "mp: ");
		str.append(System.getProperty("line.separator") + "mp: ");
		str.append(getState().mana);
		str.append("/");
		str.append(getState().maxmana);
		
		return str.toString();
	}
}
