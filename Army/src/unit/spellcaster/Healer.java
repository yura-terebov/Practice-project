package unit.spellcaster;

import static unit.Classes.*;

import exeption.FielBusyException;
import exeption.InvalidParamException;
import spells.Fireball;
import spells.Heal;
import spells.Spells;

public class Healer extends Spellcaster {

	public Healer(String name) throws FielBusyException, InvalidParamException {
		super(name, 60, 100);
		isBattleMagician = false;
		spells.put(Spells.FIREBALL, new Fireball(this, 30, 25));
		spells.put(Spells.HEAL, new Heal(this, 30, 25));
		unit_class = HEALER;
		this.image = "Healer";
		this.aboutUnit = "Healer:\nЗдоровье 60 ед.\nМана 100 ед.\nСила атаки 16 ед.\nШаг 2\nРадиус атаки 1\nЗаклинание:\nне боевой маг\nfireball: 15 ед.\nheal: 30 ед.\nЗатраты маны на заклинание: 25 ед.";
	}

}
