package abilities;

import exeption.UnitIsDeadException;
import unit.Unit;

public class RogueAttack extends Ability {

	public RogueAttack(int damage) {
		super(damage, 1);
	}

	public void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage);
		
		target.isAlive();
	}
}
