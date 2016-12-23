/*
 * Decompiled with CFR 0_118.
 */
package abilities;

import abilities.Ability;
import exeption.UnitIsDeadException;
import java.io.PrintStream;
import state.State;
import unit.Classes;
import unit.Unit;

public class VampireAttack
extends Ability {
    private Unit unit;

    public VampireAttack(Unit unit, int damage) {
        super(damage, 1);
        this.unit = unit;
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(this.damage);
        this.unit.getState().hp += this.unit.getAbility().getDamage() / 3;
        if (this.unit.getState().hp > this.unit.getState().maxhp) {
            this.unit.getState().hp = this.unit.getState().maxhp;
        }
        target.isAlive();
        if (Math.random() < 0.5) {
            if (target.getUnit_class() == Classes.WEREWOLF) {
                System.out.println("-1");
            } else {
                this.infect(target);
            }
        }
        this.unit.takeDamage(target.getAbility().getDamage() / 2);
        if (target.getUnit_class() == Classes.VAMPIRE) {
            target.getState().hp += target.getAbility().getDamage() / 6;
            if (target.getState().hp > target.getState().maxhp) {
                target.getState().hp = target.getState().maxhp;
            }
        }
    }

    private void infect(Unit victim) {
        victim.setUnit_class(Classes.VAMPIRE);
        victim.setAbility(this);
    }
}

