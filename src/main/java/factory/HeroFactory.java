package factory;

import models.Position;
import models.artifacts.Artifact;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

public class HeroFactory {
    public static Hero createHero(String type, String name,
                                    int level,
                                    int experience,
                                    int attack,
                                    int defence,
                                    int hitPoint,
                                    Artifact artifact,
                                    Position position) {
        return new Hero(name, level, experience, attack, defence, hitPoint, artifact, position);
    }


    public static Hero newHero(String name) {
        return new Hero(name, 0, 0, 0, 0, 0, null, null);
    }
}
