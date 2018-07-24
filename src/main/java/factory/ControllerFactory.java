package factory;

import controllers.CLIController;
import controllers.GUIController;
import services.ArenaService;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaService arenaService)
    {
        return new CLIController(arenaService);
    }

    public static GUIController newGUIController(ArenaService arenaService) {
        return new GUIController(arenaService);
    }
}
