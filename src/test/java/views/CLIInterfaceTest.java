package views;

import factory.EnemyFactory;
import factory.HeroFactory;
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
    void displayOptions() {
        CLIInterface cliInterface = new CLIInterface();
        cliInterface.displayOptions();
    }
}