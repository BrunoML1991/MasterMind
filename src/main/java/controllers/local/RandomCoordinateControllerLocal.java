package controllers.local;

import controllers.RandomCoordinateController;
import models.Game;

public class RandomCoordinateControllerLocal extends CoordinateControllerLocal implements RandomCoordinateController {

    private Game game;

    protected RandomCoordinateControllerLocal(Game game) {
        super(game);
        this.game = game;
    }

    @Override
    public char[] getCode(){
        return game.createRandomeCode();
    }

}
