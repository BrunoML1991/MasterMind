package controllers;

import models.Game;
import models.State;

public class StartController extends OperationController {

	int users;

	protected StartController(Game game) {
		super(game);
	}

	public void setUsers(int users) {
		assert this.getState() == State.INITIAL;
		this.users = users;
		this.setSecretCode();
		this.setState(State.IN_GAME);
	}

	public int getUsers() {// Esto hay que ver si lo usa alguien
		return users;
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
