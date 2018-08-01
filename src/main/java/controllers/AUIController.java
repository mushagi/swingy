package controllers;

import controllers.models.ArenaController;
import models.players.Hero;
import models.world.Arena;

import java.util.Collection;

import static enums.EDirection.*;

public abstract class AUIController {
    protected final ArenaController arenaController;

    protected AUIController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

    public abstract void switchUI();

    public void moveSouth() {
        arenaController.moveHero(SOUTH);
        updateUserInterface();
    }

    public void moveNorth() {
        arenaController.moveHero(NORTH);
        updateUserInterface();

    }

    public void moveEast() {
        arenaController.moveHero(EAST);
        updateUserInterface();
    }

    public void moveWest() {
        arenaController.moveHero(WEST);
        updateUserInterface();
    }

    public void attack() {
        arenaController.fight();
        updateUserInterface();
    }

    public void runAway() {
        arenaController.runAway();
        updateUserInterface();
    }

    public void quitGame() {
        System.exit(0);
    }

    protected abstract void updateUserInterface();

    public void createNewHero(String type) {
        arenaController.createHero(type);
        updateUserInterface();
    }

    protected void createNewHero(Hero hero) {
        arenaController.initArena(hero);
    }

    protected Collection<Hero> getAllHeroes() {
        return arenaController.getAllHeroes();
    }

    public void loadPlayerNameToArena(String name) {
        arenaController.loadPlayerName(name);
    }

    public abstract void run();

    public  Arena getArena() {
        return arenaController.getArena();
    }
}
