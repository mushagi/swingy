package models.players;


import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
public class Hero extends APlayer {
    public Hero(String name, int level, int experience, int attack, int defence, int hitPoint) {
        super("Hero", name, level, experience, attack, defence, hitPoint);
    }

    public Hero(String name)
    {
        super("Hero", name, 0, 0, 0, 0, 0);
    }


    public Hero() {
    }
}
