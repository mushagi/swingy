package models.world;

import lombok.Getter;
import lombok.Setter;
import models.players.APlayer;

import java.util.HashMap;

@Getter @Setter
public class Map {
    private final HashMap<Position, APlayer> gameMap;
    private int size;

    public Map() {
        this.gameMap = new HashMap<>();
        this.size = 0;
    }
}