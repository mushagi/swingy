package controllers;

import models.players.Hero;

import static enums.EDirection.*;

abstract class AUIController {
    final ArenaController arenaController;

    AUIController(ArenaController arenaController ) {
        this.arenaController = arenaController;
    }

    abstract void switchUI();

    void moveSouth() {
        arenaController.moveHero(SOUTH);
        updateUserInterface();
    }

    void moveNorth() {
        arenaController.moveHero(NORTH);
        updateUserInterface();

    }

    void moveEast() {
        arenaController.moveHero(EAST);
        updateUserInterface();
    }

    void moveWest() {
        arenaController.moveHero(WEST);
        updateUserInterface();
    }

    void attack() {
        arenaController.fight();
        updateUserInterface();
    }

    void runAway() {
        arenaController.runAway();
        updateUserInterface();
    }

    void quitGame() {
        System.exit(0);
    }

    abstract void updateUserInterface();

    void createNewHero(String type) {
        arenaController.registerHero(type);
        updateUserInterface();
    }

    void createNewHero(Hero hero) {
        arenaController.registerHero(hero);
        updateUserInterface();
    }

    void loadPlayerNameToArena(String name) {
        arenaController.loadPlayerName(name);
    }

    public abstract void run();
}
