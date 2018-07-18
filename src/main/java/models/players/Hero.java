package models.players;

import models.Position;
import models.artifacts.Artifact;

public class Hero extends Player {
    int level;

    public Hero(String name, int level, int experience, int attack, int defence, int hitPoint, Artifact artifact, Position position) {
        super(name, level, experience, attack, defence, hitPoint, artifact, position);
    }

    public Hero(String name)
    {
        super(name, 0, 0, 0, 0, 0, null, null);
    }
}
