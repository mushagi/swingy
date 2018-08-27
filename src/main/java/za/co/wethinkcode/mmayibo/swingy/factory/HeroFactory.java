package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;

public class HeroFactory {
    public static Hero newHero(HeroType type) {
        switch (type) {
            case BLACK_PANTHER:
                return newBlackPanther();
            case DORA_MALAJIE:
                return newDoraMalajie();
            case NAKIA:
                return newNakia();
            case SHURI:
                return newShuri();
            case STORM:
                return newStorm();
            case ANT_MAN:
                return newAntMan();
            case BUCKY_BARNES:
                return newBuckyBarnes();
            case Captain_Marvel:
                return newCaptainMarvel();
            case Jabari:
                return newJabari();
            case SPIDER_MAN:
                return newSpiderMan();
        }
        return new Hero();
    }

    private static Hero newBlackPanther() {
            String name = "";
            int level = 0;
            int experience = 0;
            int attack = 100;
            int defence = 100;
            String winningSpeech = "I never freeze, Wakanda Forever";
            String losingSpeech = "Wakanda will prevail still";
            String picture = "blackpanther";
            return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.BLACK_PANTHER);
    }
    
    private static Hero newDoraMalajie() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 40;
        int defence = 50;
        String winningSpeech = "Don't mess with a Wakandain Woman";
        String losingSpeech = "Damn, my death will be avenged";
        String picture = "doramalajie";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }
    private static Hero newNakia() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "I win, yeyi";
        String losingSpeech = "I lost, ooops";
        String picture = "nakia";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.BLACK_PANTHER);
    }

    private static Hero newShuri() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 60;
        int defence = 40;
        String winningSpeech = "What are those??? Losers.";
        String losingSpeech = "We don't do that here";
            String picture = "shuri";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }
    private static Hero newStorm() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "Feel the thunder. The lightning and the thunder";
        String losingSpeech = "Damn you";
        String picture = "storm";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.BLACK_PANTHER);
    }

    private static Hero newAntMan() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 80;
        int defence = 80;
        String winningSpeech = "Smaller is always better";
        String losingSpeech = "My ants will lay an egg inside your ear";
        String picture = "antman";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }

    private static Hero newBuckyBarnes() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 14;
        int defence = 15;
        String winningSpeech = "I am the winter soldier";
        String losingSpeech = "I lost. Damn";
        String picture = "buckybarnes";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }
    private static Hero newCaptainMarvel() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "I will save everyone";
        String losingSpeech = "I will come back";
        String picture = "captainmarvel";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.BLACK_PANTHER);
    }

    private static Hero newJabari() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 14;
        int defence = 15;
        String winningSpeech = "I won";
        String losingSpeech = "Noooooo, I lost";
        String picture = "jabari";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }

    private static Hero newSpiderMan() {
        String name = "";
        int level = 0;
        int experience = 0;
        int attack = 14;
        int defence = 15;
        String winningSpeech = "Just your friendly hood spider man. From Queens. In Aakanda. In Africa";
        String losingSpeech = "Nooooooo, fake dies";
        String picture = "spiderman";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BLACK_PANTHER);
    }
}