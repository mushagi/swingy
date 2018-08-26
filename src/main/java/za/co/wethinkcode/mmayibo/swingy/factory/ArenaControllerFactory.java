package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.controllers.BattleManager;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.GameResultsController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.HeroController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.MapController;
import za.co.wethinkcode.mmayibo.swingy.database.IRepository;
import za.co.wethinkcode.mmayibo.swingy.database.RepositoryImpl;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.state.GameState;

import java.util.ArrayList;

public class ArenaControllerFactory {
    public static ArenaController newArenaControllerFromGameData() {
        MapController mapController = new MapController(GameState.getInstance().getArena().getMap());

        GameResultsController gameResultsController =
                new GameResultsController(GameState.getInstance().getArena().getGameResults());

        BattleManager battleManager = new BattleManager(gameResultsController);

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
