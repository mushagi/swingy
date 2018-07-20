package factory;

import models.utils.Position;

import models.utils.Map;
import models.players.Player;

import java.util.HashMap;

public class MapFactory {
    public static Map createNewMap(int level) {
        Map map;
        HashMap<Position, Player> gameHashMap = new HashMap<>();
        map = new Map(gameHashMap, getSquareSize(level));
        return map;
    }

    private static int getSquareSize(int level) {
        return (level-1)*5+10-(level%2);
    }
}