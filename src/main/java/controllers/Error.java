package controllers;

import models.Board;

public enum Error {
	NOT_COLOR("[A, R, V, Z, B y N]"),
	NOT_CODELENGTH ("El código debe ser de "+Board.CODE_LENGTH+" caracteres");
	
	private String message;
	
	private Error(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	
}
