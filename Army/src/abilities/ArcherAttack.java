package abilities;

import exeption.UnitIsDeadException;
import unit.Unit;

public class ArcherAttack extends Ability {
	
	public ArcherAttack(Unit unit, int damage) {
		super(damage, 3);
	}

	public void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage);
		
		target.isAlive();
	}
}
