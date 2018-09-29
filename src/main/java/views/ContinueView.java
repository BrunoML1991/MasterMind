package views;

import controllers.ContinueController;
import utils.YesNoDialog;

public class ContinueView {

    public void interact (ContinueController continueController){
        continueController.resume(new YesNoDialog("Desea continuar").read());
    }

}
