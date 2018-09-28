package controllers;

import models.Game;

public abstract class OperationController extends Controller{
	
	public OperationController(Game game) {
		super(game);
	}
	
	public abstract void accept (OperationControllerVisitor operationControllerVisitor);
	
}
