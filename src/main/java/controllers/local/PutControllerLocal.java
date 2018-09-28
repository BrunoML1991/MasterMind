package controllers.local;

import controllers.OperationControllerVisitor;
import controllers.PutController;
import models.Game;

public class PutControllerLocal extends OperationControllerLocal implements PutController {

	private CoordinateControllerLocal coordinateControllerLocal;

	public PutControllerLocal(Game game, CoordinateControllerLocal coordinateControllerLocal) {
		super(game);
		assert coordinateControllerLocal != null;
		this.coordinateControllerLocal = coordinateControllerLocal;
	}

	@Override
	public void put (char code []) {
		super.put(code);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	public CoordinateControllerLocal getCoordinateController(){
		return coordinateControllerLocal;
	}

}
