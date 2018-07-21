package factory;

import models.utils.GameErrorMessage;

class GameErrorMessageFactory {

    public static GameErrorMessage newGameErrorMessage(){
        return new GameErrorMessage();
    }
}
