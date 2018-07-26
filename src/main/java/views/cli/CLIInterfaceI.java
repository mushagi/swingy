package views.cli;

import models.players.APlayer;
import models.world.Arena;
import models.world.Position;
import views.IUserInterface;

import static state.GameStrings.APPLICATION_HEARDER;
import static state.GameStrings.APPLICATION_SLOGAN;
import static state.GameStrings.START_DIVIDER;

public class CLIInterfaceI implements IUserInterface {
    public void displayLoadCreateHeroPrompt() {
        clearScreen();
        System.out.print("" +
                "Do you want to create a new player or load a player?\n" +
                "1. New\n" +
                "2. Load\n" +
                "3. Quit\n" +
                "\nInput: ");
    }
    public void displayHeroTypePrompt() {
        clearScreen();
        System.out.print("" +
                "Select Hero \n" +
                "1. Black Panther\n" +
                "2. Dick Milaje\n" +
                "3. Pussy\n\n" +
                "4. Back To Home\n" +
                "\nInput : ");
    }

    public void promptPlayerName() {
        clearScreen();
        printToScreen("What is your name?");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input bro");
    }


    private void printMap(final Arena arena) {
        for (int y = 0; y < arena.getMap().getSize(); y++) {
            for (int x = 0; x < arena.getMap().getSize(); x++) {
                Position position = new Position(y, x);
                if (arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition()))
                    System.out.print("|*");
                else if (arena.getMap().getGameMap().containsKey(position)) {
                    APlayer player = arena.getMap().getGameMap().get(position);
                    System.out.print(player.getType().equals("Hero") ? "|0" : "|X");
                } else
                    System.out.print("| ");
            }
            System.out.print("|\n");
        }
    }

    private void displayOptions() {
        System.out.println("" +
                "Directions       Actions        Game Options\n" +
                "W - NORTH        F - FIGHT      Z - View Hero Stats\n" +
                "A - WEST         R - RUN AWAY   X - Switch to GUI\n" +
                "S - SOUTH                       C - Back To Main Menu\n" +
                "D - EAST                        Q - Quit Game");
    }

    @Override
    public void updateUserInterface(Arena arena) {
        clearScreen();
        System.out.println("The arena says : ");
        System.out.println(arena.getGameResults().getResult());
        showGameMapAndOptions(arena);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        printHeader();
    }

     private void printHeader() {
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
                getPaddingCenterAdjust(string.length());
        System.out.format("%"+centerPaddingSpace +"s\n", string);
    }

     private int getPaddingCenterAdjust(int stringLength)
     {
         int padSize = 100 - stringLength;
         return (padSize / 2) + stringLength;
     }

    private void showGameMapAndOptions(Arena arena) {
        System.out.println();
        printMap(arena);
        System.out.println();
        displayOptions();

    }

    public void promptNewGame(boolean heroWon) {
        String request = heroWon? "Start a new game" : "try again";
        System.out.print("" +
                "Do you want to "+request + " with the same hero?" +
                "\n1. Yes" +
                "\n2. Back to Main Menu" +
                "\n3. Quit\n");
        displayPromptInput();
    }

    public void printResultsMessage(Arena arena) {
        clearScreen();
        printToScreen(arena.getGameResults().getResult().toString());
        printToScreen("Press any key to continue...");
    }

    @Override
    public void show() {

    }

    public void displayPromptInput() {
        System.out.print("\nInput : ");
    }

    public void showQuitDialogue() {
        clearScreen();
        System.out.print("" +
                "Are you sure you want to quit Game?\n" +
                "1. Yep\n" +
                "2. Nope\n");
        displayPromptInput();
    }
}