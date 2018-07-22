package controllers;

import models.world.Arena;
import services.ArenaService;

import static enums.Direction.*;

abstract class ArenaController {
    ArenaService arenaService;

    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    abstract void switchUI();

    public void moveSouth() {
        arenaService.movePlayer(SOUTH);
    }

    public void moveNorth() {
        arenaService.movePlayer(NORTH);
    }

    public void moveEast() {
        arenaService.movePlayer(EAST);
    }

    public void moveWest() {
        arenaService.movePlayer(WEST);
    }

    public void attack() {
        arenaService.fight();
    }

    public void runAway() {
        arenaService.runAway();
    }

    void quitGame() {
        System.exit(0);
    }

    public Arena getArena() {
        return arenaService.getArena();
    }
}
