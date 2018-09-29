package masterMind;

import controllers.OperationController;
import controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor{

    void interact(OperationController controller);

}
