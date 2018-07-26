package factory;

import views.cli.CLIInterface;
import views.gui.GUIInterface;
import views.UserInterface;

public class UserInterfaceFactory {
    public static UserInterface newCLIInterfaceFromGameData() {
        return new CLIInterface(ArenaControllerFactory.newArenaControllerFromGameData());
    }

    public static UserInterface newGUInterfaceFromGameData() {
        return new GUIInterface(ArenaControllerFactory.newArenaControllerFromGameData());
    }
}
