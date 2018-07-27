package views;

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
            CLIInterface cliUi= new CLIInterface();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            cliUi.show();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void displayOptions() {
        CLIInterface cliUi= new CLIInterface();
    }

    @Test
    void printHeader() {
        CLIInterface cliUi= new CLIInterface();
    }
}