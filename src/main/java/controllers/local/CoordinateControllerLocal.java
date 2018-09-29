package controllers.local;

import controllers.CoordinateController;
import models.Game;

public abstract class CoordinateControllerLocal extends Controller implements CoordinateController {

    protected CoordinateControllerLocal(Game game) {
        super(game);
    }

}
