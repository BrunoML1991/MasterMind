package views;

import models.Turn;
import utils.IO;
import controllers.PresenterController;

public class BoardView {

	private PresenterController controller;

	public BoardView(PresenterController controller) {
		assert controller != null;
		this.controller = controller;
	}

	public void writeBoard() {
		for (int i = 0; i < Turn.MAX_TURNS +1; i++) {
			int [] matches = controller.matchesObtained(i);
			new IO().writeln(i + " " + this.charArrayToString(controller.boardData(i)) + " Muertos: "
					+ matches [0] + " Heridos: " + matches [1]);
		}
	}

	public void writeSecretCode() {
		new IO().writeln(this.charArrayToString(controller.boardData(0)));
	}

	public String charArrayToString(char[] array) {
		assert array != null;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			stringBuilder.append(array[i]);
		}
		return stringBuilder.toString();
	}
}
