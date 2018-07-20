package controllers;

import services.ArenaService;
import java.util.Scanner;
import static enums.Direction.NORTH;
import static enums.Direction.SOUTH;
import static enums.Direction.EAST;
import static enums.Direction.WEST;

public class CLIController implements GameController{

    ArenaService arenaService;
    Scanner  scanner = new Scanner(System.in);
    public CLIController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    public void moveSouth() {
        arenaService.movePlayer(SOUTH);
    }

    public void moveNorth() {
        arenaService.movePlayer(NORTH);
    }

    public void moveEast() {
        arenaService.movePlayer(EAST);
    }

    public void moveWest() {
        arenaService.movePlayer(WEST);

    }

    @Override
    public void createNewHero(String type, String name) {

        switch (type)
        {
            case "1" : type = "BlackPanther"; break;
            case "2" : type = "BlackPanther"; break;
            case "3" : type = "BlackPanther"; break;
        }
        arenaService.registerHero(type, name);

    }

    public void attack() {
        arenaService.fight();
    }

    public void runAway() {
        arenaService.runAway();
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
                case "Q":
                    attack();
                    break;
                case "e":
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
                case "q":
                    attack();
                    break;
                default:
                    inValidInput();
                    break;
            }
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
}
