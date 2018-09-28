package controllers.local;

import controllers.OperationControllerVisitor;
import controllers.PutController;
import models.Game;

public class PutControllerLocal extends OperationControllerLocal implements PutController {

	public PutControllerLocal(Game game) {
		super(game);
	}

	@Override
	public void put (char code []) {
		super.put(code);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
