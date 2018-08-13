package controllers.models;

import controllers.BattleManager;
import database.IRepository;
import enums.EDirection;
import enums.HeroType;
import lombok.Getter;
import models.players.APlayer;
import models.players.Hero;
import models.world.Arena;

import java.util.ArrayList;
import java.util.Random;

import static state.GameConstants.*;

public class ArenaController {
    private final IRepository<Hero> heroRepository;
    @Getter private final Arena arena;
    private final MapController mapController;
    private final GameResultsController gameResultsController;
    private final BattleManager battleService;
    private final HeroController heroController;

    public ArenaController(Arena arena,
                           MapController mapController,
                           GameResultsController gameResultsController,
                           BattleManager battleManager,
                           HeroController heroController,
                           IRepository<Hero> heroRepository) {
        this.arena = arena;
        this.mapController = mapController;
        this.gameResultsController = gameResultsController;
        this.battleService = battleManager;
        this.heroController = heroController;
        this.heroRepository = heroRepository;
    }

    public void moveHero(EDirection direction) {
        gameResultsController.clearGameResults();
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
        gameResultsController.clearGameResults();

        if (arena.isPlayerInABattle()) {
            gameResultsController.addMessage("Battle Report");
            
            APlayer enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            APlayer won = battleService.battle(arena.getHero(), enemy);
            if (won == arena.getHero())
                onHeroWon(won, enemy);
            else
                onHeroLost(enemy);
	        gameResultsController.setWasPlayerInBattle();
        }
        else
            gameResultsController.setGameError(ILLEGAL_ATTACK_NO_ENEMY);
    }

    private void onHeroWon(APlayer won, APlayer playerWonAgainst) {
        arena.setPlayerInABattle(false);
        gameResultsController.addWinningMessage(arena.getHero());
        gameResultsController.isGameWon(false);
        heroController.updateExperience(playerWonAgainst);
        heroController.heroLevelUp();
        heroRepository.update(getHero());
        mapController.addPlayer(won);
    }

    private void onHeroLost(APlayer enemy) {
        gameResultsController.addMessage(enemy.getWinningSpeech());
        gameResultsController.isGameWon(false);
        gameResultsController.setEnemyWon(enemy);
        arena.setGameInProgress(false);
    }

    public void runAway() {
	    gameResultsController.clearGameResults();
	
	    if (arena.isPlayerInABattle()) {
            Random random = new Random();
            boolean isRunningAwayAllowed = random.nextBoolean();
            if (isRunningAwayAllowed && mapController.heroFoundARunAwayPosition())
                gameResultsController.addMessage(RUN_AWAY_SUCCESS_MESSAGE);
            else {
                gameResultsController.addMessage(RUN_AWAY_FAILURE_MESSAGE);
                fight();
            }
            arena.setPlayerInABattle(false);
        }
        else
            gameResultsController.setGameError(ILLEGAL_MOVE_BATTLE_IN_PROGRESS);
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
        arena.setHero(hero);
        arena.setGameInProgress(true);
        arena.setPlayerInABattle(false);
        heroController.registerHero(hero);
        gameResultsController.clearGameResults();
        mapController.addMapValues(hero);
        heroRepository.create(hero);
    }

    public void loadPlayerName(String name) {
        arena.setPlayerName(name);
        arena.setPLayerNameLoaded(true);
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
}