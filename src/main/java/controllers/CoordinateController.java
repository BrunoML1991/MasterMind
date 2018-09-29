package controllers;

public interface CoordinateController {

    char[] getCode();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);

}
