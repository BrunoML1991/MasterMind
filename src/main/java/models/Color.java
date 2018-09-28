package models;

public enum Color {
	Amarillo('A'),
	Rojo ('R'),
	Verde('V'),
	Azul ('Z'),
	Blanco ('B'),
	Negro ('N'),
	None ('_');
	
	private char value;

	private Color (char value) {
		this.value = value;
	}
	
	public char getColor() {
		return value;
	}
		
}
