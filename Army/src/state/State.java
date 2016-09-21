package state;

public class State {
	public int hp;
	public int maxhp;
	public int mana;
	public int maxmana;
	public boolean isWerewolf;
	
	public State(int hp, int mana) {
		this.hp = hp;
		this.maxhp = hp;
		this.mana = mana;
		this.maxmana = mana;
		isWerewolf = false;
	}
	
	public State(int hp) {
		this(hp, 0);
	}
}
