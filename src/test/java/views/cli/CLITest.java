package views.cli;

import models.players.BlackPanther;
import models.players.Hero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CLITest {

    @Test
    void displayHeroList() {
        BlackPanther blackPanther = new BlackPanther("Mushagi");
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(blackPanther);
        heroes.add(blackPanther);

        CLI cli = new CLI();
        cli.displayHeroList(heroes);
    }
}