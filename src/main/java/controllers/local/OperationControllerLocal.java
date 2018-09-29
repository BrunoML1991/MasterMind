package controllers.local;

import controllers.OperationController;
import models.Game;

public abstract class OperationControllerLocal extends Controller implements OperationController {
	
	public OperationControllerLocal(Game game) {
		super(game);
	}
	
}
