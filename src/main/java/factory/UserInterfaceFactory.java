package factory;

import views.CLIInterface;
import views.GUIInterface;
import views.UserInterface;

public class UserInterfaceFactory {
    public static UserInterface newCLIInterfaceFromGameData() {
        return new CLIInterface(ArenaServiceFactory.newArenaServiceFromGameData());
    }

    public static UserInterface newGUInterfaceFromGameData() {
        return new GUIInterface(ArenaServiceFactory.newArenaServiceFromGameData());
    }
}
