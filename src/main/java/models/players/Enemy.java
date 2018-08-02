package models.players;

public class Enemy extends APlayer {
    public Enemy(String name, int level, int experience, int attack, int defence, int hitPoint, String winningSpeech, String losingSpeech) {
        super("Enemy", name, level, experience, attack, defence, hitPoint, winningSpeech, losingSpeech);
    }
}