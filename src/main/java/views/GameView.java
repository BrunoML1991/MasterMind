package views;

import controllers.PutController;
import controllers.OperationController;
import models.Turn;
import utils.IO;

public class GameView {

    private IO io = new IO();

    public void interact (PutController putController){
        putController.put(new PutCodeView(putController.getCoordinateController()).getCode());
        new BoardView(putController).writeBoard();
        if (putController.isVictory()) {
            this.victoryOrDefeat("Victoria este era el codigo secreto:", putController);
        }
        if (putController.getTurn() == Turn.MAX_TURNS) {
            this.victoryOrDefeat("Derrota este era el codigo secreto:", putController);
        } else {
            putController.changeTurn();
        }
    }

    private void victoryOrDefeat(String title, OperationController controller) {
        io.writeln(title);
        new BoardView(controller).writeSecretCode();
    }


}
