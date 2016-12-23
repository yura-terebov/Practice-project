/*
 * Decompiled with CFR 0_118.
 */
package board;

import exeption.FielBusyException;
import exeption.InvalidParamException;
import java.awt.Point;
import unit.Archer;
import unit.Berserker;
import unit.Rogue;
import unit.Soldier;
import unit.Unit;
import unit.Vampire;
import unit.Werewolf;
import unit.spellcaster.Healer;
import unit.spellcaster.Necromancer;
import unit.spellcaster.Priest;
import unit.spellcaster.Warlock;
import unit.spellcaster.Wizard;

public class Board {
    public static final Unit[][] board = Board.generateInitUnits();
    public static Point selectedUnit = null;
    public static Point selectedWarlockSpell = null;
    public static Point selectMagesSpell = null;

    private static Unit[][] generateInitUnits() {
        try {
            Unit[][] arrunit = new Unit[8][];
            arrunit[0] = new Unit[]{new Werewolf("Werewolf"), new Healer("Healer"), new Priest("Priest"), new Necromancer("Necromancer"), new Rogue("Rogue"), new Warlock("Warlock"), new Archer("Archer"), new Wizard("Wizard")};
            Unit[] arrunit2 = new Unit[8];
            arrunit2[1] = new Soldier("Soldier");
            arrunit2[4] = new Berserker("Berserker");
            arrunit2[6] = new Vampire("Vampire");
            arrunit[1] = arrunit2;
            arrunit[2] = new Unit[8];
            arrunit[3] = new Unit[8];
            arrunit[4] = new Unit[8];
            arrunit[5] = new Unit[8];
            Unit[] arrunit3 = new Unit[8];
            arrunit3[1] = new Soldier("Soldier");
            arrunit3[4] = new Berserker("Berserker");
            arrunit3[6] = new Vampire("Vampire");
            arrunit[6] = arrunit3;
            arrunit[7] = new Unit[]{new Werewolf("Werewolf"), new Healer("Healer"), new Priest("Priest"), new Necromancer("Necromancer"), new Rogue("Rogue"), new Warlock("Warlock"), new Archer("Archer"), new Wizard("Wizard")};
            return arrunit;
        }
        catch (FielBusyException | InvalidParamException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int distance(Point other, int x, int y) {
        if (x == other.x) {
            int temp = y - other.y;
            if (temp < 0) {
                temp *= -1;
            }
            return temp;
        }
        if (y == other.y) {
            int temp = x - other.x;
            if (temp < 0) {
                temp *= -1;
            }
            return temp;
        }
        int dx = x - other.x;
        int dy = y - other.y;
        if (dx < 0) {
            dx *= -1;
        }
        if (dy < 0) {
            dy *= -1;
        }
        if (dx >= dy) {
            return dx;
        }
        return dy;
    }
}

