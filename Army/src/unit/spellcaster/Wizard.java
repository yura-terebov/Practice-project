package unit.spellcaster;

import static unit.Classes.*;

import exeption.FielBusyException;
import exeption.InvalidParamException;
import spells.Fireball;
import spells.Heal;
import spells.Spells;

public class Wizard extends Spellcaster {

	public Wizard(String name) throws FielBusyException, InvalidParamException {
		super(name, 60, 100);
		isBattleMagician = true;
		spells.put(Spells.FIREBALL, new Fireball(this, 30, 25));
		spells.put(Spells.HEAL, new Heal(this, 30, 25));
		unit_class = WIZARD;
		this.image = "Wizard";
		this.aboutUnit = "Wizard:\nЗдоровье 60 ед.\nМана 100 ед.\nСила атаки 16 ед.\nШаг 2\nРадиус атаки 1\nЗаклинание:\nбоевой маг\nfireball: 30 ед.\nheal: 15 ед.\nЗатраты маны на заклинание: 25 ед.";
	}

}
