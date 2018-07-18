package services;

import factory.ArenaFactory;
import models.Arena;
import models.Direction;
import models.players.Hero;
import models.players.Player;
import views.UserInterface;

import java.util.ArrayList;

public class ArenaService {
    static Arena arena;
    static ArrayList<UserInterface> userInterfaces;

    public void movePlayer(Direction direction) {
    }

    public void registerPlayer(Player hero) {
    }

    public void fight() {
    }

    public void runAway() {
    }

    public void registerUserInterface(UserInterface userInterface)
    {
        userInterfaces.add(userInterface);
    }

    public void unregisterUserInteface(UserInterface userInterface)
    {
        userInterfaces.remove(userInterface);
    }

    public void createArena(Hero hero)
    {
        arena = ArenaFactory.createNewArena(hero);
    }

    public boolean isGameInProgress()
    {
        return arena.getIsGameInProgress();
    }

    public boolean isHeroInArena()
    {
        return arena.getHero() != null;
    }
}
