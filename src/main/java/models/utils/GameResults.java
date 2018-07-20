package models.utils;

import lombok.Getter;
import lombok.Setter;
import models.players.Player;

@Setter @Getter
public class GameResults {
    Player playerWon;
    Player playerLost;
    String result;
    GameErrorMessage gameErrorMessage;

    public GameResults() {
        gameErrorMessage = new GameErrorMessage();
        result = "";
    }

    public void clear()
    {
        playerWon = null;
        playerLost = null;
        result = "";
        gameErrorMessage.setErrorMessage("");
        gameErrorMessage.setHasError(false);
    }
}