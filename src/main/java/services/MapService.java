package services;

import enums.Direction;
import factory.EnemyFactory;
import models.players.Enemy;
import models.players.Hero;
import models.players.Player;
import models.world.Map;
import models.world.Position;
import utils.Formulas;

import java.util.ArrayList;

import static enums.Direction.EAST;
import static enums.Direction.WEST;

public class MapService {
    private Map map;
    private Hero hero;

    public MapService(Map map) {
        this.map = map;
    }

    boolean moveHeroInTheMap(Direction direction) {
        removePlayer(hero.getPosition());
        if (direction == EAST || direction == WEST)
            hero.getPosition().x += direction.getIncrement();
        else
            hero.getPosition().y += direction.getIncrement();
        return !isEnemyCollision();
    }

    private boolean isEnemyCollision() {
        if (playerExists(hero.getPosition()))
            return true;
        addPlayer(hero);
        return false;
    }

    void addMapValues(Hero hero) {
        this.hero = hero;
        map.setSize(Formulas.calculateMapSquares(hero.getLevel()));
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies(map.getSize());
        placeHeroInTheCenterOfTheMap(hero);
        addPlayers(enemies);
        addPlayer(hero);
    }

    private void placeHeroInTheCenterOfTheMap(Hero hero) {
        Position position = hero.getPosition();
        position.x = map.getSize() / 2;
        position.y = map.getSize() / 2;
    }

    private boolean isMoveWithinBounds(int value) {
        return value >=0 && value <= map.getSize();
    }

    boolean isMoveWithinBounds(Direction direction) {
        if (direction == EAST || direction == WEST)
            return isMoveWithinBounds(hero.getPosition().x + direction.getIncrement());
        else
            return isMoveWithinBounds(hero.getPosition().y + direction.getIncrement());
    }

    public boolean heroFoundARunAwayPosition() {
        addPlayer(hero);
        return true;
    }


    public boolean addPlayer(Position position, Player player) {
        map.getGameMap().put(position, player);
        return map.getGameMap().get(position)!= null;
    }

    public boolean removePlayer(Position position) {
        return map.getGameMap().remove(position) != null;
    }

    public void addPlayers(ArrayList<Enemy> enemies) {
        for (Player player : enemies)
            addPlayer(player.getPosition(), player);
    }

    public Player getPlayer(Position position) {
        return map.getGameMap().get(position);
    }

    public boolean playerExists(Position position) {
        Player player = map.getGameMap().get(position);
        if (player == null) return false;
        return player.getPosition().hashCode() == position.hashCode()
                && player.getPosition().equals(position);
    }

    private void addPlayer(Player player) {
        map.getGameMap().put(player.getPosition(), player);
        map.getGameMap().get(player.getPosition());
    }
}
