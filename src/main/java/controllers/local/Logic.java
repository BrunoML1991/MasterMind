package controllers.local;

import models.Game;

public class Logic {

	private Game game;
	private StartControllerLocal startController;
	private PutControllerLocal putController;
	private ContinueControllerLocal continueController;
	
	public Logic () {
		game = new Game();
		startController = new StartControllerLocal(game);
		putController = new PutControllerLocal(game);
		continueController = new ContinueControllerLocal(game);
	}
	
	public OperationControllerLocal getController () {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
				return putController;
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
	
}
