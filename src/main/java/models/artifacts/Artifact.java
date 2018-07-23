package models.artifacts;

import enums.ArtifactType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Artifact {
    String name;
    int power;
    ArtifactType artifactType;

    public Artifact(String name, int power, ArtifactType artifactType) {
        this.name = name;
        this.power = power;
        this.artifactType = artifactType;
    }
}
