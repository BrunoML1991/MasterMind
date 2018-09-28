package views;

import utils.IO;
import utils.LimitedIntDialog;
import utils.YesNoDialog;
import controllers.StartController;
import controllers.PutController;
import models.Board;
import models.Color;
import models.Turn;
import controllers.OperationController;
import controllers.OperationControllerVisitor;
import controllers.Error;
import controllers.ContinueController;

public class MasterMindView implements OperationControllerVisitor{

	IO io = new IO();
	int users;

	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		io.write("0. Demo\n1. Partida\n");
		this.users = new LimitedIntDialog("Opcion?", 0, 1).read();
		startController.setUsers(users);
	}

	@Override
	public void visit(PutController putController) {
		if (this.users == 1) {
			io.writeln("Haga su jugada de " + Board.CODE_LENGTH + " letras mayusculas " + Error.NOT_COLOR + ":");
			putController.put(this.readCode());
		} else {
			putController.put(putController.createRandomCode());
			io.readString("Pulse intro para continuar");
		}
		new BoardView(putController).writeBoard();
		if (putController.isVictory()) {
			this.victoryOrDefeat("Victoria este era el código secreto:", putController);
		}
		if (putController.getTurn() == Turn.MAX_TURNS) {
			this.victoryOrDefeat("Derrota este era el código secreto:", putController);
		} else {
			putController.changeTurn();
		}
	}

	@Override
	public void visit(ContinueController continueController) {
		continueController.setContinue(new YesNoDialog("Desea continuar").read());
	}

	public char[] readCode() {
		char code[];
		IO io = new IO();
		do {
			code = io.readString().toCharArray();
			if (code.length != Board.CODE_LENGTH || !this.isInColor(code)) {
				io.writeln(Error.NOT_CODELENGTH + " y comprendido en " + Error.NOT_COLOR);
			}
		} while (!this.checkCode(code));
		return code;
	}

	public boolean checkCode(char letters[]) {
		assert letters != null;
		boolean ok = true;
		if (letters.length != Board.CODE_LENGTH || !this.isInColor(letters)) {
			ok = false;
		}
		return ok;
	}

	public boolean isInColor(char letters[]) {
		assert letters != null;
		boolean ok = false;
		int contador = 0;
		for (int i = 0; i < Color.values().length; i++) {
			for (int j = 0; j < letters.length; j++) {
				if (letters[j] == Color.values()[i].getColor()) {
					contador++;
				}
			}
		}
		if (contador == letters.length) {
			ok = true;
		}
		return ok;
	}

	private void victoryOrDefeat(String title, OperationController controller) {
		new IO().writeln(title);
		controller.writeSecretCode();
	}

}
