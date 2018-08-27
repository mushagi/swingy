package za.co.wethinkcode.mmayibo.swingy.models.players;

import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;

public class Enemy extends AbstractPlayer {
    public Enemy(String name,
                 int level,
                 int experience,
                 int attack,
                 int defence,
                 String winningSpeech,
                 String losingSpeech,
                 String picture) {
        super("Enemy", name, level, experience, attack, defence, 0, winningSpeech, losingSpeech, picture);
        artifact.add(new Artifact());
    }
}