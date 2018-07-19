package views;

import controllers.CLIController;
import factory.CLIControllerFactory;
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
}