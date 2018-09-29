package controllers;

public interface OperationController extends PresenterController {

	void accept(OperationControllerVisitor operationControllerVisitor);

}

