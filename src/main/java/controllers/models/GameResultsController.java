package controllers.models;

import models.messages.GameResults;
import models.players.APlayer;
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
        gameResults.getBattleReport().setHeroWinner(isGameWon);
    }

    public void addWinningMessage(Hero hero) {
        addMessage("You won!");
        addMessage("Hero says " + hero.getWinningSpeech());
    }

    public void setEnemyWon(APlayer enemyWon){
        gameResults.setEnemyWon(enemyWon);
    }
    
    public void addAnAttackSimulation(String attackSimulation) {
        gameResults.getBattleReport().getBattleSimulation().add(attackSimulation);
    }
    
    public void isHeroFirstAttacker(boolean isHeroFirstAttacker) {
        gameResults.getBattleReport().setHeroIsFirstAttacker(isHeroFirstAttacker);
    }
	
	public void setWinnerLoser(APlayer winner, APlayer loser) {
		gameResults.getBattleReport().setWinner(winner);
		gameResults.getBattleReport().setLoser(loser);
	}
	
	public void setWasPlayerInBattle() {
    	gameResults.setWasBattle(true);
	}
}
