package controllers;

import models.players.Hero;
import models.world.Arena;
import services.ArenaService;
import views.UserInterface;

import static enums.Direction.*;

abstract class ArenaController {
    final ArenaService arenaService;

    ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    abstract void switchUI();

    void moveSouth() {
        arenaService.moveHero(SOUTH);
    }

    void moveNorth() {
        arenaService.moveHero(NORTH);
    }

    void moveEast() {
        arenaService.moveHero(EAST);
    }

    void moveWest() {
        arenaService.moveHero(WEST);
    }

    void attack() {
        arenaService.fight();
    }

    void runAway() {
        arenaService.runAway();
    }

    public void registerUserInterface(UserInterface userInterface) {
        arenaService.registerUserInterface(userInterface);
    }
    public void unRegisterUserInterface(UserInterface userInterface) {
        arenaService.unRegisterUserInterface(userInterface);
    }

    void quitGame() {
        System.exit(0);
    }

    public Arena getArena() {
        return arenaService.getArena();
    }

    public void createNewHero(Hero hero) {
        arenaService.registerHero(hero);
    }
}
