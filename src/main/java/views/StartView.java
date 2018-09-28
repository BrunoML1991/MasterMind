package views;

import controllers.StartController;
import utils.LimitedIntDialog;
import utils.IO;

public class StartView {

    public void interact (StartController startController){
        new IO().write("0. Demo\n1. Partida\n");
        int users = new LimitedIntDialog("Opcion?", 0, 1).read();
        startController.start(users);
    }

}
