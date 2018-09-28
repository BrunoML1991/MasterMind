package controllers;

public interface OperationController extends PresenterView {

	void accept(OperationControllerVisitor operationControllerVisitor);

}

