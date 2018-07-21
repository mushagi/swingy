package services;

import factory.ArenaFactory;
import factory.HeroFactory;
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
    private final ArrayList<UserInterface> userInterfaces;

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
                    if (isMoveWithinBounds(position.x + 1)) {
                        arena.getMap().removePlayer(position);
                        position.x += 1;
                        checkIfThereIsAnEnemy(position);

                    } else playerReachedDestination();
                    break;
                case WEST:
                    if (isMoveWithinBounds(position.x-1)) {
                        arena.getMap().removePlayer(position);
                        position.x -= 1;
                        checkIfThereIsAnEnemy(position);

                    }
                    else playerReachedDestination();
                    break;
                case NORTH:
                    if (isMoveWithinBounds(position.y-1)) {
                        arena.getMap().removePlayer(position);
                        position.y -= 1;
                        checkIfThereIsAnEnemy(position);

                    }
                    else playerReachedDestination();
                    break;
                case SOUTH:
                    if (isMoveWithinBounds(position.y+1)) {
                        arena.getMap().removePlayer(position);
                        position.y += 1;
                        checkIfThereIsAnEnemy(position);
                    }
                    else playerReachedDestination();
            }
            arena.setLastPlayerDirection(direction);
        }
        else
            gameError("Cannot move while player is in a battle");
        updateUserInterfaces();
    }

    private void checkIfThereIsAnEnemy(Position position) {
        if (arena.getMap().playerExists(position)) {
            arena.setPlayerInABattle(true);
            gameResults("You encountered an enemy");
        }
        else {
            arena.getMap().addPlayer(arena.getHero());
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
        arena.setGameInProgress(true);
        gameError("Player won. Destination reached");
    }

    private boolean isMoveWithinBounds(int value) {
        return value >= 0 && value <= arena.getMap().getSize();
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

    public void unregisterUserInterface(UserInterface userInterface)
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
        heroPos.x = map.getSize() / 2;
        heroPos.y = map.getSize() / 2;
    }

    private void updateUserInterfaces()
    {
        for (UserInterface userInterface: userInterfaces)
            userInterface.update();
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
