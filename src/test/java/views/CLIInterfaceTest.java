package views;

import factory.EnemyFactory;
import factory.HeroFactory;
import factory.MapFactory;
import models.players.Enemy;
import models.players.Hero;
import models.world.Map;
import models.world.Position;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIInterfaceTest {

    @Test
    void run() {
        String data = "";
        InputStream stdin = System.in;
        try {
            CLIInterface cliUi= new CLIInterface();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            cliUi.show();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void update1() {
        CLIInterface c =  new CLIInterface();
        Enemy enemy = EnemyFactory.newEnemy("sdf", "sdfs");
        Position position = new Position(1, 0);
        enemy.setPosition(position);
        Hero hero = HeroFactory.newHero("BlackPanther", "Mushagi");
        Map map = MapFactory.createNewMap(hero.getLevel());
        map.addPlayer(hero);
        map.addPlayer(enemy);
        c.printMap(map);
    }


    @Test
    void displayOptions() {
        CLIInterface cliInterface = new CLIInterface();
        cliInterface.displayOptions();
    }
}