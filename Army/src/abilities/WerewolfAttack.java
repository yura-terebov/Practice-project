package abilities;

import main.Main.GameBoardFrame;
import exeption.UnitIsDeadException;

import static unit.Classes.*;
import unit.Unit;

public class WerewolfAttack extends Ability {
	private Unit unit;

	public WerewolfAttack(Unit unit, int damage) {
		super(damage, 1);
		this.unit = unit;
	}

	@Override
	public void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage);
		
		target.isAlive();

		if (Math.random() < 0.5) {
			if ( target.getUnit_class() == VAMPIRE ) {
				System.out.println("-1");
			}
			GameBoardFrame.text.append("Werewolf infect target\n");
			infect(target);
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
		victim.getState().isWerewolf = true;
		victim.setUnit_class(WEREWOLF);
	}

}
