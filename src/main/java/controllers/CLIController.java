package controllers;

import models.players.Hero;
import models.players.Player;
import services.ArenaService;

import static models.Direction.NORTH;
import static models.Direction.SOUTH;
import static models.Direction.EAST;
import static models.Direction.WEST;

public class CLIController implements GameController{

    ArenaService arenaService;

    public CLIController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

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

    @Override
    public void createHero(Hero hero) {
        arenaService.registerHero(hero);
    }

    public void attack() {
        arenaService.fight();
    }

    public void runAway() {
        arenaService.runAway();
    }
}
