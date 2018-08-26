package za.co.wethinkcode.mmayibo.swingy.models.players;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter @Setter
public abstract class AbstractPlayer implements Cloneable{
    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull @Size(min = 3, max = 15)
    String name;

    @NotNull
    String type;
    
    int level;

    int experience;

    int attack;
    int defence;
    
    @Transient
    int hitPoint;

    String winningSpeech;

    String losingSpeech;
    
    String picture;
    
    @Transient
    Position lastPoint;
    
    @Column(length = 100)
    @OneToMany(cascade = CascadeType.ALL)
    Collection<Artifact> artifact;
    
    @Transient
    Position position;
    
	protected AbstractPlayer() {}
	
    AbstractPlayer(String type, String name, int level, int experience, int attack,
                   int defence, int hitPoint, String winningSpeech, String losingSpeech, String picture) {
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
        this.picture = picture;
        
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
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
	}
}