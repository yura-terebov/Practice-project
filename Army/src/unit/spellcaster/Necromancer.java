package unit.spellcaster;

import static unit.Classes.*;

import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.UnitIsDeadException;
import spells.Fireball;
import spells.Spells;
import unit.Unit;

public class Necromancer extends Spellcaster {

	public Necromancer(String name) throws FielBusyException, InvalidParamException {
		super(name, 60, 100);
		isBattleMagician = true;
		spells.put(Spells.FIREBALL, new Fireball(this, 30, 25));
		unit_class = NECROMANCER;
		this.image = "Necromancer";
		this.aboutUnit = "Necromancer:\nЗдоровье 60 ед.\nМана 100 ед.\nСила атаки 16 ед.\nШаг 2\nРадиус атаки 1\nЗаклинание:\nбоевой маг\nfireball: 30 ед.\nесли герой атакует цель после сметри он\nвосстанавливает жизни герою\nЗатраты маны на заклинание: 25 ед.";
	}
	
	public void	attack(Unit enemy) throws UnitIsDeadException {
		isAlive();
			enemy.addObserver(this);
			ability.action(enemy);
	}

}
