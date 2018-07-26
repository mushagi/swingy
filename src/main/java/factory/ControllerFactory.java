package factory;

import controllers.CLIController;
import controllers.GUIController;
import controllers.ArenaController;
import views.UserInterface;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaController arenaController, UserInterface userInterface)
    {
        return new CLIController(arenaController, userInterface );
    }

    public static GUIController newGUIController(ArenaController arenaController, UserInterface userInterface) {
        return new GUIController(arenaController, userInterface);
    }
}
