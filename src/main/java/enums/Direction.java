package enums;

public enum Direction {
    NORTH(-1),
    SOUTH(1),
    EAST(1),
    WEST(-1);

    int increment;
    Direction(int increment) {
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }
}