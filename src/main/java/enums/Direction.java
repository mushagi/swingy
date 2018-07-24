package enums;

import lombok.Getter;

public enum Direction {
    NORTH(-1),
    SOUTH(1),
    EAST(1),
    WEST(-1);

    @Getter int increment;

    Direction(int increment) {
        this.increment = increment;
    }
}