package models.players;

public class Enemy extends APlayer {
    public Enemy(String name, int level, int experience, int attack, int defence, int hitPoint) {
        super("Enemy", name, level, experience, attack, defence, hitPoint);
    }
}