package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class Position {
    private int x;
    private int y;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    public void setValues(int y, int x) {
        this.x = x;
        this.y = y;
    }
}
