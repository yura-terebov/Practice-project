package unit.spellcaster;

import static unit.Classes.*;

import abilities.PriestAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import spells.*;

public class Priest extends Spellcaster {
	

	public Priest(String name) throws FielBusyException, InvalidParamException { 
		super(name, 60, 100);
		ability = new PriestAttack(this, 16);
		isBattleMagician = false;
		spells.put(Spells.SACREDFIRE, new SacredFire(this, 30, 25));
		spells.put(Spells.HEAL, new Heal(this, 30, 25));
		unit_class = PRIEST;
		this.image = "Priest";
		this.aboutUnit = "Priest:\nЗдоровье 60 ед.\nМана 100 ед.\nСила атаки 16 ед.\nШаг 2\nРадиус атаки 1\nЗаклинание:\nне боевой маг\nsacredfire: 15 ед.\nheal: 30 ед.\nЗатраты маны на заклинание: 25 ед.\nнаносит x2 урон нежити\n(Vampire, Necromancer)";
	}
}
