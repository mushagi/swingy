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
    String winningSpeech;
    String losingSpeech;

    @Column(length = 100)
    @OneToMany(cascade = CascadeType.ALL)
    Collection<Artifact> artifact;

    @OneToOne(cascade = CascadeType.ALL)
    Position position;

    APlayer(String type, String name, int level, int experience, int attack,
            int defence, int hitPoint, String winningSpeech, String losingSpeech) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoint = hitPoint;
        this.artifact = new ArrayList<>();
        this.position =  new Position(0, 0);
        this.winningSpeech = winningSpeech;
        this.losingSpeech = losingSpeech;
    }

    APlayer() {
    }

    @Override
    public String toString() {
        return "Player statistics\n" +
                "Name = " + name + "\n" +
                "Type = " + type + "\n" +
                "Level = " + level +"\n"+
                "Experience =" + experience + "\n"+
                "Attack = " + attack + "\n"+
                "Defence = " + defence + "\n" +
                "HitPoint = " + hitPoint + "\n"+
                "Artifact = " + artifact +"\n"+
                "Position= " + position;
    }
}