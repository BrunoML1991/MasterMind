package controllers.local;

import controllers.UserCoordinateController;
import models.Game;

public class UserCoordinateControllerLocal extends CoordinateControllerLocal implements UserCoordinateController {

    private Game game;

    protected UserCoordinateControllerLocal(Game game) {
        super(game);
        this.game = game;
    }

    @Override
    public char[] getCode(){
        return game.createRandomeCode();
    }

}
