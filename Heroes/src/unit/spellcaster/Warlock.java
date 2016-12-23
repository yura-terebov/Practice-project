/*
 * Decompiled with CFR 0_118.
 */
package unit.spellcaster;

import abilities.Ability;
import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import exeption.UnitIsDeadException;
import state.State;
import unit.Classes;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public final class Warlock
extends Spellcaster {
    private Skelet skelet = null;

    public Warlock(String name) throws FielBusyException, InvalidParamException {
        super(name, 60, 100);
        this.isBattleMagician = false;
        this.unit_class = Classes.WARLOCK;
        this.image = "Warlock";
        this.aboutUnit = "Warlock:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60 \u0435\u0434.\n\u041c\u0430\u043d\u0430 100 \u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16 \u0435\u0434.\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\n\u041f\u0440\u0438\u0437\u044b\u0432\u0430\u0435\u0442 \u0421\u043a\u0435\u043b\u0435\u0442\u0430\n\u0417\u0430\u0442\u0440\u0430\u0442\u044b \u043c\u0430\u043d\u044b \u043d\u0430 \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435: 50 \u0435\u0434.";
    }

    public Skelet getSkelet() {
        return this.skelet;
    }

    public Skelet summon() throws NotEnoughManaException, FielBusyException, InvalidParamException {
        if (this.skelet == null || this.skelet.getState().hp <= 0) {
            this.spendMana(50);
            this.skelet = new Skelet("Skeleton");
            return this.skelet;
        }
        return null;
    }

    public class Skelet
    extends Unit {
        private int defence;

        public Skelet(String name) throws FielBusyException, InvalidParamException {
            super(name, 110, 3);
            this.ability = new DefaultAttack(this, 15);
            this.unit_class = null;
            this.image = "Demon";
            this.defence = 10;
            this.aboutUnit = "Warlock:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 110\u0435\u0434.\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 15 \u0435\u0434.\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u0418\u043c\u0435\u0435\u0442 \u0437\u0430\u0449\u0438\u0442\u0443: 10 \u0435\u0434.";
        }

        @Override
        public void takeDamage(int damage) throws UnitIsDeadException {
            this.isAlive();
            this.state.hp -= (damage -= this.defence);
            if (this.state.hp <= 0) {
                this.state.hp = 0;
            }
        }
    }

}

