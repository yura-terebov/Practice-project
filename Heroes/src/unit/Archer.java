/*
 * Decompiled with CFR 0_118.
 */
package unit;

import abilities.Ability;
import abilities.ArcherAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import unit.Classes;
import unit.Unit;

public class Archer
extends Unit {
    public Archer(String name) throws FielBusyException, InvalidParamException {
        super(name, 100, 2);
        this.ability = new ArcherAttack(this, 30);
        this.unit_class = Classes.ARCHER;
        this.image = "Archer";
        this.aboutUnit = "Archer:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100 \u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30 \u0435\u0434.\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 3\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043b\u0443\u0447\u043d\u0438\u043a \u0443\u043c\u0435\u0435\u0442 \u0441\u0442\u0440\u0435\u043b\u044f\u0442\u044c \u043d\u0430 \u0440\u0430\u0441\u0442\u043e\u044f\u043d\u0438\u0438";
    }
}

