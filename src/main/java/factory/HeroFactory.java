package factory;

import models.players.BlackPanther;
import models.world.Position;
import models.artifacts.Artifact;
import models.players.Hero;

import java.util.ArrayList;

public class HeroFactory {
    public static Hero createHero(String type, String name,
                                    int level,
                                    int experience,
                                    int attack,
                                    int defence,
                                    int hitPoint,
                                  ArrayList<Artifact> artifact,
                                    Position position) {
        return new Hero(name, level, experience, attack, defence, hitPoint);
    }


    public static Hero newHero(String type, String name) {
        switch (type)
        {
            case "BlackPanther" :
                return new BlackPanther(name);
        }
        return new Hero(name, 0, 0, 0, 0, 0);
    }
}
