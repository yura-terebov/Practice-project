package spells;

import unit.Unit;
import unit.spellcaster.Spellcaster;

public class Heal extends Spell {

	public Heal(Spellcaster owner, int spellpower, int spellcost) {
		super(owner, spellpower, spellcost);
		if ( owner.isBattleMagician ) {
			this.spellpower /= 2;
		}
		this.image = "Healing";
	}

	@Override
	public void action(Unit target) {
		int newHp = target.getState().hp + spellpower;
		
		if (newHp > target.getState().maxhp) {
			target.getState().hp = target.getState().maxhp;
		} else {
			target.getState().hp = newHp;
		}
	}

}
