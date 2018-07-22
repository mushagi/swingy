package factory;

import controllers.CLIController;
import services.ArenaService;

public class CLIControllerFactory {

    public static CLIController newCLIController()
    {
        ArenaService arenaService = new ArenaService();
        return new CLIController(arenaService);
    }
}
