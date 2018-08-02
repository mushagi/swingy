package models.players;


import javax.persistence.Entity;

@Entity
public class Hero extends APlayer {
    public Hero(String name, int level, int experience,
                int attack, int defence, int hitPoint, String winningSpeech, String losingSpeech) {
        super("Hero", name, level, experience, attack, defence, hitPoint, winningSpeech, losingSpeech);
    }

    public Hero(String name)
    {
        super("Hero", name, 0, 0, 0, 0, 0, "", "");
    }


    public Hero() {
    }
}
