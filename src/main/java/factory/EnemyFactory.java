package factory;

import models.utils.Position;
import models.artifacts.Artifact;
import models.players.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class EnemyFactory {

    private static Enemy createEnemy(String type, String name,
                                     int level,
                                     int experience,
                                     int attack,
                                     int defence,
                                     int hitPoint,
                                     Artifact artifact,
                                     Position position) {
        return new Enemy(name, level, experience, attack, defence, hitPoint, artifact, position);
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
        enemies.add(createEnemy("Whatever", "whatever1", 1,1 ,5, 6, 6, null, null));
        enemies.add(createEnemy("Whatever", "whatever2", 1,1 ,5, 6, 6, null, null));
        enemies.add(createEnemy("Whatever", "whatever3", 1,1 ,5, 6, 6, null, null));
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
