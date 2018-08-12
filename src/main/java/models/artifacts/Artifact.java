package models.artifacts;

import enums.EArtifactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Artifact {

    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	String name;
    int power;
    EArtifactType EArtifactType;

    public Artifact(String name, int power, EArtifactType EArtifactType) {
        this.name = name;
        this.power = power;
        this.EArtifactType = EArtifactType;
    }
	
	public Artifact() {
	}
}