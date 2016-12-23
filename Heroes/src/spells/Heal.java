/*
 * Decompiled with CFR 0_118.
 */
package spells;

import spells.Spell;
import state.State;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public class Heal
extends Spell {
    public Heal(Spellcaster owner, int spellpower, int spellcost) {
        super(owner, spellpower, spellcost);
        if (owner.isBattleMagician) {
            this.spellpower /= 2;
        }
        this.image = "Healing";
    }

    @Override
    public void action(Unit target) {
        int newHp = target.getState().hp + this.spellpower;
        target.getState().hp = newHp > target.getState().maxhp ? target.getState().maxhp : newHp;
    }
}

