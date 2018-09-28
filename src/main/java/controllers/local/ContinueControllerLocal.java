package controllers.local;

import controllers.ContinueController;
import controllers.OperationControllerVisitor;
import models.Game;
import models.State;

public class ContinueControllerLocal extends OperationControllerLocal implements ContinueController {

	public ContinueControllerLocal(Game game) {
		super(game);
	}

	@Override
	public void resume(boolean ok) {
		assert this.getState() == State.FINAL;
		if (ok) {
			this.clear();
			this.setTurn(1);
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
