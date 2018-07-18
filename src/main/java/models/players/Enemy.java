package models.players;

import lombok.Getter;
import lombok.Setter;
import models.Position;
import models.artifacts.Artifact;

public class Enemy extends Player{
    public Enemy(String name, int level, int experience, int attack, int defence, int hitPoint, Artifact artifact, Position position) {
        super(name, level, experience, attack, defence, hitPoint, artifact, position);
    }

    public int getLevel() {
        return 0;
    }

}