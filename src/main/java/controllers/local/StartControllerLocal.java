package controllers.local;

import controllers.OperationControllerVisitor;
import controllers.StartController;
import models.Game;
import models.State;

public class StartControllerLocal extends OperationControllerLocal implements StartController {

	private PutControllerBuilderLocal putControllerBuilderLocal;

	protected StartControllerLocal(Game game,PutControllerBuilderLocal putControllerBuilderLocal) {
		super(game);
		assert putControllerBuilderLocal != null;
		this.putControllerBuilderLocal = putControllerBuilderLocal;
	}

	@Override
	public void start(int users) {
		assert this.getState() == State.INITIAL;
		putControllerBuilderLocal.build(users);
		this.setSecretCode();
		this.setState(State.IN_GAME);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
