package views.cli;

import factory.ArenaControllerFactory;
import factory.ArenaFactory;
import models.players.BlackPanther;
import models.players.Hero;
import models.world.Arena;
import models.world.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CLITest {

    @Test
    void displayHeroList() {

        Arena arena = ArenaFactory.newArena();
        CLI cli = new CLI();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("dsfsssfsdfsdfsdfsdfsdfsdfsdfsdfsdfdsfds sdfgsdfsdf sdfsdfsdfsfsdv df");
        strings.add("dsdf");
        strings.add("sdf");
        strings.add("dsfssdf");
        strings.add("dsfssdf");
        strings.add("dsff");

        arena.getMap().getGameMap().put(new Position(1,1), new BlackPanther("heri"));
        arena.getMap().setSize(10);
        cli.printMap(arena, strings);

    }
}