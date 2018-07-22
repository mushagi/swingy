package models.players;

import lombok.Getter;
import lombok.Setter;
import models.world.Position;
import models.artifacts.Artifact;

@Getter @Setter
public abstract class Player {
    String name;
    String type;
    int level;
    int experience;
    int attack;
    int defence;
    int hitPoint;
    Artifact artifact;
    Position position;

    Player(String type, String name, int level, int experience, int attack, int defence, int hitPoint, Artifact artifact, Position position) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoint = hitPoint;
        this.artifact = artifact;
        this.position = position;
    }
}