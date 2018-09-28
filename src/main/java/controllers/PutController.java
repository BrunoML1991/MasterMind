package controllers;

import models.Game;

public class PutController extends OperationController {

	public PutController(Game game) {
		super(game);
	}
	
	public void put (char code []) {
		super.put(code);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
