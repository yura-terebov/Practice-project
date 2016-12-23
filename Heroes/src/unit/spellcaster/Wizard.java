/*
 * Decompiled with CFR 0_118.
 */
package unit.spellcaster;

import exeption.FielBusyException;
import exeption.InvalidParamException;
import java.util.HashMap;
import spells.Fireball;
import spells.Heal;
import spells.Spells;
import unit.Classes;
import unit.spellcaster.Spellcaster;

public class Wizard
extends Spellcaster {
    public Wizard(String name) throws FielBusyException, InvalidParamException {
        super(name, 60, 100);
        this.isBattleMagician = true;
        this.spells.put(Spells.FIREBALL, new Fireball(this, 30, 25));
        this.spells.put(Spells.HEAL, new Heal(this, 30, 25));
        this.unit_class = Classes.WIZARD;
        this.image = "Wizard";
        this.aboutUnit = "Wizard:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60 \u0435\u0434.\n\u041c\u0430\u043d\u0430 100 \u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16 \u0435\u0434.\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\n\u0431\u043e\u0435\u0432\u043e\u0439 \u043c\u0430\u0433\nfireball: 30 \u0435\u0434.\nheal: 15 \u0435\u0434.\n\u0417\u0430\u0442\u0440\u0430\u0442\u044b \u043c\u0430\u043d\u044b \u043d\u0430 \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435: 25 \u0435\u0434.";
    }
}

