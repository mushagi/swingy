package models;

import models.players.Player;

import java.util.Collection;
import java.util.HashMap;

public class Map {

    private HashMap<Position, Player> gameMap;

    public Map(HashMap<Position, Player> gameMap) {
        this.gameMap = gameMap;
    }

    boolean addPlayer(Position position, Player player)
    {
        gameMap.put(position, player);
        return gameMap.get(position)!= null;
    }

    boolean removePlayer(Player player)
    {
        return gameMap.values().remove(player);
    }

    public HashMap<Position, Player> getGameMap() {
        return gameMap;
    }

    public int  getSize()
    {
        return gameMap.size();
    }

    public int getNumberOfPlayers()
    {
        int numberOfPlayer = 0;
        for (Player player : gameMap.values()) {
            if (player != null)
                numberOfPlayer++;
        }
        return numberOfPlayer;
    }
}