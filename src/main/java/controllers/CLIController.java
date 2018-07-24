package controllers;

import services.ArenaService;
import views.GUIInterface;
import views.UserInterface;

import java.io.IOException;
import java.util.Scanner;

public class CLIController extends ArenaController {
    private final Scanner  scanner = new Scanner(System.in);

    public CLIController(ArenaService arenaService, UserInterface userInterface) {
        super(arenaService, userInterface);
    }

    public void createNewHero(String type, String name) {
        switch (type)
        {
            case "1" : type = "BlackPanther"; break;
            case "2" : type = "BlackPanther"; break;
            case "3" : type = "BlackPanther"; break;
        }
        arenaService.registerHero(type, name);
    }

    public boolean getInput() {

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
                    return true;
                case "X":
                    switchUI();
                    return true;
                default:
                    inValidInput();
                    break;
            }
            return false;
    }

    @Override
    void switchUI() {
        GUIInterface guiInterface = new GUIInterface(this.arenaService);
        guiInterface.show();
    }

    public String getScannerInput()
    {
        String input = "";
        if(scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        else
            System.exit(0);
        return input;
    }



    private void inValidInput() {
        arenaService.inValidInput();
    }

    public void waitForAnyKeyPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}