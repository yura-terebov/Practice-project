/*
 * Decompiled with CFR 0_118.
 */
package spells;

import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import main.Main;
import unit.Unit;
import unit.spellcaster.Spellcaster;

public abstract class Spell {
    protected Spellcaster owner;
    public int spellpower;
    public int spellcost;
    protected String image;

    public Spell(Spellcaster owner, int spellpower, int spellcost) {
        this.spellpower = spellpower;
        this.spellcost = spellcost;
        this.owner = owner;
    }

    public String getImage() {
        return this.image;
    }

    public abstract void action(Unit var1) throws UnitIsDeadException, ItIsBerserkException;

    public Image getSpellImage() {
        return new ImageIcon(Main.class.getResource("/image/spells/" + this.image + ".png")).getImage();
    }
}

