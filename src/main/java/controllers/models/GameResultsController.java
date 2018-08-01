package controllers.models;

import models.messages.GameResults;


public class GameResultsController {
    private final GameResults gameResults;

    public GameResultsController(GameResults gameResults) {
        this.gameResults = gameResults;
    }

    void addMessage(String message) {
        gameResults.getResult().add(message);
    }

    void clearGameResults() {
        gameResults.clear();
    }

    void setGameError(String message) {
        addMessage(message);
        gameResults.setError(true);
    }

    void isGameWon() {
        gameResults.setHeroWon(false);
    }
}