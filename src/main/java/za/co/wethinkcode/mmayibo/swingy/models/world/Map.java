package za.co.wethinkcode.mmayibo.swingy.models.world;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Map {
    private final HashMap<Position, PositionValue> gameMap;
    private int size;

    public Map() {
        this.gameMap = new HashMap<>();
        this.size = 0;
    }
}