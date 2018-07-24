package controllers;

import factory.ArenaServiceFactory;
import factory.ControllerFactory;
import org.junit.jupiter.api.Test;
import services.ArenaService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIControllerTest {

    @Test
    void getInput() {

        String data = "Hello, World!\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            CLIController controller = ControllerFactory.newCLIController(ArenaServiceFactory.newArenaServiceFromGameData());
            controller.getInput();
        } finally {
            System.setIn(stdin);
        }
    }
}