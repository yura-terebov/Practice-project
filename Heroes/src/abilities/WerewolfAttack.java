/*
 * Decompiled with CFR 0_118.
 */
package abilities;

import abilities.Ability;
import exeption.UnitIsDeadException;
import java.io.PrintStream;
import javax.swing.JTextArea;
import main.Main;
import state.State;
import unit.Classes;
import unit.Unit;

public class WerewolfAttack
extends Ability {
    private Unit unit;

    public WerewolfAttack(Unit unit, int damage) {
        super(damage, 1);
        this.unit = unit;
    }

    @Override
    public void action(Unit target) throws UnitIsDeadException {
        target.takeDamage(this.damage);
        target.isAlive();
        if (Math.random() < 0.5) {
            if (target.getUnit_class() == Classes.VAMPIRE) {
                System.out.println("-1");
            }
            Main.GameBoardFrame.text.append("Werewolf infect target\n");
            this.infect(target);
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
        victim.getState().isWerewolf = true;
        victim.setUnit_class(Classes.WEREWOLF);
    }
}

