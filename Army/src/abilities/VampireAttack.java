package abilities;

import exeption.UnitIsDeadException;
import static unit.Classes.*;
import unit.Unit;

public class VampireAttack extends Ability {
	private Unit unit;

	public VampireAttack(Unit unit, int damage) {
		super(damage, 1);
		this.unit = unit;
	}

	public void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage);

		this.unit.getState().hp += this.unit.getAbility().getDamage() / 3;

		if (unit.getState().hp > unit.getState().maxhp) {
			unit.getState().hp = unit.getState().maxhp;
		}

		target.isAlive();
		
		if (Math.random() < 0.5) {
			if ( target.getUnit_class() == WEREWOLF ) {
				System.out.println("-1");
			} else {
				infect(target);
			}
		}

		unit.takeDamage(target.getAbility().getDamage() / 2);

		if (target.getUnit_class() == VAMPIRE) {
			target.getState().hp += target.getAbility().getDamage() / 6;

			if (target.getState().hp > target.getState().maxhp) {
				target.getState().hp = target.getState().maxhp;
			}
		}
	}
	
	private void infect(Unit victim) {
		victim.setUnit_class(VAMPIRE);
		victim.setAbility(this);
	}

}
