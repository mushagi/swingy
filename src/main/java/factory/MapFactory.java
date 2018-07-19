package factory;

import models.utils.Position;

import models.utils.Map;
import models.players.Player;

import java.util.HashMap;

public class MapFactory {
    public static Map createNewMap(int level) {
        Map map;

        HashMap<Position, Player> gameHashMap = createHashMap(level);
        map = new Map(gameHashMap, getSquareSize(level));
        return map;
    }

    private static HashMap<Position, Player> createHashMap(int level) {
        HashMap<Position, Player> gameMap = new HashMap<>();
        int squareSize = getSquareSize(level);

        for (int y = 0; y < squareSize; y++) {
            for (int x = 0; x < squareSize; x++) {
                Position position = new Position(y, x);
                gameMap.put(position, null);
            }
        }
        return gameMap;
    }

    private static int getSquareSize(int level) {
        return (level-1)*5+10-(level%2);
    }
}