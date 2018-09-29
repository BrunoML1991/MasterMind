package controllers.local;

import models.Game;
import masterMind.Logic;

public class LogicLocal implements Logic{

	private Game game;
	private StartControllerLocal startController;
	private PutControllerBuilderLocal putController;
	private ContinueControllerLocal continueController;
	
	public LogicLocal() {
		game = new Game();
		putController = new PutControllerBuilderLocal(game);
		startController = new StartControllerLocal(game,putController);
		continueController = new ContinueControllerLocal(game);
	}
	
	public OperationControllerLocal getController () {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
				return putController.getOperationController();
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
	
}
