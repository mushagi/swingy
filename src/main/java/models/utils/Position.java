package models.utils;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Position implements Cloneable{

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

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
        return true;
    }


    @Override
    public int hashCode() {

        return x ^ 31 * y ;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}