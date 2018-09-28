package controllers.local;

import controllers.OperationController;
import models.Game;

public class PutControllerBuilderLocal {

    private Game game;
    private OperationControllerLocal operationControllers;

    PutControllerBuilderLocal (Game game){
        this.game = game;
    }

    public void build(int users){

        if(users == 1){
            operationControllers  = new PutControllerLocal (game,new UserCoordinateControllerLocal(game));
        }else{
            operationControllers = new PutControllerLocal(game,new RandomCoordinateControllerLocal(game));
        }

    }

    OperationControllerLocal getOperationController (){
        return operationControllers;
    }

}
