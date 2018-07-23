package factory;

import models.world.Position;

import models.world.Map;
import models.players.Player;
import utils.Formulas;

import java.util.HashMap;

public class MapFactory {
    public static Map createNewMap(int level) {
        Map map;
        HashMap<Position, Player> gameHashMap = new HashMap<>();
        map = new Map(gameHashMap, Formulas.calculateMapSquares(level));
        return map;
    }


}