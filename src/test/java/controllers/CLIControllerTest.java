package controllers;

import factory.ArenaControllerFactory;
import factory.ControllerFactory;
import org.junit.jupiter.api.Test;
import views.UserInterface;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIControllerTest {

    @Test
    void getInput() {

        String data = "Hello, World!\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            CLIController controller = ControllerFactory.newCLIController(ArenaControllerFactory.newArenaControllerFromGameData(),
                    new UserInterface() {
                        @Override
                        public void updateUserInterface() {

                        }

                        @Override
                        public void show() {

                        }
                    });
            controller.getInput();
        } finally {
            System.setIn(stdin);
        }
    }
}