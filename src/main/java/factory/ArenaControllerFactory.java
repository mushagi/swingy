package factory;

import controllers.*;
import controllers.models.ArenaController;
import controllers.models.GameResultsController;
import controllers.models.HeroController;
import controllers.models.MapController;
import database.IRepository;
import database.RepositoryImpl;
import models.players.Hero;
import models.world.Arena;
import state.GameState;

public class ArenaControllerFactory {
    public static ArenaController newArenaControllerFromGameData() {
        MapController mapController = new MapController(GameState.getInstance().getArena().getMap());

        GameResultsController gameResultsController =
                new GameResultsController(GameState.getInstance().getArena().getGameResults());

        BattleManager battleManager = new BattleManager();

        Arena arena = GameState.getInstance().getArena();

        HeroController heroController = new HeroController();

        IRepository<Hero> heroRepository = new RepositoryImpl();

        return new ArenaController(
                arena, mapController,
                gameResultsController,
                battleManager, heroController,
                heroRepository);
    }
}
