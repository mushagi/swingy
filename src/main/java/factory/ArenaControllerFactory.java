package factory;

import controllers.*;
import models.world.Arena;
import state.GameData;

public class ArenaControllerFactory {
    public static ArenaController newArenaControllerFromGameData() {
        MapController mapController = new MapController(GameData.getInstance().getArena().getMap());
        GameResultsController gameResultsController =
                new GameResultsController(GameData.getInstance().getArena().getGameResults());
        BattleManager battleManager = new BattleManager();
        Arena arena = GameData.getInstance().getArena();
        HeroController heroController = new HeroController();
        return new ArenaController(arena, mapController,
                gameResultsController, battleManager, heroController);
    }
}
