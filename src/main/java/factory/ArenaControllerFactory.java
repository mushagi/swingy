package factory;

import controllers.*;
import database.IRepository;
import database.RepositoryImpl;
import models.players.Hero;
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

        IRepository<Hero> heroRepository = new RepositoryImpl();

        return new ArenaController(
                arena, mapController,
                gameResultsController,
                battleManager, heroController,
                heroRepository);
    }
}
