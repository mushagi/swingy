package services;

import models.messages.GameResults;


public class GameResultsService {
    private GameResults gameResults;

    public GameResultsService(GameResults gameResults) {
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

    void isGameWon(boolean isGameWon) {
        gameResults.setHeroWon(false);
    }
}
