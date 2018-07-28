package views;

import org.junit.jupiter.api.Test;
import views.cli.CLI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLITest {

    @Test
    void run() {
        String data = "";
        InputStream stdin = System.in;
        try {
            CLI cliUi= new CLI();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void displayOptions() {
        CLI cliUi= new CLI();
    }

    @Test
    void printHeader() {
        CLI cliUi= new CLI();
    }
}