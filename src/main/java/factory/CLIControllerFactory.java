package factory;

import controllers.CLIController;
import controllers.GUIController;
import models.Arena;
import services.ArenaService;

public class CLIControllerFactory {

    public static CLIController newGuiController(ArenaService arenaService)
    {
        return new CLIController(arenaService);
    }
}
