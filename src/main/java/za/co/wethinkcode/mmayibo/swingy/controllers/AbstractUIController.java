package za.co.wethinkcode.mmayibo.swingy.controllers;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.enums.EDirection;

import java.util.Collection;

public abstract class AbstractUIController {
    protected final ArenaController arenaController;

    protected AbstractUIController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }
    
    protected abstract void updateUserInterface();
    
    public abstract void switchUI();
    
    public abstract void promptGameEnded();
    
    
    public void moveSouth() {
        arenaController.moveHero(EDirection.SOUTH);
        updateUserInterface();
    }

    public void moveNorth() {
        arenaController.moveHero(EDirection.NORTH);
        updateUserInterface();

    }

    public void moveEast() {
        arenaController.moveHero(EDirection.EAST);
        updateUserInterface();
    }

    public void moveWest() {
        arenaController.moveHero(EDirection.WEST);
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
    
    public void pickUp() {
        arenaController.pickUpObject();
        updateUserInterface();
    }
    
    
    public void quitGame() {
        System.exit(0);
    }

    
    public void createNewHero(Hero hero) {
        arenaController.initArena(hero);
    }

    protected Collection<Hero> getAllHeroes() {
        return arenaController.getAllHeroes();
    }

    public void loadPlayerNameToArena(String name) {
        arenaController.loadPlayerName(name);
    }

    public abstract void run();

    public Arena getArena() {
        return arenaController.getArena();
    }
    
    public void createNewGameExistingHero() {
        arenaController.initArena(arenaController.getHero());
    }
    public void clearArena() {
        arenaController.clearArena();
    }

    public void clearForNewGame() {
        arenaController.clearForNewGame();
    }
}
