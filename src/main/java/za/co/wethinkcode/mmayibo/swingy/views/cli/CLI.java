package za.co.wethinkcode.mmayibo.swingy.views.cli;

import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.views.ISplashScreen;
import za.co.wethinkcode.mmayibo.swingy.views.IUserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants.*;

public class CLI implements IUserInterface {
    private MapCLi mapCLi = new MapCLi();
    
    public void displayLoadCreateHeroPrompt(boolean isInvalidInput) {
        clearScreen();
        System.out.print("" +
                "Do you want to create a new player or load a player?\n" +
                "1. New\n" +
                "2. Load\n" +
                "3. Quit\n");
        displayPromptInput(isInvalidInput);
    }

    public void promptPlayerName(Arena arena) {
        clearScreen();
        if (arena.getGameResults().isError())
            for (String message: arena.getGameResults().getResult())
                printToScreen(message);
        printToScreen("What is your name?");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input bro");
    }

    void printMap(final Arena arena, ArrayList<String> sideString) {
        mapCLi.setSideIterator(sideString.iterator());
        mapCLi.updateMap(arena);
        mapCLi.finishUpSideIterator();
    }

    private void displayOptions() {
        System.out.println("" +
                "Directions       Actions             Game Options\n" +
                "W - NORTH        SPACE - FIGHT       Z - View Hero Stats\n" +
                "A - WEST         R -     RUN AWAY    X - Switch to GUI\n" +
                "S - SOUTH        P -     Pick Up     B - Back To Main Menu\n" +
                "D - EAST                             Q - Quit Game");
    }

    @Override
    public void updateUserInterface(Arena arena) {
        clearScreen();
        showGameMapAndOptions(arena, false);
    }


    public void updateUserInterfaceWithInvalidInput(Arena arena) {
        clearScreen();
        showGameMapAndOptions(arena, true);
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

     private int getPaddingCenterAdjust(int stringLength) {
         int padSize = 100 - stringLength;
         return (padSize / 2) + stringLength;
     }

    private void showGameMapAndOptions(Arena arena, boolean isWithInvalidInput) {
        System.out.println();
        printMap(arena, arena.getGameResults().getResult());
        System.out.println();
        displayOptions();
        displayPromptInput(isWithInvalidInput);
    }

    public void promptNewGame(boolean heroWon, boolean isWithInvalidInput) {
        clearScreen();
        String request = heroWon? "Start a new game" : "try again";
        System.out.print("" +
                "Do you want to "+request + " with the same hero?" +
                "\n1. Yes" +
                "\n2. Back to Main Menu" +
                "\n3. Quit\n");
        displayPromptInput(isWithInvalidInput);
    }

    public void printResultsMessage(Arena arena) {
        clearScreen();
        printToScreen("\n\n");
        if ( arena.getGameResults().isHeroWon() )
            printGameWonResults(arena);
        else
            printGameLostMessage(arena);
        printGainedValues(arena.getHero());
    }

    private void printGainedValues(Hero hero) {
        printToScreen("Player stats\n");
        printToScreen("Level = " + hero.getLevel());
        printToScreen("Xp = " + hero.getExperience());
        printToScreen("");

    }

    private void printGameLostMessage(Arena arena) {
        printToScreen("" +
                "                              ███████▄▄███████████▄\n" +
                "                              ▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
                "                              ▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
                "                              ▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
                "                              ▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
                "                              ▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
                "                              ▓▓▓▓▓▓███░░░░░░░░░░░░█\n" +
                "                              ██████▀░░█░░░░██████▀\n" +
                "                              ░░░░░░░░░█░░░░█\n" +
                "                              ░░░░░░░░░░█░░░█\n" +
                "                              ░░░░░░░░░░░█░░█\n" +
                "                              ░░░░░░░░░░░█░░█\n" +
                "                              ░░░░░░░░░░░░▀▀ ");

        printToScreen("\n\n\nYou lost!!!\n");
        printToScreen("The enemy says : " + arena.getGameResults().getEnemyWon().getWinningSpeech() + "\n");

    }

    private void printGameWonResults(Arena arena) {

        printToScreen("" +
                "                                              nnnmmm\n" +
                "                               \\||\\       ;;;;%%%@@@@@@       \\ //,\n" +
                "                                V|/     %;;%%%%%@@@@@@@@@@  ===Y//\n" +
                "                                68=== ;;;;%%%%%%@@@@@@@@@@@@    @Y\n" +
                "                                ;Y   ;;%;%%%%%%@@@@@@@@@@@@@@    Y\n" +
                "                                ;Y  ;;;+;%%%%%%@@@@@@@@@@@@@@@    Y\n" +
                "                                ;Y__;;;+;%%%%%%@@@@@@@@@@@@@@i;;__Y\n" +
                "                               iiY\"\";;   \"uu%@@@@@@@@@@uu\"   @\"\";;;>\n" +
                "                                      Y     \"UUUUUUUUU\"     @@\n" +
                "                                      `;       ___ _       @\n" +
                "                                        `;.  ,====\\\\=.  .;'\n" +
                "                                          ``\"\"\"\"`==\\\\=='\n" +
                "                                                 `;=====\n" +
                "                                                   ===   \n");

        printToScreen("Yata, you won!\n");
    }

    @Override
    public void showSplashScreen() {
        clearScreen();
        ISplashScreen splashScreen = new SplashScreenCli();
        splashScreen.showSplashScreen();
    }

    @Override
    public void showQuitDialogue() {
        clearScreen();
        System.out.print("" +
                "Are you sure you want to quit Game?\n" +
                "1. Yep\n" +
                "2. Nope\n");
    }
    
    private void displayPromptInput(boolean isWithInvalidInput) {
        System.out.println();
        if (isWithInvalidInput)
            printToScreen("Invalid Input bro, look at the options and try again.");
        System.out.print("Input : ");
    }

    public void showQuitDialogueCLI(boolean isWithInvalidInput) {
        showQuitDialogue();
        displayPromptInput(isWithInvalidInput);
    }


    public void displayHeroList(Collection<Hero> allHeroes, boolean isDatabaseSource, boolean isWithValidOption) {
        clearScreen();
        int count = 1;
        printStringToCenter("*************************************");

        if (isDatabaseSource)
            printStringToCenter("*     Heroes from the database      *");
        else
            printStringToCenter("*       Create a new Hero           *");

        printStringToCenter("*************************************");
        System.out.format("%-20s%-20s%-20s%-20s%-20s\n", "Index", "Name", "Hero Class Type", "Level", "Xp");
        System.out.format("_____________________________________________________________________________________\n");

        for (Hero hero: allHeroes) {
            System.out.format("%-20d%-20s%-20s%-20d%-20d\n", count++, hero.getName(), hero.getType(), hero.getLevel(), hero.getExperience());
        }
        printToScreen("\nB . Back To Main Menu\nQ - Quit\n");
        displayPromptInput(isWithValidOption);
    }

    public void promptAnyKeyPress(boolean isCentered) {
        String promptString = "Press any key to continue...";
        if (isCentered)
            printStringToCenter(promptString);
        else
            printToScreen(promptString);
    }

    public void updateUserInterfaceWithPlayerStatistics(Arena arena) {
        clearScreen();
        System.out.println();
        ArrayList<String> sideString = new ArrayList<>(Arrays.asList(arena.getHero().toString().split("\n")));
        printMap(arena, sideString);
        System.out.println();
        displayOptions();
        displayPromptInput(false);
    }
    
    public void displaySwitchUIInProgress() {
        printToScreen("Switching user interface...");
    }
    
    public void displaySwitchUIDone() {
        printToScreen("Switched ui");
    }
}