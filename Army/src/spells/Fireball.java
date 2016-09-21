package spells;

import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public class Fireball extends Spell {

	public Fireball(Spellcaster owner, int spellpower, int spellcost) {
		super(owner, spellpower, spellcost);
		if ( !owner.isBattleMagician ) {
			this.spellpower /= 2;
		}
		this.image = "FireBall";
	}

	@Override
	public void action(Unit target) throws UnitIsDeadException, ItIsBerserkException {
		target.takeMagicDamage(spellpower);
	}
}
