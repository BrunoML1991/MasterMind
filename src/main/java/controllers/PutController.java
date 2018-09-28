package controllers;

public interface PutController extends OperationController {

	void put (char code []);

	boolean isVictory ();

	void changeTurn();

	char [] createRandomCode();

}
