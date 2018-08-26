package za.co.wethinkcode.mmayibo.swingy.controllers.cli;

import za.co.wethinkcode.mmayibo.swingy.controllers.AbstractUIController;
import za.co.wethinkcode.mmayibo.swingy.controllers.gui.GUIController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.factory.ControllerFactory;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.state.GameState;
import za.co.wethinkcode.mmayibo.swingy.views.cli.CLI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIController extends AbstractUIController {
    private final Scanner scanner = new Scanner(System.in);
    private final CLI userInterface;
    private boolean IsBackToMainMenu = false;
    private boolean switchedUI = false;
    
    public CLIController(ArenaController arenaController, CLI userInterface) {
        super(arenaController);
        this.userInterface = userInterface;
    }

    @Override
    public void run() {
        IsBackToMainMenu = false;
        showSplashScreen();
  
	    if (!arenaController.isPLayerNameLoaded()){
		    loadHero();
            if(!switchedUI)
                getPlayerName();
	    }
        if(!switchedUI)
            gameLoop();
    }

    private void getPlayerName() {
        while (!arenaController.isPLayerNameLoaded()) {
        	userInterface.promptPlayerName(arenaController.getArena());
            loadPlayerNameToArena(getScannerInput());
        }
    }

    private void showSplashScreen() {
        if (GameState.getInstance().isShowSplashScreen()) {
            userInterface.showSplashScreen();
            GameState.getInstance().setShowSplashScreen(false);
            waitForAnyKeyPress();
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
                case "Q":
                case "q":
                    quitGame();
                    isValidInput  = true;
                    break;
                case "x":
                case "X":
                    switchUI();
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
        while (arenaController.isGameInProgress() && !switchedUI)
            getGameInProgressInput();
        if (!switchedUI) {
            if (IsBackToMainMenu){
                arenaController.clearArena();
                run();
            }

            else {
                userInterface.printResultsMessage(arenaController.getArena());
                waitForAnyKeyPress();
                promptNewGame();
            }
        }
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
            case " ":
            case "F":
            case "f":
                attack();
                break;
	        case "P":
	        case "p":
		        pickUp();
		        break;
            case "Q":
            case "q":
                quitCliGame();
                break;
            case "X":
            case "x":
                switchUI();
                break;
            case "Z":
            case "z":
                viewHeroStats();
                break;
            case "B":
            case "b":
                IsBackToMainMenu = true;
                arenaController.setGameInProgress(false);
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
        switchedUI = true;
        userInterface.displaySwitchUIInProgress();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIController controller = ControllerFactory.newGUIController(arenaController);
                controller.run();
            }
        });
        userInterface.displaySwitchUIDone();
    }
    
    @Override
    public void promptGameEnded() {
    
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
                    break;
                case "2":
                    isValidOption = true;
	                updateUserInterface();
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
	            case "x":
	            case "X":
	            	switchUI();
		            isValidOption = true;
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
        userInterface.promptAnyKeyPress(true);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}