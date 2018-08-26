package za.co.wethinkcode.mmayibo.swingy.models.world;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Position implements Cloneable {
    @Id
    @Column(updatable = true, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public int x;
    public int y;
    
    
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public Position() {
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}