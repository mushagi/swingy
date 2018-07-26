package models.players;

import controllers.HeroController;
import lombok.Getter;
import lombok.Setter;
import models.world.Position;
import models.artifacts.Artifact;

import java.util.ArrayList;

@Getter @Setter
public abstract class APlayer {
    String name;
    String type;
    int level;
    int experience;
    int attack;
    int defence;
    int hitPoint;
    ArrayList<Artifact> artifact;
    Position position;

    APlayer(String type, String name, int level, int experience, int attack, int defence, int hitPoint) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoint = hitPoint;
        this.artifact = new ArrayList<>();
        this.position =  new Position(0, 0);
    }

    @Override
    public String toString() {
        return "APlayer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", attack=" + attack +
                ", defence=" + defence +
                ", hitPoint=" + hitPoint +
                ", artifact=" + artifact +
                ", position=" + position +
                '}';
    }
}