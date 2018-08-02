package factory;

import models.players.BlackPanther;
import models.players.Hero;

public class HeroFactory {
    public static Hero newHero(String type, String name) {
        switch (type) {
            case "BlackPanther":
                return new BlackPanther(name);
        }
        return new Hero(name, 0, 0, 0, 0, 0 , "", "");
    }
}