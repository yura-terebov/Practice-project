package unit;

import static unit.Classes.*;

import abilities.VampireAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;

public class Vampire extends Unit {
	
	public Vampire(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 3);
		this.ability = new VampireAttack(this, 25);
		unit_class = VAMPIRE;
		this.image = "Vampire";
		this.aboutUnit = "Vampire:\nЗдоровье 100 ед.\nСила атаки 25 ед.\nШаг 3\nРадиус атаки 1\nОсобености:\nпри атаке / контратаке потребляет часть\nжизненных сил противника";
	}

}
