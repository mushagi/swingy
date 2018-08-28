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
            String name = "Black Panther";
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
        String name = "Dora Malajie";
        int level = 0;
        int experience = 0;
        int attack = 40;
        int defence = 50;
        String winningSpeech = "Don't mess with a Wakandain Woman";
        String losingSpeech = "Damn, my death will be avenged";
        String picture = "doramalajie";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.DORA_MALAJIE);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;

    }
    private static Hero newNakia() {
        String name = "Nakia";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "I win, yeyi";
        String losingSpeech = "I lost, ooops";
        String picture = "nakia";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.NAKIA);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;
    }

    private static Hero newShuri() {
        String name = "Shuri";
        int level = 0;
        int experience = 0;
        int attack = 60;
        int defence = 40;
        String winningSpeech = "What are those??? Losers.";
        String losingSpeech = "We don't do that here";
            String picture = "shuri";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.SHURI);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        hero.getArtifacts().add(ArtificatFactory.newSword());
        return hero;
    }

    private static Hero newStorm() {
        String name = "Storm";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "Feel the thunder. The lightning and the thunder";
        String losingSpeech = "Damn you";
        String picture = "storm";
        return new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture, HeroType.STORM);
    }

    private static Hero newAntMan() {
        String name = "Antman";
        int level = 0;
        int experience = 0;
        int attack = 80;
        int defence = 80;
        String winningSpeech = "Smaller is always better";
        String losingSpeech = "My ants will lay an egg inside your ear";
        String picture = "antman";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.ANT_MAN);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;
    }

    private static Hero newBuckyBarnes() {
        String name = "Bucky Barnes";
        int level = 0;
        int experience = 0;
        int attack = 30;
        int defence = 60;
        String winningSpeech = "I am the winter soldier";
        String losingSpeech = "I lost. Damn";
        String picture = "buckybarnes";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.BUCKY_BARNES);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;
    }
    private static Hero newCaptainMarvel() {
        String name = "Captain Marvel";
        int level = 0;
        int experience = 0;
        int attack = 70;
        int defence = 50;
        String winningSpeech = "I will save everyone";
        String losingSpeech = "I will come back";
        String picture = "captainmarvel";

        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.Captain_Marvel);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        hero.getArtifacts().add(ArtificatFactory.newSword());
        return hero;
    }

    private static Hero newJabari() {
        String name = "Jabari";
        int level = 0;
        int experience = 0;
        int attack = 60;
        int defence = 60;
        String winningSpeech = "I won";
        String losingSpeech = "Noooooo, I lost";
        String picture = "jabari";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.Jabari);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;
    }

    private static Hero newSpiderMan() {
        String name = "Spiderman";
        int level = 0;
        int experience = 0;
        int attack = 90;
        int defence = 90;
        String winningSpeech = "Just your friendly hood spider man. From Queens. In Aakanda. In Africa";
        String losingSpeech = "Nooooooo, fake dies";
        String picture = "spiderman";
        Hero hero =  new Hero(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture,  HeroType.SPIDER_MAN);
        hero.getArtifacts().add(ArtificatFactory.newGun());
        return hero;
    }
}