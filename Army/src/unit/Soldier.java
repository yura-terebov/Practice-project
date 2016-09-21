package unit;

import static unit.Classes.*;

import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;

public class Soldier extends Unit {
	
	public Soldier(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 3);
		this.ability = new DefaultAttack(this, 30);
		unit_class = SOLDIER;
		this.image = "Soldier";
		this.aboutUnit = "Soldier:\nЗдоровье 100 ед.\nСила атаки 30 ед.\nШаг 3\nРадиус атаки 1\n";
	}

}
