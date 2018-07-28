package controllers;

import models.players.Hero;

import java.util.Collection;

import static enums.EDirection.*;

public abstract class AUIController {
    protected final ArenaController arenaController;

    protected AUIController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

    public abstract void switchUI();

    protected void moveSouth() {
        arenaController.moveHero(SOUTH);
        updateUserInterface();
    }

    protected void moveNorth() {
        arenaController.moveHero(NORTH);
        updateUserInterface();

    }

    protected void moveEast() {
        arenaController.moveHero(EAST);
        updateUserInterface();
    }

    protected void moveWest() {
        arenaController.moveHero(WEST);
        updateUserInterface();
    }

    protected void attack() {
        arenaController.fight();
        updateUserInterface();
    }

    protected void runAway() {
        arenaController.runAway();
        updateUserInterface();
    }

    void quitGame() {
        System.exit(0);
    }

    protected abstract void updateUserInterface();

    void createNewHero(String type) {
        arenaController.createHero(type);
        updateUserInterface();
    }

    void createNewHero(Hero hero) {
        arenaController.initArena(hero);
    }

    Collection<Hero> getAllHeroes() {
        return arenaController.getAllHeroes();
    }

    void loadPlayerNameToArena(String name) {
        arenaController.loadPlayerName(name);
    }

    public abstract void run();


}
