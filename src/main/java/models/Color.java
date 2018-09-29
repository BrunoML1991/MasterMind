package models;

public enum Color {
	AMARILLO('A'),
	ROJO ('R'),
	VERDE('V'),
	AZUL ('Z'),
	BLANCO ('B'),
	NEGRO ('N'),
	NONE ('_');
	
	private char value;

	private Color (char value) {
		this.value = value;
	}
	
	public char getColor() {
		return value;
	}
		
}
