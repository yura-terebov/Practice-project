package abilities;

import exeption.UnitIsDeadException;
import unit.Unit;

public abstract class Ability {
	private int radiusAttack;
	protected int damage;
	
	public Ability(int damage, int radiusAttack) {
		this.damage = damage;
		this.radiusAttack = radiusAttack;
	}
	
	public int getDamage() {
		return damage;
	}

	public int getRadiusAttack() {
		return this.radiusAttack;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	public abstract void action(Unit target) throws UnitIsDeadException;
}
