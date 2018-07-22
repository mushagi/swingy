package models.players;

import models.world.Position;
import models.artifacts.Artifact;

public class Enemy extends Player{
    public Enemy(String name, int level, int experience, int attack, int defence, int hitPoint, Artifact artifact, Position position) {
        super("Enemy", name, level, experience, attack, defence, hitPoint, artifact, position);
    }
}