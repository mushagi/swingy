package controllers;

import models.players.Hero;
import models.world.Arena;
import views.UserInterface;

import static enums.EDirection.*;

abstract class UIController {
    final ArenaController arenaController;
    private final UserInterface userInterface;

    UIController(ArenaController arenaController, UserInterface userInterface) {
        this.arenaController = arenaController;
        this.userInterface = userInterface;
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

    void updateUserInterface(){
        userInterface.updateUserInterface();
    }

    public Arena getArena() {
        return arenaController.getArena();
    }

    public void createNewHero(Hero hero) {
        arenaController.registerHero(hero);
        updateUserInterface();
    }
}
