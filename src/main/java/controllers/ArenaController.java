package controllers;

import enums.EDirection;
import factory.HeroFactory;
import lombok.Getter;
import models.players.Hero;
import models.players.Player;
import models.world.Arena;
import java.util.Random;

import static state.GameStrings.*;

public class ArenaController {
    @Getter private Arena arena;
    private final MapController mapController;
    private final GameResultsController gameResultsController;
    private final BattleManager battleService;
    private final HeroController heroController;

    public ArenaController(Arena arena,
                           MapController mapController,
                           GameResultsController gameResultsController,
                           BattleManager battleManager,
                           HeroController heroController) {
        this.arena = arena;
        this.mapController = mapController;
        this.gameResultsController = gameResultsController;
        this.battleService = battleManager;
        this.heroController = heroController;
    }

    void moveHero(EDirection direction) {
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

    void fight() {
        gameResultsController.clearGameResults();
        if (arena.isPlayerInABattle()) {
            Player enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            Player won = battleService.battle(arena.getHero(), enemy);
            if (won == arena.getHero())
                heroWon(won, enemy);
            else
                gameOver(enemy);
        }
        else
            gameResultsController.setGameError(ILLEGAL_ATTACK_NO_ENEMY);
    }

    private void heroWon(Player won, Player lost) {
        arena.setPlayerInABattle(false);
        gameResultsController.addMessage(getWinningMessage(getWinningMessage(won.getName())));
        heroController.updateExperience(lost);
        heroController.heroLevelUp();
        mapController.addPlayer(won);
    }

    private void gameOver(Player enemy) {
        gameResultsController.addMessage(getWinningMessage(enemy.getName()));
        gameResultsController.isGameWon(false);
        arena.setGameInProgress(false);
    }

    void runAway() {
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
    }

    void inValidInput() {
        gameResultsController.clearGameResults();
        gameResultsController.setGameError(INVALID_ACTION);
    }

    void registerHero(String type, String name) {
        Hero hero = HeroFactory.newHero(type, name);
        registerHero(hero);
    }

    void registerHero(Hero hero) {
        arena.setHero(hero);
        arena.setGameInProgress(true);
        heroController.registerHero(hero);
        gameResultsController.clearGameResults();
        mapController.addMapValues(hero);

        arena.setPlayerInABattle(false);
    }
}