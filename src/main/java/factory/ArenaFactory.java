package factory;

import models.world.Arena;
import models.messages.GameResults;
import models.world.Map;

import java.util.ArrayList;

public class ArenaFactory {
    public static Arena newArena()
    {
        GameResults gameResults = new GameResults(new ArrayList<String>(), false, false);
        Map map = new Map();
        return new Arena(null, map, true, gameResults, false);
    }
}
