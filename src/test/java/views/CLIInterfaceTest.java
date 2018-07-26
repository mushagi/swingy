package views;

import factory.ArenaControllerFactory;
import org.junit.jupiter.api.Test;
import views.cli.CLIInterface;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIInterfaceTest {

    @Test
    void run() {
        String data = "";
        InputStream stdin = System.in;
        try {
            CLIInterface cliUi= new CLIInterface(ArenaControllerFactory.newArenaControllerFromGameData());
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            cliUi.show();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void displayOptions() {
        CLIInterface cliInterface = new CLIInterface(ArenaControllerFactory.newArenaControllerFromGameData());
        cliInterface.displayOptions();
    }

    @Test
    void printHeader() {
        CLIInterface cliInterface = new CLIInterface(ArenaControllerFactory.newArenaControllerFromGameData());
        cliInterface.printHeader();
    }
}