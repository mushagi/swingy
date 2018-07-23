package factory;

import models.world.Arena;
import models.messages.GameResults;
import models.world.Map;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

public class ArenaFactory {
    public static Arena newArena(Hero hero, Map map)
    {
        GameResults gameResults = GameResultsFactory.newGameResults();
        return new Arena(hero, map, true, gameResults, false);
    }


}
