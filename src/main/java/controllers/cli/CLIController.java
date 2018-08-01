package controllers.cli;

import controllers.AUIController;
import controllers.models.ArenaController;
import controllers.gui.GUIController;
import factory.ControllerFactory;
import models.players.Hero;
import state.GameState;
import views.cli.CLI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CLIController extends AUIController {
    private final Scanner scanner = new Scanner(System.in);
    private final CLI userInterface;
    private boolean IsBackToMainMenu = false;

    public CLIController(ArenaController arenaController, CLI userInterface) {
        super(arenaController);
        this.userInterface = userInterface;
    }

    @Override
    public void run() {
        showSplashScreen();
        if(!arenaController.isPLayerNameLoaded())
            loadHero();
        gameLoop();
    }

    private void getPlayerName() {
        if (!arenaController.isPLayerNameLoaded()) {
            userInterface.promptPlayerName();
            loadPlayerNameToArena(getScannerInput());
        }
    }

    private void showSplashScreen() {
        if (GameState.getInstance().isShowSplashScreen()) {
            userInterface.showSplashScreen();
            GameState.getInstance().setShowSplashScreen(false);
         //   waitForAnyKeyPress();
        }
    }

    private void loadHero() {
        String choice;
        boolean isValidInput = false;

        IsBackToMainMenu = false;
        userInterface.displayLoadCreateHeroPrompt(false);

        while (!isValidInput) {
            choice = getScannerInput();
            switch (choice) {
                case "1":
                    getHeroFromAList(GameState.getInstance().getAvailableHeroes(), false);
                    isValidInput = true;
                    break;
                case "2":
                    getHeroFromAList(arenaController.getAllHeroes(), true);
                    isValidInput = true;
                    break;
                case "3":
                    quitGame();
                    isValidInput  = true;
                    break;
                default:
                    userInterface.displayLoadCreateHeroPrompt(true);
            }

        }
        if (IsBackToMainMenu)
            loadHero();
    }

    private void gameLoop() {
        updateUserInterface();
        while (arenaController.isGameInProgress())
            getGameInProgressInput();
        userInterface.printResultsMessage(arenaController.getArena());
        waitForAnyKeyPress();
        promptNewGame();
    }

    private void getGameInProgressInput() {

        String input = getScannerInput();
        switch (input) {
            case "W":
            case "w":
                moveNorth();
                break;
            case "A":
            case "a":
                moveWest();
                break;
            case "S":
            case "s":
                moveSouth();
                break;
            case "D":
            case "d":
                moveEast();
                break;
            case "R":
            case "r":
                runAway();
                break;
            case "F":
            case "f":
                attack();
                break;
            case "Q":
            case "q":
                quitGame();
                break;
            case "X":
            case "x":
                switchUI();
            case "Z":
            case "z":
                viewHeroStats();
                break;
            default:
                userInterface.updateUserInterfaceWithInvalidInput(arenaController.getArena());
                break;
        }
    }

    private void viewHeroStats() {
        userInterface.updateUserInterfaceWithPlayerStatistics(arenaController.getArena());
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

        userInterface.promptNewGame(arenaController.didHeroWin(), false);

        while (!isValidOption) {
            input = getScannerInput();
            switch (input) {
                case "1":
                    isValidOption = true;
                    isNewGame = true;
                    break;
                case "2":
                    isValidOption = true;
                    isNewGame = false;
                    break;
                case "3":
                    quitCliGame();
                    break;
                default:
                    userInterface.promptNewGame(arenaController.didHeroWin(), true);
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

    private void getHeroFromAList(ArrayList<Hero> heroes, boolean isDatabaseSource) {
        boolean isValidOption = false;
        String choice;

        userInterface.displayHeroList(heroes, isDatabaseSource, false);
        while (!isValidOption) {

            choice = getScannerInput();

            switch (choice) {
                case "q":
                case "Q":
                    quitCliGame();
                    break;
                case "b":
                case "B":
                    isValidOption = true;
                    IsBackToMainMenu = true;
                    break;
                default:
                    int heroId;

                    try {
                        heroId = (Integer.parseInt(choice));
                        if (heroId < 1 || heroId > heroes.size())
                            throw new Exception("Invalid input");
                    } catch (Exception e) {
                        userInterface.displayHeroList(heroes, isDatabaseSource, true);
                        continue;
                    }

                    getPlayerName();
                    createNewHero(heroes.get(heroId - 1));
                    isValidOption = true;
                    break;
            }
        }
        if (IsBackToMainMenu)
            loadHero();
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