package views;

import org.junit.jupiter.api.Test;
import views.cli.CLIInterfaceI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLIInterfaceTest {

    @Test
    void run() {
        String data = "";
        InputStream stdin = System.in;
        try {
            CLIInterfaceI cliUi= new CLIInterfaceI();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            cliUi.show();
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void displayOptions() {
        CLIInterfaceI cliUi= new CLIInterfaceI();
    }

    @Test
    void printHeader() {
        CLIInterfaceI cliUi= new CLIInterfaceI();
    }
}