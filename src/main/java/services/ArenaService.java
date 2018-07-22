package services;

import enums.Direction;
import factory.ArenaFactory;
import factory.HeroFactory;
import lombok.Getter;
import models.players.Hero;
import models.players.Player;
import models.world.Arena;
import models.world.Position;
import state.GameData;

public class ArenaService {
    @Getter private Arena arena;

    public void movePlayer(Direction direction) {
        clearError();
        if (!arena.isPlayerInABattle()) {
            Position position = arena.getHero().getPosition();
            switch (direction) {
                case EAST:
                    if (isMoveWithinBounds(position.x + 1)) {
                        arena.getMap().removePlayer(position);
                        position.x += 1;
                        checkIfThereIsAnEnemy(position);

                    } else playerReachedDestination();
                    break;
                case WEST:
                    if (isMoveWithinBounds(position.x - 1)) {
                        arena.getMap().removePlayer(position);
                        position.x -= 1;
                        checkIfThereIsAnEnemy(position);

                    } else playerReachedDestination();
                    break;
                case NORTH:
                    if (isMoveWithinBounds(position.y - 1)) {
                        arena.getMap().removePlayer(position);
                        position.y -= 1;
                        checkIfThereIsAnEnemy(position);

                    } else playerReachedDestination();
                    break;
                case SOUTH:
                    if (isMoveWithinBounds(position.y + 1)) {
                        arena.getMap().removePlayer(position);
                        position.y += 1;
                        checkIfThereIsAnEnemy(position);
                    } else playerReachedDestination();
            }
            arena.setLastPlayerDirection(direction);
        } else
            gameError("Cannot move while player is in a battle");
    }

    private void checkIfThereIsAnEnemy(Position position) {
        if (arena.getMap().playerExists(position)) {
            arena.setPlayerInABattle(true);
            gameResults("You encountered an enemy");
        } else
            arena.getMap().addPlayer(arena.getHero());
    }

    private void gameResults(String message) {
        arena.getGameResults().setResult(message);
    }

    private void clearError() {
        arena.getGameResults().clear();
    }

    private void gameError(String message) {
        arena.getGameResults().getGameErrorMessage().setErrorMessage(message);
        arena.getGameResults().getGameErrorMessage().setHasError(true);
    }

    private void playerReachedDestination() {
        arena.setGameInProgress(false);
        gameResults("Player reached Destination. Mission accomplished");

    }

    private boolean isMoveWithinBounds(int value) {
        return value >= 0 && value <= arena.getMap().getSize();
    }

    public void fight() {
        clearError();
        if (arena.isPlayerInABattle()) {
            Player enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            Player won = BattleService.battle(arena.getHero(), enemy);
            gameResults("This guy " + won.getName() +" won");
            arena.setPlayerInABattle(false);
            if (won == arena.getHero())
                arena.getMap().addPlayer(arena.getHero());
        } else
            gameError("Cannot attack while there is no enemy.");
    }

    public void runAway() {
    }

    private void createAndRegisterMap(Hero hero) {
        GameData.arena = ArenaFactory.createNewArena(hero);
        arena = GameData.arena;
    }

    private void centerHero(Hero hero) {
        Position heroPos = hero.getPosition();
        heroPos.x = arena.getMap().getSize() / 2;
        heroPos.y = arena.getMap().getSize() / 2;
    }



    public void inValidInput() {
        gameError("Invalid input");
    }

    public void registerHero(String type, String name) {
        Hero hero = HeroFactory.newHero(type, name);
        createMapAndRegisterHero(hero);
    }

    public void registerHero(Hero hero) {
        createMapAndRegisterHero(hero);
    }

    private void createMapAndRegisterHero(Hero hero) {
        createAndRegisterMap(hero);
        centerHero(hero);
        arena.setHero(hero);
        arena.getMap().addPlayer(hero);
    }
}