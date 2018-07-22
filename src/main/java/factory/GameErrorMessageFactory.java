package factory;

import models.messages.GameErrorMessage;

class GameErrorMessageFactory {

    public static GameErrorMessage newGameErrorMessage(){
        return new GameErrorMessage();
    }
}
