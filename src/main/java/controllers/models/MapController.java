package controllers.models;

import enums.EDirection;
import factory.EnemyFactory;
import models.players.APlayer;
import models.players.Enemy;
import models.players.Hero;
import models.world.Map;
import models.world.Position;
import utils.Formulas;

import java.util.ArrayList;

import static enums.EDirection.EAST;
import static enums.EDirection.WEST;

public class MapController {
    private final Map map;
    private Hero hero;

    public MapController(Map map) {
        this.map = map;
    }

    boolean moveHeroInTheMap(EDirection direction) {
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
        map.getGameMap().clear();
        map.setSize(Formulas.calculateMapSquares(hero.getLevel()));
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies(map.getSize());
        changeThePositionOfTheHeroToBeInTheCenterOfTheMap(hero);
        addPlayers(enemies);
        addPlayer(hero);
    }

    private void changeThePositionOfTheHeroToBeInTheCenterOfTheMap(Hero hero) {
        Position position = hero.getPosition();
        position.x = map.getSize() / 2;
        position.y = map.getSize() / 2;
    }

    private boolean isMoveWithinBounds(int value) {
        return value >=0 && value < map.getSize();
    }

    boolean isMoveWithinBounds(EDirection direction) {
        if (direction == EAST || direction == WEST)
            return isMoveWithinBounds(hero.getPosition().x + direction.getIncrement());
        else
            return isMoveWithinBounds(hero.getPosition().y + direction.getIncrement());
    }

     boolean heroFoundARunAwayPosition() {
        addPlayer(hero);
        return true;
    }


    private boolean addPlayer(Position position, APlayer player) {
        map.getGameMap().put(position, player);
        return map.getGameMap().get(position)!= null;
    }

    private boolean removePlayer(Position position) {
        return map.getGameMap().remove(position) != null;
    }

    private void addPlayers(ArrayList<Enemy> enemies) {
        for (APlayer player : enemies)
            addPlayer(player.getPosition(), player);
    }

    public APlayer getPlayer(Position position) {
        return map.getGameMap().get(position);
    }

    private boolean playerExists(Position position) {
        APlayer player = map.getGameMap().get(position);
        if (player == null) return false;
        return player.getPosition().hashCode() == position.hashCode()
                && player.getPosition().equals(position);
    }

    void addPlayer(APlayer player) {
        map.getGameMap().put(player.getPosition(), player);
        map.getGameMap().get(player.getPosition());
    }
}
