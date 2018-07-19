package factory;

import models.utils.GameErrorMessage;

public class GameErrorMessageFactory {

    public static GameErrorMessage newGameErrorMessage(){
        return new GameErrorMessage();
    }
}
