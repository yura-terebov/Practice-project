/*
 * Decompiled with CFR 0_118.
 */
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
        return this.damage;
    }

    public int getRadiusAttack() {
        return this.radiusAttack;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public abstract void action(Unit var1) throws UnitIsDeadException;
}

