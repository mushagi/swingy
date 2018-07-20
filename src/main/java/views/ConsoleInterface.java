package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
import models.players.Hero;
import models.players.Player;
import models.utils.Map;
import models.utils.Position;
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
        System.out.println("Select Hero \n1. Black Panther\n2. Dick Milaje\n3. Pussy\n\nInput : ");
        type = controller.getScannerInput();
        if (name.equals("1"))
            controller.createNewHero(type, name);
    }

    private void gameLoop() {
        printMap(arena.getMap());
        displayOptions();
        while (arena.isGameInProgress()) {
            System.out.print("Input : ");
            controller.getInput();
        }
    }

    private void displayOptions() {
        System.out.println("W - NORTH        Q - FIGHT\nA - WEST         E - RUN\nS - SOUTH\nD - EAST         Z - Player Stats\n");
    }

    @Override
    public void update() {
        if (arena.getGameResults().getGameErrorMessage().isHasError()) {
            System.out.println(arena.getGameResults().getGameErrorMessage().getErrorMessage());
        }
        System.out.println("Player pos " +  arena.getHero().getPosition().toString());
        printMap(arena.getMap());
        System.out.println();
        displayOptions();
    }

    void printMap(final Map map) {
        int mapSize = map.getSize();
        Position pp = new Position(1, 2);
        for (Position pos : arena.getMap().getGameMap().keySet()) {
            System.out.println(pos.hashCode());
            System.out.println(pp.hashCode());
            boolean l = pos.equals(pp);
            System.out.println(l);
        }

        Player player = arena.getMap().getPlayer(pp);
        for (int y = 0; y <= mapSize ; y++) {
            for (int x = 0; x <= mapSize; x++) {
                Position p = new Position(y, x);
                if (map.playerExists(p))
                    System.out.print("|0| ");
                else
                    System.out.print("| | ");
            }
            System.out.println();
        }

    }
}
