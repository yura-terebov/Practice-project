/*
 * Decompiled with CFR 0_118.
 */
package abilities;

import abilities.Ability;
import exeption.UnitIsDeadException;
import state.State;
import unit.Classes;
import unit.Unit;

public class DefaultAttack
extends Ability {
    private Unit unit;

    public DefaultAttack(Unit unit, int damage) {
        super(damage, 1);
        this.unit = unit;
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(this.damage);
        target.isAlive();
        this.unit.takeDamage(target.getAbility().getDamage() / 2);
        if (target.getUnit_class() == Classes.VAMPIRE) {
            target.getState().hp += target.getAbility().getDamage() / 6;
            if (target.getState().hp > target.getState().maxhp) {
                target.getState().hp = target.getState().maxhp;
            }
        }
    }
}

