package services;

import enums.Direction;
import factory.EnemyFactory;
import factory.MapFactory;
import models.players.Enemy;
import models.players.Hero;
import models.world.Map;
import models.world.Position;

import java.util.ArrayList;

import static enums.Direction.EAST;
import static enums.Direction.WEST;

class MapService {
    private Map map;
    private Hero hero;

    boolean moveHeroInTheMap(Direction direction) {
        map.removePlayer(hero.getPosition());
        if (direction == EAST || direction == WEST)
            hero.getPosition().x += direction.getIncrement();
        else
            hero.getPosition().y += direction.getIncrement();
        return !isEnemyCollision();
    }

    private boolean isEnemyCollision() {
        if (map.playerExists(hero.getPosition()))
            return true;
        map.addPlayer(hero);
        return false;
    }

    Map createMap(Hero hero) {
        Map map = MapFactory.createNewMap(hero.getLevel());
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies(map.getSize());
        map.addPlayers(enemies);
        this.map = map;

        placeHeroInTheCenterOfTheMap(hero);
        map.addPlayer(hero);
        this.hero = hero;

        return map;
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
        map.addPlayer(hero);
        return true;
    }
}
