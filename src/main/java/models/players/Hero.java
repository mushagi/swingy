package models.players;

import models.world.Position;
import models.artifacts.Artifact;

import java.util.ArrayList;

public class Hero extends Player {
    public Hero(String name, int level, int experience, int attack, int defence, int hitPoint) {
        super("Hero", name, level, experience, attack, defence, hitPoint);
    }

    public Hero(String name)
    {
        super("Hero", name, 0, 0, 0, 0, 0);
    }


}
