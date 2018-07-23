package models.players;

import models.world.Position;
import models.artifacts.Artifact;

import java.util.ArrayList;

public class Enemy extends Player{
    public Enemy(String name, int level, int experience, int attack, int defence, int hitPoint) {
        super("Enemy", name, level, experience, attack, defence, hitPoint);
    }


}