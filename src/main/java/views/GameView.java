package views;

import controllers.Error;
import controllers.OperationController;
import controllers.PutController;
import controllers.RandomCoordinateController;
import controllers.UserCoordinateController;
import models.Board;
import models.Color;
import models.Turn;
import utils.IO;

public class GameView {

    private IO io = new IO();

    public void interact (PutController putController){
        if (putController.getCoordinateController() instanceof UserCoordinateController) {
            io.writeln("Haga su jugada de " + Board.CODE_LENGTH + " letras mayusculas " + Error.NOT_COLOR + ":");
            putController.put(this.readCode());
        } else if(putController.getCoordinateController() instanceof RandomCoordinateController) {
            putController.put(putController.getCoordinateController().getCode());
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

    private char[] readCode() {
        char[] code;
        do {
            code = io.readString().toCharArray();
            if (code.length != Board.CODE_LENGTH || !this.isInColor(code)) {
                io.writeln(Error.NOT_CODELENGTH + " y comprendido en " + Error.NOT_COLOR);
            }
        } while (!this.checkCode(code));
        return code;
    }

    private boolean checkCode(char letters[]) {
        assert letters != null;
        boolean ok = true;
        if (letters.length != Board.CODE_LENGTH || !this.isInColor(letters)) {
            ok = false;
        }
        return ok;
    }

    private boolean isInColor(char letters[]) {
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
        io.writeln(title);
        new BoardView(controller).writeSecretCode();
    }


}
