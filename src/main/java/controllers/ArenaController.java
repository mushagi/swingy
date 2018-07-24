package controllers;

import models.players.Hero;
import models.world.Arena;
import services.ArenaService;
import views.UserInterface;

import static enums.Direction.*;

abstract class ArenaController {
    final ArenaService arenaService;
    private final UserInterface userInterface;

    ArenaController(ArenaService arenaService, UserInterface userInterface) {
        this.arenaService = arenaService;
        this.userInterface = userInterface;
    }

    abstract void switchUI();

    void moveSouth() {
        arenaService.moveHero(SOUTH);
        updateUserInterface();
    }

    void moveNorth() {
        arenaService.moveHero(NORTH);
        updateUserInterface();

    }

    void moveEast() {
        arenaService.moveHero(EAST);
        updateUserInterface();
    }

    void moveWest() {
        arenaService.moveHero(WEST);
        updateUserInterface();
    }

    void attack() {
        arenaService.fight();
        updateUserInterface();
    }

    void runAway() {
        arenaService.runAway();
        updateUserInterface();
    }

    void quitGame() {
        System.exit(0);
    }

    void updateUserInterface(){
        userInterface.updateInterface();
    }

    public Arena getArena() {
        return arenaService.getArena();
    }

    public void createNewHero(Hero hero) {
        arenaService.registerHero(hero);
        updateUserInterface();
    }
}
