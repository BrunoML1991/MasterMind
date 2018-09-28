package models;

import java.util.HashMap;
import java.util.Map;

public class Board {

	public static final int CODE_LENGTH = 4;
	public static final int NUM_PLAYERS = 1;

	private Map<Integer, char[]> map;
	Turn turn;

	public Board(Turn turn) {
		assert turn != null;
		this.turn = turn;
		map = new HashMap<>();
	}

	public int matchColor(int turn) {
		int match = 0;
		int[] secretCode = this.colorsInCode(0);
		int[] turnCode = this.colorsInCode(turn);
		int[] colorsAndPositionMatched = this.howMuchColorsAndPositionMatched(turn);
		for (int i = 0; i < Color.values().length; i++) {
			secretCode[i] -= colorsAndPositionMatched[i];
			turnCode[i] -= colorsAndPositionMatched[i];
		}
		for (int i = 0; i < Color.values().length; i++) {
			if (secretCode[i] > 0 && turnCode[i] > 0) {
				if (secretCode[i] < turnCode[i]) {
					match += secretCode[i];
				} else {
					match += turnCode[i];
				}
			}
		}
		return match;
	}

	public int[] colorsInCode(int codeId) {
		int[] colors = new int[Color.values().length];
		for (int i = 0; i < Color.values().length; i++) {
			colors[i] = 0;
		}
		for (int i = 0; i < map.get(0).length; i++) {
			for (int j = 0; j < Color.values().length; j++) {
				if (map.get(codeId)[i] == Color.values()[j].getColor()) {
					colors[j] += 1;
				}
			}
		}
		return colors;
	}

	public int[] howMuchColorsAndPositionMatched(int turn) {
		int[] match = new int[Color.values().length];
		char[] secretCode = map.get(0);
		char[] turnCode = map.get(turn);
		for (int i = 0; i < Color.values().length; i++) {
			match[i] = 0;
		}
		for (int i = 0; i < map.get(0).length; i++) {
			for (int j = 0; j < Color.values().length; j++) {
				if (secretCode[i] == turnCode[i] && secretCode[i] == Color.values()[j].getColor()) {
					match[j] += 1;
				}
			}
		}
		return match;
	}

	public int matchPositionAndColor(int turn) {
		int match = 0;
		int[] matches = this.howMuchColorsAndPositionMatched(turn);
		for (int i = 0; i < Color.values().length; i++) {
			match += matches[i];
		}
		return match;
	}

	public boolean isVictory() {
		boolean ok = false;
		int match = this.matchPositionAndColor(turn.getTurn());
		if (match == map.get(0).length) {
			ok = true;
		}
		return ok;
	}

	public void put(char[] code) {
		assert turn != null;
		map.put(turn.getTurn(), code);
	}

	public void clear() {
		map = new HashMap<>();
	}

	public char[] createRandomCode() {
		char[] secretCode = new char[4];
		for (int i = 0; i < Board.CODE_LENGTH; i++) {
			secretCode[i] = this.randomLetter();
		}
		return secretCode;
	}

	private char randomLetter() {
		char letter;
		letter = Color.values()[(int) (Math.random() * (Color.values().length - 1))].getColor();
		return letter;
	}

	public void setSecretCode() {
		map.put(0, this.createRandomCode());
	}
	
	public char[] boardData(int turn){
		return map.get(turn);
	}

}
