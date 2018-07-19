package factory;

import models.utils.Position;

public class PositionFactory {
    public static Position clone(Position position) {
        Position newPosition = new Position(position.getY(), position.getX());
        return newPosition;
    }
}
