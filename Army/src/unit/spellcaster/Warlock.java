package unit.spellcaster;

import static unit.Classes.*;

import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import exeption.UnitIsDeadException;
import unit.Unit;

public final class Warlock extends Spellcaster {
	private Skelet skelet = null;

	public Warlock(String name) throws FielBusyException, InvalidParamException {
		super(name, 60, 100);
		isBattleMagician = false;
		unit_class = WARLOCK;
		this.image = "Warlock";
		this.aboutUnit = "Warlock:\nЗдоровье 60 ед.\nМана 100 ед.\nСила атаки 16 ед.\nШаг 2\nРадиус атаки 1\nЗаклинание:\nПризывает Скелета\nЗатраты маны на заклинание: 50 ед.";
	}
	
	public Skelet getSkelet() {
		return this.skelet;
	}
	
	public Skelet summon() throws NotEnoughManaException, FielBusyException, InvalidParamException  {
		if( skelet == null || skelet.getState().hp <= 0 ) {
			spendMana(50);
			skelet = new Skelet("Skeleton");
			return skelet;
		} else {
			return null;
		}
	}

	 public class Skelet extends Unit {
		private int defence;
		
		public Skelet(String name) throws FielBusyException, InvalidParamException {
			super(name, 110, 3);
			this.ability = new DefaultAttack(this, 15);
			unit_class = null;
			this.image = "Demon";
			this.defence = 10;
			this.aboutUnit = "Warlock:\nЗдоровье 110ед.\nСила атаки 15 ед.\nШаг 3\nРадиус атаки 1\nОсобености:\nИмеет защиту: 10 ед.";
		}
		
		public void takeDamage(int damage) throws UnitIsDeadException {
			isAlive();
			damage -= defence;
			this.state.hp -= damage;
			if (this.state.hp <= 0) {
				this.state.hp = 0;
			}
		}
	}
}

//public Soldier(String name) throws FielBusyException, InvalidParamException {
//	super(name, 100, 3);
//	this.ability = new DefaultAttack(this, 30);
//	unit_class = SOLDIER;
//	this.image = "Soldier";
//	this.aboutUnit = "Soldier:\nЗдоровье 100 ед.\nСила атаки 30 ед.\nШаг 3\nРадиус атаки 1\n";
//}