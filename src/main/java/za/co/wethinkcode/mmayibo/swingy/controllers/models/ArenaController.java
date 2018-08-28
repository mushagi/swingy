package za.co.wethinkcode.mmayibo.swingy.controllers.models;

import za.co.wethinkcode.mmayibo.swingy.controllers.BattleManager;
import za.co.wethinkcode.mmayibo.swingy.database.IRepository;
import za.co.wethinkcode.mmayibo.swingy.enums.EDirection;
import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import lombok.Getter;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.validators.ModelValidator;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import static za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants.*;

public class ArenaController {
    private final IRepository<Hero> heroRepository;
    @Getter private final Arena arena;
    private final MapController mapController;
    private final GameResultsController gameResultsController;
    private final BattleManager battleManager;
    private final HeroController heroController;
    private final Random random = new Random();

    public ArenaController(Arena arena,
                           MapController mapController,
                           GameResultsController gameResultsController,
                           BattleManager battleManager,
                           HeroController heroController,
                           IRepository<Hero> heroRepository) {
        this.arena = arena;
        this.mapController = mapController;
        this.gameResultsController = gameResultsController;
        this.battleManager = battleManager;
        this.heroController = heroController;
        this.heroRepository = heroRepository;
    }

    public void moveHero(EDirection direction) {
        gameResultsController.clearGameResults();
        heroController.setLastPoint();
        
        if (!arena.isPlayerInABattle()) {
            if (mapController.isMoveWithinBounds(direction)) {
                if (!mapController.moveHeroInTheMap(direction))
                    setHeroToBattle();
            }
            else
                playerReachedDestination();
        }
        else
            gameResultsController.setGameError(ILLEGAL_MOVE_BATTLE_IN_PROGRESS);
    }

    public void fight() {
        if (arena.isHeroRunningAway())
            arena.setHeroRunningAway(false);
        else
            gameResultsController.clearGameResults();

        if (arena.isPlayerInABattle()) {
            AbstractPlayer enemy = mapController.getPlayer(getHero().getPosition());
            AbstractPlayer won = battleManager.battle(arena.getHero(), enemy);
            if (won == arena.getHero())
                onHeroWon(won, enemy);
            else
                onHeroLost(enemy);
	        gameResultsController.setWasPlayerInBattle();
        }
        else
            gameResultsController.setGameErrorActionMove("fight");
    }

    private void onHeroWon(AbstractPlayer won, AbstractPlayer playerWonAgainst) {
    	dropArtificat(playerWonAgainst);
        arena.setPlayerInABattle(false);
        gameResultsController.addWinningMessage(arena.getHero());
        gameResultsController.isGameWon(false);
        heroController.updateExperience(playerWonAgainst);
        heroController.heroLevelUp();
        heroRepository.update(getHero());
        mapController.addPlayer(won);
    }
	
	private void dropArtificat(AbstractPlayer player) {
    	int randomNumber = random.nextInt(5);
    	if (randomNumber == 2) {
		    Artifact randomDroppedArtificat = getRandomDroppedArtificact(player);
		    if (randomDroppedArtificat != null){
			    mapController.addArtificat(player.getPosition(), randomDroppedArtificat);
			    gameResultsController.addMessage("Artificat has been dropped");
		    }
	    }
	}
	
	private Artifact getRandomDroppedArtificact(AbstractPlayer player) {
    	ArrayList<Artifact> artifacts = (ArrayList<Artifact>) player.getArtifacts();
    	int numberOfPlayerArtificats = artifacts.size();
		if (numberOfPlayerArtificats> 0) {
    		int randomNumber = random.nextInt(numberOfPlayerArtificats);
    		return artifacts.get(randomNumber);
	    }
		return null;
	}
	
	private void onHeroLost(AbstractPlayer enemy) {
        gameResultsController.addMessage(enemy.getWinningSpeech());
        gameResultsController.isGameWon(false);
        gameResultsController.setEnemyWon(enemy);
        arena.setGameInProgress(false);
    }

    public void runAway() {
	    gameResultsController.clearGameResults();
	
	    if (arena.isPlayerInABattle()) {
            boolean isRunningAwayAllowed = random.nextBoolean();
            if (isRunningAwayAllowed && mapController.heroFoundARunAwayPosition()) {
                heroController.returnToLastPoint();
                mapController.addPlayer(arena.getHero());
                arena.setHeroRunningAway(true);
                gameResultsController.addMessage(RUN_AWAY_SUCCESS_MESSAGE);
            }
            else {
                gameResultsController.addMessage(RUN_AWAY_FAILURE_MESSAGE);
                fight();
            }
            
            arena.setPlayerInABattle(false);
        }
        else
            gameResultsController.setGameErrorActionMove("run away");
    }

    private void setHeroToBattle() {
        arena.setPlayerInABattle(true);
        gameResultsController.addMessage(ENEMY_COLLISION_MESSAGE);
    }

    private void playerReachedDestination() {
        arena.setGameInProgress(false);
        gameResultsController.addMessage(MISSION_ACCOMPLISHED_MESSAGE);
        gameResultsController.isGameWon(true);
    }

    public void createHero(HeroType type) {
        Hero hero;
        hero = heroController.createHero(type);
        heroRepository.create(hero);
        initArena(hero);
    }

    public ArrayList<Hero> getAllHeroes() {
        return heroRepository.getALL();
    }

    public void initArena(Hero hero) {
        heroController.validateHero(hero);
        arena.setHero(hero);
        arena.setGameInProgress(true);
        arena.setPlayerInABattle(false);
        heroController.registerHero(hero);
        gameResultsController.clearGameResults();
        gameResultsController.setHeroBeforeGame(hero);
        mapController.addMapValues(hero);
    }


    public void loadPlayerName(String name) {
    	gameResultsController.clearGameResults();
    	heroController.setName(name);
	    Set<ConstraintViolation<AbstractPlayer>> violations =
			    ModelValidator.getInstance().validatePlayer(arena.getHero());
	    if (violations.isEmpty()) {
		    arena.setPlayerName(name);
		    arena.setPLayerNameLoaded(true);
		    heroRepository.create(arena.getHero());
		
	    }
	    else {
		    for (ConstraintViolation<AbstractPlayer> violation: violations)
		    	gameResultsController.setGameError(violation.getMessage());
	    }

    }

    public boolean isGameInProgress() {
        return arena.isGameInProgress();
    }

    public boolean isPLayerNameLoaded() {
        return arena.isPLayerNameLoaded();
    }

    public boolean didHeroWin() {
        return arena.getGameResults().isHeroWon();
    }

    public Hero getHero() {
        return arena.getHero();
    }

    public Hero getByID(int heroId) {
        return heroRepository.getByID(heroId);
    }

    public void setGameInProgress(boolean isGameInProgress) {
        arena.setGameInProgress(isGameInProgress);
    }
	
	public void pickUpObject() {
        gameResultsController.clearGameResults();
        ArrayList<Artifact> artifact = mapController.getDroppedArtificat();
        if (artifact != null) {
            heroController.addArtificats(artifact);
            gameResultsController.addMessage("Artificact added");
            mapController.clearDroppedArtificacts();
        }
        else
            gameResultsController.addMessage("No artificat in this position");
	}
	
	public void clearArena() {
		arena.setHero(null);
        arena.setPlayerName(null);
        arena.setPLayerNameLoaded(false);
        clearForNewGame();
	}

    public void clearForNewGame() {
        arena.setPlayerInABattle(false);
        arena.setGameInProgress(true);
        arena.setHeroRunningAway(false);
        gameResultsController.clearGameResults();
        mapController.clear();
    }
}