/*
 * Decompiled with CFR 0_118.
 */
package spells;

import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import spells.Spell;
import unit.Classes;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public class SacredFire
extends Spell {
    public SacredFire(Spellcaster owner, int spellpower, int spellcost) {
        super(owner, spellpower, spellcost);
        if (!owner.isBattleMagician) {
            this.spellpower /= 2;
        }
        this.image = "SacredFire";
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException, ItIsBerserkException {
        if (target.getUnit_class() == Classes.VAMPIRE || target.getUnit_class() == Classes.NECROMANCER) {
            target.takeMagicDamage(this.spellpower * 2);
        } else {
            target.takeMagicDamage(this.spellpower);
        }
    }
}

