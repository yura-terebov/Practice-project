package unit;

import static unit.Classes.*;

import abilities.RogueAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;

public class Rogue extends Unit {
	
	public Rogue(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 3);
		this.ability = new RogueAttack(30);
		unit_class = ROGUE;
		this.image = "Rogue";
		this.aboutUnit = "Rogue:\nЗдоровье 100 ед.\nСила атаки 30 ед.\nШаг 3\nРадиус атаки 1\nОсобености:\nне действует контр атака";
	}

}
