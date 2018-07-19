package models.players;

import models.artifacts.Artifact;
import models.utils.Position;

public class BlackPanther extends Hero {
    public BlackPanther(String name) {
        super(name);
        level = 1;
        experience = 0;
        attack = 0;
        defence = 0;
        hitPoint = 0;
        artifact = new Artifact();
        position = new Position(0, 0);
    }
}
