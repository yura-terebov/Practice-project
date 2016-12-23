/*
 * Decompiled with CFR 0_118.
 */
package unit.spellcaster;

import abilities.Ability;
import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import java.util.HashMap;
import spells.Spell;
import spells.Spells;
import state.State;
import unit.Unit;

public abstract class Spellcaster
extends Unit {
    public boolean isBattleMagician;
    protected HashMap<Spells, Spell> spells = new HashMap();
    public static final int RADIUSALLSPELLS = 3;
    public static Spells activeSpell = null;

    public Spellcaster(String name, int hp, int mana) throws FielBusyException, InvalidParamException {
        super(name, hp, mana, 2);
        this.ability = new DefaultAttack(this, 16);
    }

    public HashMap<Spells, Spell> getSpells() {
        return this.spells;
    }

    public void spendMana(int amount) throws NotEnoughManaException {
        int newManaAmount = this.state.mana - amount;
        if (newManaAmount < 0) {
            throw new NotEnoughManaException();
        }
        this.state.mana = newManaAmount;
    }

    public void cast(Spells spell, Unit target) throws Exception {
        Spell currentSpell = this.spells.get((Object)spell);
        currentSpell.action(target);
        this.spendMana(currentSpell.spellcost);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" hp: ");
        str.append(this.getState().hp);
        str.append("/");
        str.append(this.getState().maxhp);
        str.append(String.format("%nmp: ", new Object[0]));
        str.append(String.valueOf(System.lineSeparator()) + "mp: ");
        str.append(String.valueOf(System.getProperty("line.separator")) + "mp: ");
        str.append(this.getState().mana);
        str.append("/");
        str.append(this.getState().maxmana);
        return str.toString();
    }
}

