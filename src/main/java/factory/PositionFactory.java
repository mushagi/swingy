package factory;

import models.world.Position;

import java.util.Random;

public class PositionFactory {
    public static Position clone(Position position) {
        return new Position(position.y, position.x );
    }

    public static Position newRandomPosition(int mapSize) {
        Random random = new Random();
        int x = random.nextInt(mapSize);
        int y = random.nextInt(mapSize);
        return new Position(y, x);
    }
}
