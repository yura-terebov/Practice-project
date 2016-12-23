/*
 * Decompiled with CFR 0_118.
 */
package abilities;

import abilities.Ability;
import exeption.UnitIsDeadException;
import unit.Unit;

public class ArcherAttack
extends Ability {
    public ArcherAttack(Unit unit, int damage) {
        super(damage, 3);
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(this.damage);
        target.isAlive();
    }
}

