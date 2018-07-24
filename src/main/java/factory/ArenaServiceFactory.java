package factory;

import models.world.Arena;
import services.ArenaService;
import services.BattleService;
import services.GameResultsService;
import services.MapService;
import state.GameData;

public class ArenaServiceFactory {
    public static ArenaService newArenaServiceFromGameData() {
        MapService mapService = new MapService(GameData.getInstance().getArena().getMap());
        GameResultsService gameResultsService =
                new GameResultsService(GameData.getInstance().getArena().getGameResults());
        BattleService battleService = new BattleService();
        Arena arena = GameData.getInstance().getArena();
        return new ArenaService(arena, mapService, gameResultsService, battleService);
    }
}
