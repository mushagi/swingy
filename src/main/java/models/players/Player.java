package models.players;

import models.artifacts.Artifact;

public abstract class Player {
    String name;
    int level;
    int experience;
    int attack;
    int defence;
    int hitPoint;
    Artifact artifact;

    public abstract int getLevel();
}
