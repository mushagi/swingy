package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
import models.players.Player;
import models.utils.Map;
import models.utils.Position;
import services.ArenaService;

public class CLIInterface extends UserInterface{
    private CLIController controller;

    private void loadHero() {
        String input;
        boolean isPlayerLoaded = false;
        while (!isPlayerLoaded)
        {
            System.out.print("Do you want to create a new player or load a player?\n1. New\n2. Load\n\nInput: ");
            input = controller.getScannerInput();
            switch (input)
            {
                case "1" : if(createNewHero(input)) isPlayerLoaded = true; break;
                case "2" : if (loadExistingHero()) isPlayerLoaded = true; break;
                case "q" : quitDialogue(); break;
                case "Q" : quitDialogue(); break;
                default: invalidInput("Invalid selection");
            }
        }

    }

    private boolean loadExistingHero() {
        return false;
    }

    private boolean createNewHero(String name) {
        String input;
        while (true) {
            System.out.println("Select Hero \n1. Black Panther\n2. Dick Milaje\n3. Pussy\n\n4. Back To Home\n\nInput : ");
            input = controller.getScannerInput();

            switch (input) {
                case "1":
                case "2":
                case "3":
                    controller.createNewHero(input, name);
                    return true;
                case "4":
                    return false;
                default:
                    invalidInput("Invalid Option. ");
                    break;
            }
        }
    }

    private void invalidInput(String message) {
        System.out.println(message);
    }

    private void quitDialogue() {
        while (true) {
            System.out.println("Are you sure you want to quit game?\n1. Yep\n2. Nope");
            String input = controller.getScannerInput();
            if (input.equals("1"))
                System.exit(0);
            else if (input.equals("2"))
                break;
        }
    }

    void printMap(final Map map) {
        for (int y = 0; y <= map.getSize() ; y++) {
            for (int x = 0; x <= map.getSize(); x++) {
                Position position = new Position(y, x);
                if (map.playerExists(position)) {
                    Player player = map.getPlayer(position);
                    System.out.print(player.getType().equals("Hero") ? "|0| " : "|X| ");
                }
                else
                    System.out.print("| | ");
            }
            System.out.println("\n");
        }
    }

     void displayOptions() {
        System.out.println("Directions       Actions        Game Options\nW - NORTH        F - FIGHT      Z - View Hero Stats\nA - WEST         E - RUN        Q - quit\nS - SOUTH\nD - EAST");
    }

    @Override
    public void update() {
        System.out.println("The arena says : ");
        if (arena.getGameResults().getGameErrorMessage().isHasError()) {
            System.out.println(arena.getGameResults().getGameErrorMessage().getErrorMessage());
        }
        else
            System.out.println(arena.getGameResults().getResult());
        System.out.println();
        printMap(arena.getMap());
        System.out.println();
        displayOptions();
    }

    private void gameLoop() {
        printMap(arena.getMap());
        displayOptions();
        while (arena.isGameInProgress()) {
            System.out.print("Input : ");
            controller.getInput();
        }
    }

    public void run() {
        ArenaService.getInstance().registerUserInterface(this);
        controller = CLIControllerFactory.newCLIController(ArenaService.getInstance());
        loadHero();
        arena = ArenaService.getInstance().getArena();
        gameLoop();
    }
}
