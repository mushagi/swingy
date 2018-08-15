package models.players;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class Hero extends APlayer {
    @Getter @Setter
    String heroClass;
    
    public Hero(String name,
                int level,
                int experience,
                int attack,
                int defence,
                String winningSpeech,
                String losingSpeech,
                String picture) {
        super("Hero", name, level, experience, attack, defence, 0, winningSpeech, losingSpeech, picture);
        heroClass = "";
    }
    
    public Hero() {
    }
}
