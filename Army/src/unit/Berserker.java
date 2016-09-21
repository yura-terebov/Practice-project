package unit;

import abilities.DefaultAttack;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.ItIsBerserkException;
import exeption.UnitIsDeadException;

import static unit.Classes.*;

public class Berserker extends Unit {
	
	public Berserker(String name) throws FielBusyException, InvalidParamException {
		super(name, 100, 3);
		this.ability = new DefaultAttack(this, 30);
		unit_class = BERSERKER;
		this.image = "Berserk";
		this.aboutUnit = "Berserk:\nЗдоровье 100 ед.\nСила атаки 30 ед.\nШаг 3\nРадиус атаки 1\nОсобености:\nна героя не действует магия";
	}
	
	public void takeMagicDamage(int damage) throws UnitIsDeadException, ItIsBerserkException {
		throw new ItIsBerserkException();
	}
}
