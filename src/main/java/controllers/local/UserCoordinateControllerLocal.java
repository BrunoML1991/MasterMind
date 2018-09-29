package controllers.local;

import controllers.UserCoordinateController;
import models.Board;
import models.Game;
import controllers.CoordinateControllerVisitor;

public class UserCoordinateControllerLocal extends CoordinateControllerLocal implements UserCoordinateController {

    private Game game;

    protected UserCoordinateControllerLocal(Game game) {
        super(game);
        this.game = game;
    }

    @Override
    public char[] getCode(){
        return new char[Board.CODE_LENGTH];
    }

    public void accept(CoordinateControllerVisitor coordinateControllerVisitor){
        coordinateControllerVisitor.visit(this);
    }

}
