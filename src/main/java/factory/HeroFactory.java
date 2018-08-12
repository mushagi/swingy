package factory;

import enums.HeroType;
import models.players.Hero;

public class HeroFactory {
    public static Hero newHero(HeroType type) {
        switch (type) {
            case BLACK_PANTHER:
                return newBlackPanther();
            case DICK_MALAJIE:
                return newDickMalajie();
        }
        return new Hero();
    }
    
    private static Hero newBlackPanther() {
        String name = "Black Panther";
        int level = 12;
        int experience = 12;
        int attack = 12;
        int defence = 13;
        String winningSpeech = "I never freeze";
        String losingSpeech = "We don't do that here";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech);
    }
    
    private static Hero newDickMalajie() {
        String name = "Dick Panther";
        int level = 15;
        int experience = 12;
        int attack = 14;
        int defence = 15;
        String winningSpeech = "Wakanda";
        String losingSpeech = "We don't do that here";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech);
    }
}