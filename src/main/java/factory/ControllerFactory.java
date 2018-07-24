package factory;

import controllers.CLIController;
import controllers.GUIController;
import services.ArenaService;
import views.CLIInterface;
import views.UserInterface;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaService arenaService, UserInterface userInterface)
    {
        return new CLIController(arenaService, userInterface );
    }

    public static GUIController newGUIController(ArenaService arenaService,  UserInterface userInterface) {
        return new GUIController(arenaService, userInterface);
    }
}
