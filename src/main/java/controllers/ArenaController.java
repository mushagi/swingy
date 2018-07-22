package controllers;

import models.world.Arena;
import services.ArenaService;

import static enums.Direction.*;

abstract class ArenaController {
    final ArenaService arenaService;

    ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    abstract void switchUI();

    void moveSouth() {
        arenaService.movePlayer(SOUTH);
    }

    void moveNorth() {
        arenaService.movePlayer(NORTH);
    }

    void moveEast() {
        arenaService.movePlayer(EAST);
    }

    void moveWest() {
        arenaService.movePlayer(WEST);
    }

    void attack() {
        arenaService.fight();
    }

    void runAway() {
        arenaService.runAway();
    }

    void quitGame() {
        System.exit(0);
    }

    public Arena getArena() {
        return arenaService.getArena();
    }
}
