package controllers;

import models.Game;
import models.State;
import models.Turn;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}

	protected State getState() {
		return game.getState();
	}

	public void setState(State state) {
		assert state != null;
		game.setState(state);
	}
	
	protected void setSecretCode() {
		game.setSecretCode();
	}
	
	public char [] createRandomCode () {
		return game.createRandomeCode();
	}
	
	protected void clear () {
		game.clear();
	}
	
	protected void setTurn (int value) {
		game.setTurn(value);
	}
	
	protected void put(char code[]) {
		game.put(code);
		if (this.isVictory()) {
			this.setState(State.FINAL);
		}
		if (this.getTurn() == Turn.MAX_TURNS) {
			this.setState(State.FINAL);
		}
	}
	
	protected void writeBoard() {// este habrá que quitarlo
		game.writeBoard();
	}
	
	public int getTurn () {
		return game.getTurn();
	}
	
	public void changeTurn () {
		game.changeTurn();;
	}
	
	public void writeSecretCode () {
		game.writeSecretCode();
	}
	
	public boolean isVictory () {
		return game.isVictory();
	}
	
	public int[] matchesObtained (int turn) {
		return game.matchesObtained(turn);
	}
	
	public char[] boardData(int turn){
		return game.boardData(turn);
	}
	
	public int getNumPlayers () {
		return game.getNumPlayers();
	}
	
}
