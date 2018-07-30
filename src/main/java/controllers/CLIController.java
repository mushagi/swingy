package controllers;

import controllers.gui.GUIController;
import factory.ControllerFactory;
import state.GameState;
import views.cli.CLI;

import java.io.IOException;
import java.util.Scanner;

public class CLIController extends AUIController {
    private final Scanner scanner = new Scanner(System.in);
    private final CLI userInterface;

    public CLIController(ArenaController arenaController, CLI userInterface) {
        super(arenaController);
        this.userInterface = userInterface;
    }

    private void getPlayerName() {
        if (arenaController.isPLayerNameLoaded()) {
            userInterface.promptPlayerName();
            loadPlayerNameToArena(getScannerInput());
        }
    }

    @Override
    public void run() {
        showSplashScreen();
        if(!arenaController.isPLayerNameLoaded())
            loadHero();
        gameLoop();
    }

    private void showSplashScreen() {
        if (GameState.getInstance().isShowSplashScreen()) {
            userInterface.displaySplaceScreen();
            GameState.getInstance().setShowSplashScreen(false);
            waitForAnyKeyPress();
        }
    }

    private void loadHero() {
        String choice;
        boolean isValidInput = false;
        while (!isValidInput) {
            userInterface.displayLoadCreateHeroPrompt();

            choice = getScannerInput();
            switch (choice) {
                case "1":
                    selectHeroType();
                    isValidInput = true;
                    break;
                case "2":
                    loadHeroFromDatabase();
                    isValidInput = true;
                    break;
                case "3":
                    quitGame();
                    isValidInput  = true;
                    break;
                default:
                    userInterface.displayInvalidInput();
            }

        }
    }

    private void gameLoop() {
        while (arenaController.isGameInProgress())
            getGameInProgressInput();
        userInterface.printResultsMessage(arenaController.getArena());
        waitForAnyKeyPress();
        promptNewGame();
    }

    private void getGameInProgressInput() {
        userInterface.displayPromptInput();

        String input = getScannerInput();

        switch (input) {
            case "W":
                moveNorth();
                break;
            case "A":
                moveWest();
                break;
            case "S":
                moveSouth();
                break;
            case "D":
                moveEast();
                break;
            case "r":
                runAway();
                break;
            case "R":
                runAway();
                break;
            case "w":
                moveNorth();
                break;
            case "a":
                moveWest();
                break;
            case "s":
                moveSouth();
                break;
            case "d":
                moveEast();
                break;
            case "f":
                attack();
                break;
            case "F":
                attack();
            case "q":
                quitGame();
                break;
            case "Q":
                quitGame();
                break;
            case "x":
                switchUI();
                break;
            case "X":
                switchUI();
                break;
            default:
                userInterface.displayInvalidInput();
                break;
        }
    }

    @Override
    public void switchUI() {
        GUIController controller = ControllerFactory.newGUIController(arenaController);
        controller.run();
    }

    @Override
    protected void updateUserInterface() {
        userInterface.updateUserInterface(arenaController.getArena());
    }

    private void promptNewGame() {
        String input;
        boolean isValidOption = false;
        boolean isNewGame = false;

        while (!isValidOption) {
            userInterface.promptNewGame(arenaController.didHeroWin());
            input = getScannerInput();
            switch (input) {
                case "1":
                    isValidOption = true;
                    isNewGame = true;
                    break;
                case "2":
                    isValidOption = true;
                    break;
                case "3":
                    quitCliGame();
                    break;
                default:
                    userInterface.displayInvalidInput();
            }
        }
        if (isNewGame)
            createNewHero(arenaController.getHero());
        else
            loadHero();
        gameLoop();
    }


    private void quitCliGame() {
        boolean isValidOption = false;
        String input;

        userInterface.showQuitDialogue();
        while (!isValidOption) {
            input = getScannerInput();
            switch (input) {
                case "1":
                    quitGame();
                case "2":
                    isValidOption = true;
                    break;
                default:
                    userInterface.displayInvalidInput();
            }
        }
    }

    private void selectHeroType() {
        boolean isValidOption = false;
        String type;
        getPlayerName();
        while (!isValidOption) {
            userInterface.displayHeroTypePrompt();

            type = getScannerInput();
            switch (type) {
                case "1" :
                    createNewHero(type);
                    isValidOption = true;
                    break;
                default:
                    userInterface.displayInvalidInput();
            }
        }
    }

    private void loadHeroFromDatabase() {
        boolean isValidOption = false;
        String choice;

        while (!isValidOption) {
            userInterface.displayHeroList(arenaController.getAllHeroes());

            choice = getScannerInput();
            try {
                int heroId = (Integer.parseInt(choice)) - 1;
                if (heroId <= 0 || heroId >= arenaController.getAllHeroes().size())
                    userInterface.displayInvalidInput();
                else {
                    getPlayerName();
                    createNewHero(arenaController.getByID(heroId));
                    isValidOption = true;
                }
            }
            catch (Exception e) {
                userInterface.displayInvalidInput();
            }
        }
    }

     private String getScannerInput() {
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        } else
            System.exit(0);
        return input;
    }

     private void waitForAnyKeyPress() {
        userInterface.promptAnyKeyPress();
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}