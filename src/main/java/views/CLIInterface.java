package views;

import controllers.CLIController;
import factory.ControllerFactory;
import models.players.Player;
import models.world.Arena;
import models.world.Map;
import models.world.Position;
import services.ArenaService;
import services.MapService;

import static state.GameStrings.APPLICATION_HEARDER;
import static state.GameStrings.APPLICATION_SLOGAN;
import static state.GameStrings.START_DIVIDER;

public class CLIInterface implements UserInterface {
    private final Arena arena;
    private final CLIController controller;
    public final int WIDTH_CHARACTER_MAX = 100;
    private boolean isBackToMainMenu;

    public CLIInterface(ArenaService arenaService) {
        controller = ControllerFactory.newCLIController(arenaService, this);
        arena = controller.getArena();
    }

    private void loadHero() {
        String input;
        boolean isPlayerLoaded = false;
        while (!isPlayerLoaded) {
            clearScreen();
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
        clearScreen();
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
            clearScreen();
            System.out.println("Are you sure you want to quit Game?\n1. Yep\n2. Nope");
            String input = controller.getScannerInput();
            if (input.equals("1"))
                System.exit(0);
            else if (input.equals("2"))
                break;
        }
    }

    private void printMap(final Map map) {
        MapService mapService = new MapService(map);
        for (int y = 0; y < map.getSize(); y++) {
            for (int x = 0; x < map.getSize(); x++) {
                Position position = new Position(y, x);
                if (arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition()))
                    System.out.print("|*");
                else if (mapService.playerExists(position)) {
                    Player player = mapService.getPlayer(position);
                    System.out.print(player.getType().equals("Hero") ? "|0" : "|X");
                } else
                    System.out.print("| ");
            }
            System.out.print("|\n");
        }
    }

    void displayOptions() {
        System.out.println("Directions       Actions        Game Options\nW - NORTH        F - FIGHT      Z - View Hero Stats\nA - WEST         R - RUN AWAY   X - Switch to GUI\nS - SOUTH                       C - Back To Main Menu\nD - EAST                        Q - Quit Game");
    }

    @Override
    public void updateInterface() {
        clearScreen();
        System.out.println("The arena says : ");
        System.out.println(arena.getGameResults().getResult());
        showGameMapAndOptions();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        printHeader();
    }

     void printHeader() {
        printToScreen(START_DIVIDER);
        printStringToCenter(APPLICATION_HEARDER);
        printStringToCenter(APPLICATION_SLOGAN);
        printToScreen(START_DIVIDER);
     }

    private void printToScreen(String string){
        System.out.println(string);
    }

    private void printStringToCenter(String string) {
        int centerPaddingSpace =
                getPaddingCenterAdjust(WIDTH_CHARACTER_MAX, string.length());
        System.out.format("%"+centerPaddingSpace +"s\n", string);
    }

     private int getPaddingCenterAdjust(int maxWidth, int stringLength)
     {
         int padSize = maxWidth - stringLength;
         return (padSize / 2) + stringLength;
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
            clearScreen();
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
        gameLoop();
    }

    private void gameLoop() {
        updateInterface();
        while (arena.isGameInProgress()) {
            System.out.print("Input : ");
            controller.getInput();
        }
        printResultsMessage();
    }

    private void printResultsMessage() {
        clearScreen();
        printToScreen(arena.getGameResults().getResult().toString());
        printToScreen("Press any key to continue...");
        controller.waitForAnyKeyPress();
        promptNewGame();
    }

    @Override
    public void show() {
        isBackToMainMenu = false;
        loadHero();
        gameLoop();
        if (isBackToMainMenu)
            show();
    }
}
