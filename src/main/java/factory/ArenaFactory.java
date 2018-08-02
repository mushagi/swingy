package factory;

import models.world.Arena;
import models.messages.GameResults;
import models.world.Map;


public class ArenaFactory {
    public static Arena newArena() {
        GameResults gameResults = new GameResults();
        Map map = new Map();
        return new Arena(null, map, true, gameResults, false);
    }
}
