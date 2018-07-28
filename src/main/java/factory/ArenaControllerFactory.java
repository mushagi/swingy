package factory;

import controllers.*;
import database.IRepository;
import database.RepositoryImpl;
import models.players.Hero;
import models.world.Arena;
import state.GameState;

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
            public Collection<Hero> getALL() {
                return null;
            }

            @Override
            public Hero getByID(int id) {
                return null;
            }

            @Override
            public boolean create(Hero entity) {
                return false;
            }

            @Override
            public boolean delete(Hero entity) {
                return false;
            }

            @Override
            public boolean update(Hero entity) {
                return false;
            }
        };

        return new ArenaController(
                arena, mapController,
                gameResultsController,
                battleManager, heroController,
                heroRepository);
    }
}
