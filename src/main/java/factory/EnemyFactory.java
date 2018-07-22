package factory;

import models.world.Position;
import models.players.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class EnemyFactory {

    private static Enemy createEnemy(String name) {
        return new Enemy(name, 1, 1, 5, 6, 6, null, null);
    }

    public static ArrayList<Enemy> createRandomEnemies(int mapSize) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < mapSize; i++) {
            Enemy enemy = getRandomEnemy();
            Position position = PositionFactory.newRandomPosition(mapSize);
            enemy.setPosition(position);
            enemies.add(enemy);
        }
        return enemies;
    }

    private static Enemy getRandomEnemy() {
        Random random = new Random();
        ArrayList<Enemy> enemies = getListOfEnemies();
        int randomNumber = random.nextInt(enemies.size());
        return enemies.get(randomNumber);
    }

    private static ArrayList<Enemy> getListOfEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(createEnemy("whatever1"));
        enemies.add(createEnemy("whatever2"));
        enemies.add(createEnemy("whatever3"));
        return enemies;
    }

    public static Enemy newEnemy(String type, String name) {
        switch (type)
        {
            case "BlackPanther" :
        }
        return new Enemy(name, 0, 0, 0, 0, 0, null, null);
    }

}
