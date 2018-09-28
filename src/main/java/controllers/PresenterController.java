package controllers;

public interface PresenterController {

    int getTurn();

    char[] boardData(int turn);

    int[] matchesObtained (int turn);

}
