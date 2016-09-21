package board;

import unit.*;
import unit.spellcaster.*;

import java.awt.Point;

import exeption.*;


public class Board {

	public static final  Unit[][] board = generateInitUnits();
	public static Point selectedUnit = null;
	public static Point selectedWarlockSpell = null;
	public static Point selectMagesSpell = null;
	
	private static Unit[][] generateInitUnits() {
		try {
			return new Unit[][] {
				{new Werewolf("Werewolf"),new Healer("Healer"),new Priest("Priest"),new Necromancer("Necromancer"),new Rogue("Rogue"),new Warlock("Warlock"),new Archer("Archer"),new Wizard("Wizard")},
				{null,new Soldier("Soldier"),null,null,new Berserker("Berserker"),null,new Vampire("Vampire"),null},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{null,new Soldier("Soldier"),null,null,new Berserker("Berserker"),null,new Vampire("Vampire"),null},
				{new Werewolf("Werewolf"),new Healer("Healer"),new Priest("Priest"),new Necromancer("Necromancer"),new Rogue("Rogue"),new Warlock("Warlock"),new Archer("Archer"),new Wizard("Wizard")}};
		} catch (FielBusyException | InvalidParamException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int distance(Point other, int x, int y){
		
			int temp;
			if ( x == other.x ) {
				temp = y - other.y;
				if ( temp < 0 ) {
					temp *= -1;
				}
				return temp;
			}
			
			if ( y == other.y ) {
				temp = x - other.x;
				if ( temp < 0 ) {
					temp *= -1;
				}
				return temp;
			}
		
		
		int dx = x - other.x;
		int dy = y - other.y;
		
		if ( dx < 0) {
			dx *= -1;
		}
		if ( dy < 0) {
			dy *= -1;
		}

		if ( dx >= dy ) {
			return dx;
		} else {
			return dy;
		}
	}
	
	
	
 }
	
//new Soldier("Soldier", 100, 30),new Wizard("Wizard", 60, 100),new Rogue("Rogue", 100, 35),new Healer("Healer", 60, 100),new Berserker("Berserk", 100, 30),new Archer("Archer", 100, 30),new Vampire("Vampire", 100, 30),new Necromancer("Necromancer", 60, 100)