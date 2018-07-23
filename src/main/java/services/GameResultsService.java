package services;

import models.messages.GameResults;

public class GameResultsService {
    GameResults gameResults;

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

    void registerGameResults(GameResults gameResults)
    {
        this.gameResults = gameResults;
    }

    public void isGameWon(boolean isGameWon) {
        gameResults.setHeroWon(false);
    }
}
