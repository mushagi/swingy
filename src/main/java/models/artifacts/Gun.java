package models.artifacts;

import enums.ArtifactType;

class Gun extends Artifact{
    public Gun() {
        super("Gun", 10, ArtifactType.Weapon);
    }
}