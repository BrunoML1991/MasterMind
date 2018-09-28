package views;

import utils.IO;
import controllers.Controller;

public class BoardView {

	private Controller controller;

	public BoardView(Controller controller) {
		assert controller != null;
		this.controller = controller;
	}

	public void writeBoard() {// este habrá que quitarlo
		for (int i = 0; i < controller.getTurn()+1; i++) {
			int [] matches = controller.matchesObtained(i);
			new IO().writeln(i + " " + this.charArrayToString(controller.boardData(i)) + " Muertos: "
					+ matches [0] + " Heridos: " + matches [1]);
		}
	}

	public String charArrayToString(char array[]) {
		assert array != null;
		String string = "";
		for (int i = 0; i < array.length; i++) {
			string += array[i];
		}
		return string;
	}
}
