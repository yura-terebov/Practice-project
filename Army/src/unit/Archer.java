package unit;

import static unit.Classes.*;

import abilities.ArcherAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;

public class Archer extends Unit {
	
	public Archer(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 2);
		this.ability = new ArcherAttack(this, 30);
		unit_class = ARCHER;
		this.image = "Archer";
		this.aboutUnit = "Archer:\nЗдоровье 100 ед.\nСила атаки 30 ед.\nШаг 2\nРадиус атаки 3\nОсобености:\nлучник умеет стрелять на растоянии";
	}

}
