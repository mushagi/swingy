package services;

import factory.ArenaFactory;
import factory.HeroFactory;
import factory.PositionFactory;
import lombok.Getter;
import models.utils.Arena;
import enums.Direction;
import models.utils.Map;
import models.utils.Position;
import models.players.Hero;
import models.players.Player;
import views.UserInterface;

import java.util.ArrayList;


public class ArenaService {
    private static ArenaService arenaService;
    @Getter private Arena arena;
    private  ArrayList<UserInterface> userInterfaces;

    public static ArenaService getInstance() {
        if (arenaService == null)
            arenaService = new ArenaService();
        return arenaService;
    }

    ArenaService() {
        userInterfaces = new ArrayList<>();
    }

    public void movePlayer(Direction direction) {
        clearError();
        if (!arena.isPlayerInABattle()) {
            Position position = arena.getHero().getPosition();
            switch (direction) {
                case EAST:
                    if (isMoveWithinBounds(position.getX(), 1)) {
                        Position oldPosition = PositionFactory.clone(position);
                        position.setX(position.getX() + 1);
                        checkIfThereIsAnEnemy(position, oldPosition);

                    } else playerReachedDestination();
                    break;
                case WEST:
                    if (isMoveWithinBounds(position.getX(), -1)) {
                        position.setX(position.getX() - 1);
                    }
                    else playerReachedDestination();
                    break;
                case NORTH:
                    if (isMoveWithinBounds(position.getY(), -1)) {
                        Position oldPosition = PositionFactory.clone(position);
                        position.setX(position.getX() - 1);
                        checkIfThereIsAnEnemy(position, oldPosition);
                    }
                    else playerReachedDestination();
                    break;
                case SOUTH:
                    if (isMoveWithinBounds(position.getY(), +1)) {
                        position.setX(position.getX() + 1);
                    }
                    else playerReachedDestination();
            }
            arena.setLastPlayerDirection(direction);
        } else {

            gameError("Cannot move while player is in a battle");
        }
        updateUserInterfaces();
    }

    private void checkIfThereIsAnEnemy(Position position, Position oldPosition) {
        if (arena.getMap().playerExists(position)) {
            arena.setPlayerInABattle(true);
            gameResults("You encountered an enemy");
        }
        else {
            arena.getMap().addPlayer(arena.getHero());
            arena.getMap().removePlayer(oldPosition);
        }
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
        gameError("Player won. Destination reached");
    }

    private boolean isMoveWithinBounds(int value, int increment) {
        int sum = value + increment;
        boolean result = (sum >= 0) && (sum <= arena.getMap().getSize());
        return result;
    }


    public void registerHero(Hero hero) {
        createAndRegisterMap(hero);
        arena.setHero(hero);
        centerPlayer();
    }

    public void fight() {
        clearError();
        if (arena.isPlayerInABattle())
        {
            Player enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            Player won  = BattleService.battle(arena.getHero(), enemy);
        }
        else
            gameError("Cannot attack while there is no enemy.");
        updateUserInterfaces();
    }

    public void runAway() {
        updateUserInterfaces();
    }

    public void registerUserInterface(UserInterface userInterface)
    {
        userInterfaces.add(userInterface);
    }

    public void unregisterUserInteface(UserInterface userInterface)
    {
        userInterfaces.remove(userInterface);
    }

    private void createAndRegisterMap(Hero hero)
    {
        arena = ArenaFactory.createNewArena(hero);
    }

    private void centerPlayer() {
        Map map = arena.getMap();
        Position heroPos = arena.getHero().getPosition();
        heroPos.setX(map.getSize() / 2);
        heroPos.setY(map.getSize() / 2);
    }

    private void updateUserInterfaces()
    {
        for (UserInterface userInterface: userInterfaces) {
            userInterface.update();
        }
    }

    public void inValidInput() {
        gameError("Invalid input");
        updateUserInterfaces();
    }

    public void registerHero(String type, String name) {
        Hero hero = HeroFactory.newHero(type, name);
        createAndRegisterMap(hero);
        arena.setHero(hero);
        centerPlayer();
        arena.getMap().addPlayer(hero);
    }

}
