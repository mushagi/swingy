package factory;

import models.Position;
import models.artifacts.Artifact;
import models.players.Enemy;

import java.util.ArrayList;

public class EnemyFactory {

    public static Enemy createEnemy(String type, String name,
                                    int level,
                                    int experience,
                                    int attack,
                                    int defence,
                                    int hitPoint,
                                    Artifact artifact,
                                    Position position) {
        return new Enemy();
    }

    public static ArrayList<Enemy> createRandomEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        return enemies;
    }
}
