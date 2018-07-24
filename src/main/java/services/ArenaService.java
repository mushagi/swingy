package services;

import enums.Direction;
import factory.HeroFactory;
import lombok.Getter;
import models.players.Hero;
import models.players.Player;
import models.world.Arena;
import utils.Formulas;

import java.util.Random;

import static state.Messages.*;

public class ArenaService {
    @Getter private Arena arena;
    private final MapService mapService;
    private final GameResultsService gameResultsService;
    private final BattleService battleService;

    public ArenaService(Arena arena, MapService mapService, GameResultsService gameResultsService, BattleService battleService) {
        this.arena = arena;
        this.mapService = mapService;
        this.gameResultsService = gameResultsService;
        this.battleService = battleService;
    }

    public void moveHero(Direction direction) {
        gameResultsService.clearGameResults();
        if (!arena.isPlayerInABattle()) {
            if (mapService.isMoveWithinBounds(direction)) {
                if (!mapService.moveHeroInTheMap(direction))
                    setHeroToBattle();
            }
            else
                playerReachedDestination();
        }
        else
            gameResultsService.setGameError(ILLEGAL_MOVE_BATTLE_IN_PROGRESS);
    }

    public void fight() {
        gameResultsService.clearGameResults();
        if (arena.isPlayerInABattle()) {
            Player enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            Player won = battleService.battle(arena.getHero(), enemy);
            if (won == arena.getHero())
                heroWon(won);
            else
                gameOver(enemy);
        }
        else
            gameResultsService.setGameError(ILLEGAL_ATTACK_NO_ENEMY);
    }

    private void heroWon(Player won) {
        gameResultsService.addMessage(getWinningMessage(getWinningMessage(won.getName())));
        arena.setPlayerInABattle(false);
        heroLevelUp();
    }

    private void heroLevelUp() {
        int level = getLevel(arena.getHero().getExperience(), arena.getHero().getLevel());
        arena.getHero().setLevel(level);
    }

    int getLevel(int experience, int level) {
        if (experience < Formulas.calculateRequiredLevelExperience(level + 1))
            return level;
        return getLevel(experience, ++level);
    }

    private void gameOver(Player enemy) {
        gameResultsService.addMessage(getWinningMessage(enemy.getName()));
        gameResultsService.isGameWon(false);
        arena.setGameInProgress(false);
    }

    public void runAway() {
        if (arena.isPlayerInABattle()) {
            Random random = new Random();
            boolean isRunningAwayAllowed = random.nextBoolean();
            if (isRunningAwayAllowed && mapService.heroFoundARunAwayPosition())
                gameResultsService.addMessage(RUN_AWAY_SUCCESS_MESSAGE);
            else {
                gameResultsService.addMessage(RUN_AWAY_FAILURE_MESSAGE);
                fight();
            }
            arena.setPlayerInABattle(false);
        }
        else
            gameResultsService.setGameError(ILLEGAL_MOVE_BATTLE_IN_PROGRESS);
    }

    private void setHeroToBattle() {
        arena.setPlayerInABattle(true);
        gameResultsService.addMessage(ENEMY_COLLISION_MESSAGE);
    }

    private void playerReachedDestination() {
        arena.setGameInProgress(false);
        gameResultsService.addMessage(MISSION_ACCOMPLISHED_MESSAGE);
    }

    public void inValidInput() {
        gameResultsService.setGameError(INVALID_ACTION);
    }

    public void registerHero(String type, String name) {
        Hero hero = HeroFactory.newHero(type, name);
        registerHero(hero);
    }

    public void registerHero(Hero hero) {
        arena.setHero(hero);
        mapService.addMapValues(hero);
    }
}