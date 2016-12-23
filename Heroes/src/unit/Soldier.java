/*
 * Decompiled with CFR 0_118.
 */
package unit;

import abilities.Ability;
import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import unit.Classes;
import unit.Unit;

public class Soldier
extends Unit {
    public Soldier(String name) throws FielBusyException, InvalidParamException {
        super(name, 100, 3);
        this.ability = new DefaultAttack(this, 30);
        this.unit_class = Classes.SOLDIER;
        this.image = "Soldier";
        this.aboutUnit = "Soldier:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100 \u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30 \u0435\u0434.\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n";
    }
}

