package factory;

import controllers.CLIController;
import models.world.Arena;
import services.ArenaService;
import services.BattleService;
import services.GameResultsService;
import services.MapService;
import state.GameData;

public class CLIControllerFactory {

    public static CLIController newCLIController()
    {
        ArenaService arenaService = ArenaServiceFactory.newArenaServiceFromGameData();
        return new CLIController(arenaService);
    }
}
