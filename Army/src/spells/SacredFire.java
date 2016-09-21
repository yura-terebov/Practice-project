package spells;

import unit.Unit;
import unit.spellcaster.Spellcaster;
import static unit.Classes.*;

import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;

public class SacredFire extends Spell {

	public SacredFire(Spellcaster owner, int spellpower, int spellcost) {
		super(owner, spellpower, spellcost);
		if ( !owner.isBattleMagician ) {
			this.spellpower /= 2;
		}
		this.image = "SacredFire";
	}

	@Override
	public void action(Unit target) throws UnitIsDeadException, ItIsBerserkException {
		if ( target.getUnit_class() == VAMPIRE || target.getUnit_class() == NECROMANCER ) {
			target.takeMagicDamage(spellpower * 2);
		} else {
			target.takeMagicDamage(spellpower);
		}
	}
}
