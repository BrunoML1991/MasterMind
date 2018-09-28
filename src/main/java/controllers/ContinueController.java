package controllers;

import models.Game;
import models.State;

public class ContinueController extends OperationController {

	public ContinueController(Game game) {
		super(game);
	}

	public void setContinue(boolean ok) {
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
