package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;

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
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "I never freeze";
        String losingSpeech = "We don't do that here";
        String picture = "blackpanther";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.BLACK_PANTHER);
    }
    
    private static Hero newDickMalajie() {
        String name = "";
        int level = 2;
        int experience = 12;
        int attack = 14;
        int defence = 15;
        String winningSpeech = "Wakanda";
        String losingSpeech = "We don't do that here";
        String picture = "blackpanther";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }
}