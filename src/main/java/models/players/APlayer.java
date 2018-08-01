package models.players;

import lombok.Getter;
import lombok.Setter;
import models.world.Position;
import models.artifacts.Artifact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter @Setter
public abstract class APlayer {
    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;
    String type;
    int level;
    int experience;
    int attack;
    int defence;
    int hitPoint;

    @Column(length = 100)
    @OneToMany(cascade = CascadeType.ALL)
    Collection<Artifact> artifact;

    @OneToOne(cascade = CascadeType.ALL)
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

    APlayer() {
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