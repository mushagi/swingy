package controllers.models;

import models.messages.GameResults;
import models.players.APlayer;
import models.players.Enemy;
import models.players.Hero;


public class GameResultsController {
    private final GameResults gameResults;

    public GameResultsController(GameResults gameResults) {
        this.gameResults = gameResults;
    }

    public void addMessage(String message) {
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
        gameResults.setHeroWon(isGameWon);
    }

    public void addWinningMessage(Hero hero) {
        addMessage("You won!");
        addMessage("Hero says " + hero.getWinningSpeech());
    }

    public void setEnemyWon(APlayer enemyWon){
        gameResults.setEnemyWon(enemyWon);
    }
}
