package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.models.messages.GameResults;
import za.co.wethinkcode.mmayibo.swingy.models.world.Map;


public class ArenaFactory {
    public static Arena newArena() {
        GameResults gameResults = new GameResults();
        Map map = new Map();
        return new Arena(null, map, true, gameResults, false);
    }
}
