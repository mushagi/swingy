package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.enums.EArtifactType;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;

class ArtificatFactory {
    public static Artifact newGun(){
        Artifact gun = new Artifact("Gun", 35, EArtifactType.Weapon);
        return gun;
    }
    public static Artifact newSword(){
        Artifact gun = new Artifact("Sword", 30, EArtifactType.Weapon);
        return gun;
    }

    public static Artifact newKnife(){
        Artifact gun = new Artifact("Sword", 10, EArtifactType.Weapon);
        return gun;
    }

    public static Artifact newHelm(){
        Artifact gun = new Artifact("Helm", 100, EArtifactType.Armour);
        return gun;
    }
}
