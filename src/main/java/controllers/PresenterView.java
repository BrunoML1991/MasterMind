package controllers;

public interface PresenterView {

    int getTurn();

    char[] boardData(int turn);

    int[] matchesObtained (int turn);

}
