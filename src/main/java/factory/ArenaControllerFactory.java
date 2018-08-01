package factory;

import controllers.*;
import controllers.models.ArenaController;
import controllers.models.GameResultsController;
import controllers.models.HeroController;
import controllers.models.MapController;
import database.IRepository;
import models.players.Hero;
import models.world.Arena;
import state.GameState;

import java.util.ArrayList;
import java.util.Collection;

public class ArenaControllerFactory {
    public static ArenaController newArenaControllerFromGameData() {
        MapController mapController = new MapController(GameState.getInstance().getArena().getMap());

        GameResultsController gameResultsController =
                new GameResultsController(GameState.getInstance().getArena().getGameResults());

        BattleManager battleManager = new BattleManager();

        Arena arena = GameState.getInstance().getArena();

        HeroController heroController = new HeroController();

        IRepository<Hero> heroRepository = new IRepository<Hero>() {
            @Override
            public ArrayList<Hero> getALL() {
                return null;
            }

            @Override
            public Hero getByID(int id) {
                return null;
            }

            @Override
            public void create(Hero entity) {

            }

            @Override
            public boolean delete(Hero entity) {
                return false;
            }

            @Override
            public void update(Hero entity) {

            }
        };//new RepositoryImpl();

        return new ArenaController(
                arena, mapController,
                gameResultsController,
                battleManager, heroController,
                heroRepository);
    }
}
