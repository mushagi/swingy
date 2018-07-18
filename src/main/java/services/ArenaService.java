package services;

import factory.ArenaFactory;
import factory.EnemyFactory;
import factory.MapFactory;
import lombok.Getter;
import models.Arena;
import models.Direction;
import models.Map;
import models.players.Enemy;
import models.players.Hero;
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

    public ArenaService() {
        userInterfaces = new ArrayList<>();
    }

    public void movePlayer(Direction direction) {
        updateUserInterfaces();
    }

    public void registerHero(Hero hero) {
        createAndRegisterMap(hero);
        arena.setHero(hero);
    }

    public void fight() {
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

    private void updateUserInterfaces()
    {
        for (UserInterface userInterface: userInterfaces) {
            userInterface.update();
        }
    }
}
