package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
import models.players.Hero;
import services.ArenaService;

public class ConsoleInterface extends UserInterface{


    private CLIController controller;

    public void run() {
        ArenaService.getInstance().registerUserInterface(this);
        controller = CLIControllerFactory.newCLIController(ArenaService.getInstance());
        loadHero();
        arena = ArenaService.getInstance().getArena();
        gameLoop();
    }

    private void loadHero() {
        String name;

        System.out.print("Do you want to create a new player or load a player?\n1. New\n2. Load\n\nInput: ");
        name = controller.getScannerInput();
        if (name.equals("1"))
            createNewHero(name);
    }

    private Hero loadExistingHero() {
        return null;
    }

    private void createNewHero(String name) {
        String type;
        System.out.println("Select Hero \n1. Black Panther\n2. Dora Milaje\n3. Jabari\n\nInput : ");
        type = controller.getScannerInput();
        if (name.equals("1"))
            controller.createNewHero(type, name);
    }

    private void gameLoop()
    {
        displayOptions();
        while (arena.isGameInProgress()) {
            System.out.print("Input : ");
            controller.getInput();
        }
    }

    public void displayOptions()
    {
        System.out.println("W - NORTH        Q - FIGHT\nA - WEST         E - RUN\nS - SOUTH\nD - WEST         Z - Player Stats\n");
    }

    @Override
    public void update() {
        if (arena.getGameResults().getGameErrorMessage().isHasError()) {
            System.out.println(arena.getGameResults().getGameErrorMessage().getErrorMessage());
        }
        displayOptions();
    }


}
