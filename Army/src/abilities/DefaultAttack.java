package abilities;

import exeption.UnitIsDeadException;
import static unit.Classes.*;
import unit.Unit;

public class DefaultAttack extends Ability {
	private Unit unit;

	public DefaultAttack(Unit unit, int damage) {
		super(damage, 1);
		this.unit = unit;
	}

	public void action(Unit target) throws UnitIsDeadException {
			target.takeDamage(damage);
	
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
