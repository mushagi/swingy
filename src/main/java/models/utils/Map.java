package models.utils;

import lombok.Getter;
import models.players.Enemy;
import models.players.Hero;
import models.players.Player;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class Map {
    private HashMap<Position, Player> gameMap;
    private int size;

    public Map(HashMap<Position, Player> gameMap, int size) {
        this.gameMap = gameMap;
        this.size = size;
    }

    public boolean addPlayer(Position position, Player player) {

        gameMap.put(position, player);
        return gameMap.get(position)!= null;
    }

    public boolean removePlayer(Position position) {

        return gameMap.remove(position) != null;

    }

    public void addPlayers(ArrayList<Enemy> enemies) {
        for (Player player : enemies) {
            addPlayer(player.getPosition(), player);
        }
    }

    public Player getPlayer(Position position) {
        return gameMap.get(position);
    }

    public boolean playerExists(Position position) {
        Player player = gameMap.get(position);
        if (player == null) return false;
        if (player.getPosition().hashCode() == position.hashCode()
                && player.getPosition().equals(position)) return true;
        else return false;
    }

    public boolean addPlayer(Hero hero) {
        gameMap.put(hero.getPosition(), hero);
        return gameMap.get(hero.getPosition())!= null;
    }
}