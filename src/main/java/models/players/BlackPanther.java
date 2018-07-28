package models.players;

import enums.EArtifactType;
import models.artifacts.Artifact;
import models.world.Position;

public class BlackPanther extends Hero {
    public BlackPanther(String name) {
        super(name);
        level = 0;
        experience = 0;
        attack = 60;
        defence = 30;
        hitPoint = 60;
        artifact.add(new Artifact("M", 12, EArtifactType.Armour));
        artifact.add(new Artifact("M", 30, EArtifactType.Armour));
        position = new Position(0, 0);
    }
}