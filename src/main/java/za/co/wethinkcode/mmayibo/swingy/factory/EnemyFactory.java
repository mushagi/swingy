package za.co.wethinkcode.mmayibo.swingy.factory;

import org.hibernate.mapping.Formula;
import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.players.Enemy;
import za.co.wethinkcode.mmayibo.swingy.utils.Formulas;

import java.util.ArrayList;
import java.util.Random;

public class EnemyFactory {

    public static ArrayList<Enemy> createRandomEnemies(int mapSize) {
        int level = Formulas.getLevelFromMap(mapSize, 0);
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < mapSize * 3; i++) {
            Enemy enemy = getRandomEnemy(level);
            randomisePositionValues(enemy.getPosition(), mapSize);
            enemies.add(enemy);
        }
        return enemies;
    }

    private static Enemy getRandomEnemy(int level) {
        Random random = new Random();
        ArrayList<Enemy> enemies = getListOfEnemies(level);
        int randomNumber = random.nextInt(enemies.size());
        return enemies.get(randomNumber);
    }

    private  static ArrayList<Enemy> getListOfEnemies(int level) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(newKillMonger(level));
        enemies.add(newManApe(level));
        enemies.add(newRadioactiveMan(level));
        enemies.add(newReverendAchebe(level));
        enemies.add(newDrDoom(level));
        enemies.add(newWhiteWolf(level));
        enemies.add(newKlaue(level));
        enemies.add(newBaronzemo(level));
        enemies.add(newThanos(level));
        enemies.add(newSuperGiant(level));
        return enemies;
    }

    private static Enemy newRadioactiveMan(int level) {
        String name = "Radioactive Man";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 50;
        int defence = 100;
        String winningSpeech = "I'm radio active man";
        String losingSpeech = "Damn";
        String picture = "radioactive";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newManApe(int level) {
        String name = "Man Ape";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 70;
        int defence = 30;
        String winningSpeech = "Ape kill ape if ape bad";
        String losingSpeech = "Ape don't kill ape";
        String picture = "manape";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newReverendAchebe(int level) {
        String name = "Reverend Achebe";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 10;
        int defence = 80;
        String winningSpeech = "The Gods are good";
        String losingSpeech = "Evil will not last forever";
        String picture = "achebe";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newKillMonger(int level) {
        String name = "Kill Monger";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 70;
        int defence = 70;
        String winningSpeech = "Wakanda must rule the world";
        String losingSpeech = "Damn you, traitor";
        String picture = "killmonger";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newDrDoom(int level) {
        String name = "Dr Doom";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 60;
        int defence = 100;
        String winningSpeech = "Doom will whatever brah";
        String losingSpeech = "Okay i'm getting tired of typing now";
        String picture = "doom";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newWhiteWolf(int level) {
        String name = "White wolf";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 100;
        int defence = 60;
        String winningSpeech = "Damn them wakandains";
        String losingSpeech = "Fuck. This is long";
        String picture = "whitewolf";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newKlaue(int level) {
        String name = "New Klaue";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 10;
        int defence = 10;
        String winningSpeech = "I will sell your body to the highest bidder";
        String losingSpeech = "I fear no man";
        String picture = "klaue";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newBaronzemo(int level) {
        String name = "Baronzemo";
        int experience = 0;
        int attack = 20;
        int defence = 20;
        String winningSpeech = "I don't know this guy";
        String losingSpeech = "Who am i?";
        String picture = "baronzemo";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newSuperGiant(int level) {
        String name = "Super Giant";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 80;
        int defence = 30;
        String winningSpeech = "I have crushed your skull, puny hero";
        String losingSpeech = "I will be back";
        String picture = "supergiant";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newThanos(int level) {
        String name = "Kill Monger";
        int experience = Formulas.calculateRequiredLevelExperience(level);
        int attack = 120;
        int defence = 120;
        String winningSpeech = "You should have aimed for the head";
        String losingSpeech = "I will just go back in time";
        String picture = "killmonger";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }


    private static void randomisePositionValues(Position position, int mapSize) {
        Random random = new Random();
        position.y = random.nextInt(mapSize);
        position.x = random.nextInt(mapSize);
    }

}
