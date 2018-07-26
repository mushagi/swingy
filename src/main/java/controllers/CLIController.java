package controllers;

import views.gui.GUIInterface;
import views.UserInterface;

import java.io.IOException;
import java.util.Scanner;

public class CLIController extends UIController {
    private final Scanner scanner = new Scanner(System.in);

    public CLIController(ArenaController arenaController, UserInterface userInterface) {
        super(arenaController, userInterface);
    }
    public void createNewHero(String type, String name) {
        switch (type) {
            case "1":
                type = "BlackPanther";
                break;
            case "2":
                type = "BlackPanther";
                break;
            case "3":
                type = "BlackPanther";
                break;
        }
        arenaController.registerHero(type, name);
    }

    public void getInput() {
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
            case "X":
                switchUI();
            default:
                inValidInput();
                break;
        }
    }

    @Override
    void switchUI() {
        GUIInterface guiInterface = new GUIInterface(this.arenaController);
        guiInterface.show();
    }

    public String getScannerInput() {
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        } else
            System.exit(0);
        return input;
    }

    private void inValidInput() {
        arenaController.inValidInput();
    }

    public void waitForAnyKeyPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}