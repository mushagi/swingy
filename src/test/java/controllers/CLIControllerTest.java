package controllers;

import factory.CLIControllerFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIControllerTest {

    @Test
    void getInput() {

        String data = "Hello, World!\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            CLIController controller = CLIControllerFactory.newCLIController();
            controller.getInput();
        } finally {
            System.setIn(stdin);
        }
    }
}