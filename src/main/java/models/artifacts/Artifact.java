package models.artifacts;

import enums.EArtifactType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Artifact {
    String name;
    int power;
    EArtifactType EArtifactType;

    public Artifact(String name, int power, EArtifactType EArtifactType) {
        this.name = name;
        this.power = power;
        this.EArtifactType = EArtifactType;
    }
}
