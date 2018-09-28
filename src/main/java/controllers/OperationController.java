package controllers;

public interface OperationController {

	void accept(OperationControllerVisitor operationControllerVisitor);

	int getTurn();

	char[] boardData(int turn);

	int[] matchesObtained (int turn);

}

