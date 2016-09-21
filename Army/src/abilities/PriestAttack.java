package abilities;

import static unit.Classes.NECROMANCER;
import static unit.Classes.VAMPIRE;

import exeption.UnitIsDeadException;
import unit.Unit;

public class PriestAttack extends Ability {
	private Unit unit;

	public PriestAttack(Unit unit, int damage) {
		super(damage, 1);
		this.unit = unit;
	}

	public void action(Unit target) throws UnitIsDeadException {
		if (target.getUnit_class() == VAMPIRE || target.getUnit_class() == NECROMANCER) {
			target.takeDamage(damage * 2);
		} else {
			target.takeDamage(damage);
		}

		target.isAlive();

		unit.takeDamage(target.getAbility().getDamage() / 2);

		if (target.getUnit_class() == VAMPIRE) {
			target.getState().hp += target.getAbility().getDamage() / 6;

			if (target.getState().hp > target.getState().maxhp) {
				target.getState().hp = target.getState().maxhp;
			}
		}
	}
}
