package za.co.wethinkcode.mmayibo.swingy.enums;

import lombok.Getter;

public enum EDirection {
    NORTH(-1),
    SOUTH(1),
    EAST(1),
    WEST(-1);

    @Getter
    final int increment;

    EDirection(int increment) {
        this.increment = increment;
    }
}