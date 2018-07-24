package models.world;

import lombok.Getter;
import lombok.Setter;
import models.players.Enemy;
import models.players.Player;
import state.GameData;

import java.util.ArrayList;
import java.util.HashMap;

@Getter @Setter
public class Map {
    private final HashMap<Position, Player> gameMap;
    private int size;

    public Map() {
        this.gameMap = new HashMap<>();
        this.size = 0;
    }
}