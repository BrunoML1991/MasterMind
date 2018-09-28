package models;

public class Turn {

	private int value = 1;
	public static final int MAX_TURNS = 10;

	public void changeTurn() {
		value++;
	}
	public int getTurn () {
		return this.value;
	}

	public void setTurn (int value) {
		this.value = value;
	}
	
}
