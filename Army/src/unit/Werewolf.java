package unit;

import static unit.Classes.*;

import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;

public class Werewolf extends Unit {

	public Werewolf(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 3);
		this.ability = new DefaultAttack(this, 20);
		state.isWerewolf = true;
		unit_class = WEREWOLF;
		this.image = "WerewolfNoTransform";
		this.aboutUnit = "Werewolf:\nЗдоровье 100 ед.\nСила атаки 20 ед.\nШаг 3\nРадиус атаки 1\nОсобености:\nумеет превращаться в волка";
	}

}
