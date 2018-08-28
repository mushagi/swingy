package za.co.wethinkcode.mmayibo.swingy.models.players;


import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class Hero extends AbstractPlayer {
    @Getter @Setter
    HeroType heroType;
    
    public Hero() { }
    
    public Hero(String name,
                int level,
                int experience,
                int attack,
                int defence,
                String winningSpeech,
                String losingSpeech,
                String picture,
                HeroType heroType) {
        super("Hero", name, level, experience, attack, defence, 0, winningSpeech, losingSpeech, picture);
        this.heroType = heroType;

    }
    
}
