package models;

public class Game {

	private State state;
	private Board board;
	private Turn turn;
	
	public Game () {
		state = State.INITIAL;
		turn = new Turn ();
		board = new Board(turn);
	}
	
	public int [] matchesObtained(int turn) {
		int[] matches  = new int[2];
		matches [0]= board.matchPositionAndColor(turn);
		matches [1] = board.matchColor(turn);
		return matches;
	}
	
	public State getState() {
		return this.state;
	}
	
	public void setState (State state) {
		this.state = state;
	}
		
	public void setSecretCode () {
		board.setSecretCode();
	}
	
	public char [] createRandomeCode () {
		return board.createRandomCode();
	}
	
	public void clear () {
		board.clear();
	}
	
	public void setTurn (int value) {
		turn.setTurn(value);
	}
	
	public void put(char[] code) {
		board.put(code);
	}
	
	public int getTurn () {
		return turn.getTurn();
	}
	
	public void changeTurn () {
		turn.changeTurn();
	}
	
	public boolean isVictory () {
		return board.isVictory();
	}
	
	public char[] boardData(int turn){
		return board.boardData(turn);
	}
	
}
