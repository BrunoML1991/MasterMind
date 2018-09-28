package controllers;

public interface OperationControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(PutController putController);
	
	void visit(ContinueController continueController);

}
