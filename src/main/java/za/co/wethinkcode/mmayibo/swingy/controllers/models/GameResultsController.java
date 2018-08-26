package za.co.wethinkcode.mmayibo.swingy.controllers.models;

import za.co.wethinkcode.mmayibo.swingy.models.messages.GameResults;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;


public class GameResultsController {
    private final GameResults gameResults;

    public GameResultsController(GameResults gameResults) {
        this.gameResults = gameResults;
    }

    public void addMessage(String message) {
	    for (String line: message.split("\n"))
		    gameResults.getResult().add(line);
		    
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

    public void setEnemyWon(AbstractPlayer enemyWon){
        gameResults.setEnemyWon(enemyWon);
    }
    
    public void addAnAttackSimulation(String attackSimulation) {
        gameResults.getBattleReport().getBattleSimulation().add(attackSimulation);
    }
    
    public void isHeroFirstAttacker(boolean isHeroFirstAttacker) {
        gameResults.getBattleReport().setHeroIsFirstAttacker(isHeroFirstAttacker);
    }
	
	public void setWinnerLoser(AbstractPlayer winner, AbstractPlayer loser) {
		gameResults.getBattleReport().setWinner(winner);
		gameResults.getBattleReport().setLoser(loser);
	}
	
	public void setWasPlayerInBattle() {
    	gameResults.setWasBattle(true);
	}
    
    public void setGameErrorActionMove(String actionName) {
        addMessage("Cannot " + actionName + " while there is no enemy");
        addMessage("Try moving the player");
        gameResults.setError(true);
    }
	
	public void setHeroBeforeGame(Hero hero) {
		try {
			gameResults.setHeroBeforeGame((AbstractPlayer) hero.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
