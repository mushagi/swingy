package views.cli;

import models.players.BlackPanther;
import models.players.Hero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CLIInterfaceTest {

    @Test
    void displayHeroList() {
        BlackPanther blackPanther = new BlackPanther("Mushagi");
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(blackPanther);
        heroes.add(blackPanther);

        CLIInterface cliInterface = new CLIInterface();
        cliInterface.displayHeroList(heroes);
    }
}