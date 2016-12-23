/*
 * Decompiled with CFR 0_118.
 */
package unit;

import abilities.Ability;
import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import unit.Classes;
import unit.Unit;

public class Berserker
extends Unit {
    public Berserker(String name) throws FielBusyException, InvalidParamException {
        super(name, 100, 3);
        this.ability = new DefaultAttack(this, 30);
        this.unit_class = Classes.BERSERKER;
        this.image = "Berserk";
        this.aboutUnit = "Berserk:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100 \u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30 \u0435\u0434.\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043d\u0430 \u0433\u0435\u0440\u043e\u044f \u043d\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0443\u0435\u0442 \u043c\u0430\u0433\u0438\u044f";
    }

    @Override
    public void takeMagicDamage(int damage) throws UnitIsDeadException, ItIsBerserkException {
        throw new ItIsBerserkException();
    }
}

