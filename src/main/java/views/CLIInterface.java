package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
import models.players.Player;
import models.world.Arena;
import models.world.Map;
import models.world.Position;

public class CLIInterface implements UserInterface {
    private Arena arena;
    private CLIController controller;
    private boolean isBackToMainMenu;

    private void loadHero() {
        String input;
        boolean isPlayerLoaded = false;
        while (!isPlayerLoaded) {
            System.out.print("Do you want to create a new player or load a player?\n1. New\n2. Load\n\nInput: ");
            input = controller.getScannerInput();
            switch (input) {
                case "1":
                    if (createNewHero(input)) isPlayerLoaded = true;
                    break;
                case "2":
                    if (loadExistingHero()) isPlayerLoaded = true;
                    break;
                case "q":
                    quitDialogue();
                    break;
                case "Q":
                    quitDialogue();
                    break;
                default:
                    invalidInput("Invalid selection");
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
            System.out.println("Are you sure you want to quit Game?\n1. Yep\n2. Nope");
            String input = controller.getScannerInput();
            if (input.equals("1"))
                System.exit(0);
            else if (input.equals("2"))
                break;
        }
    }

    void printMap(final Map map) {
        for (int y = 0; y <= map.getSize(); y++) {
            for (int x = 0; x <= map.getSize(); x++) {
                Position position = new Position(y, x);
                if (map.playerExists(position)) {
                    Player player = map.getPlayer(position);
                    System.out.print(player.getType().equals("Hero") ? "|0| " : "|X| ");
                } else
                    System.out.print("| | ");
            }
            System.out.println("\n");
        }
    }

    void displayOptions() {
        System.out.println("Directions       Actions        Game Options\nW - NORTH        F - FIGHT      Z - View Hero Stats\nA - WEST         E - RUN AWAY   X - Switch to GUI\nS - SOUTH                       C - Back To Main Menu\nD - EAST                        Q - Quit Game");
    }

    @Override
    public void updateInterface() {
        clearScreen();
        System.out.println("The arena says : ");
        if (arena.getGameResults().getGameErrorMessage().isHasError()) {
            System.out.println(arena.getGameResults().getGameErrorMessage().getErrorMessage());
        } else
            System.out.println(arena.getGameResults().getResult());
        if (!arena.isGameInProgress())
            promptNewGame();
        else
            showGameMapAndOptions();

    }

    private void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private void showGameMapAndOptions() {
        System.out.println();
        printMap(arena.getMap());
        System.out.println();
        displayOptions();
    }

    private void promptNewGame() {
        String input;
        String request;
        if (arena.getGameResults().isHeroWon())
            request = "Do you want to start a new Game with the current Hero";
        else
            request = "Do you want to try again with the current Hero";
        boolean isValidOption = false;
        while (!isValidOption) {
            System.out.print(request + "\n1. Yes\n2. Back to Main Menu\n3. Quit");
            input = controller.getScannerInput();
            switch (input) {
                case "1":
                    startNewGame();
                    showGameMapAndOptions();
                    isValidOption = true;
                    break;
                case "2":
                    isBackToMainMenu = true;
                    isValidOption = true;
                    break;
                case "3":
                    quitDialogue();
                    isValidOption = true;
                    break;
                default:
                    invalidInput("Invalid selection");
            }
        }
    }

    private void startNewGame() {
        controller.createNewHero(arena.getHero());
        subscribeToAnArenaModel();
    }


    @Override
    public void subscribeToAnArenaModel() {
        arena = controller.getArena();
    }

    @Override
    public void registerController() {
        controller = CLIControllerFactory.newCLIController();
    }

    @Override
    public void close() {
    }

    private void gameLoop() {
        updateInterface();
        while (arena.isGameInProgress()) {
            System.out.print("Input : ");
            if (controller.getInput()) {
                close();
                break;
            }
            updateInterface();
        }
    }

    @Override
    public void show() {
        isBackToMainMenu = false;
        registerController();
        loadHero();
        subscribeToAnArenaModel();
        gameLoop();
        if (isBackToMainMenu) show();
    }
}
