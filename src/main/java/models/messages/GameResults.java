package models.messages;

import lombok.Getter;
import lombok.Setter;
import models.players.Player;

@Setter @Getter
public class GameResults {
    String result;
    boolean heroWon;
    GameErrorMessage gameErrorMessage;

    public GameResults() {
        gameErrorMessage = new GameErrorMessage();
        result = "";
    }

    public void clear()
    {
        result = "";
        gameErrorMessage.setErrorMessage("");
        gameErrorMessage.setHasError(false);
        heroWon = false;
    }
}