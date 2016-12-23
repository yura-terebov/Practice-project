/*
 * Decompiled with CFR 0_118.
 */
package abilities;

import abilities.Ability;
import exeption.UnitIsDeadException;
import unit.Unit;

public class RogueAttack
extends Ability {
    public RogueAttack(int damage) {
        super(damage, 1);
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(this.damage);
        target.isAlive();
    }
}

