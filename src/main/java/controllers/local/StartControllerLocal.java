package controllers.local;

import controllers.OperationControllerVisitor;
import controllers.StartController;
import models.Game;
import models.State;

public class StartControllerLocal extends OperationControllerLocal implements StartController {

	int users;

	protected StartControllerLocal(Game game) {
		super(game);
	}

	@Override
	public void start(int users) {
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
