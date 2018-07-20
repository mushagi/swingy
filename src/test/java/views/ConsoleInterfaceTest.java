package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
import factory.HeroFactory;
import factory.MapFactory;
import models.players.Hero;
import models.utils.Map;
import org.junit.jupiter.api.Test;
import services.ArenaService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInterfaceTest {

    @Test
    void run() {
        String data = "";
        InputStream stdin = System.in;
        try {
            ConsoleInterface cliUi= new ConsoleInterface();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            cliUi.run();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void loadHero() {
    }

    @Test
    void gameLoop() {
    }

    @Test
    void update() {
    }

    @Test
    void update1() {
        ConsoleInterface  c =  new ConsoleInterface();
        Hero hero = HeroFactory.newHero("BlackPanther", "Mushagi");
        Map map = MapFactory.createNewMap(hero.getLevel());
        c.printMap(map);
    }
}