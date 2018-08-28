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
        int level = 9;
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
        int experience = 100;
        int attack = 90;
        int defence = 90;
        String winningSpeech = "I'm radio active man";
        String losingSpeech = "Damn";
        String picture = "radioactive";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newManApe(int level) {
        String name = "Man Ape";
        int experience = 100;
        int attack = 90;
        int defence = 60;
        String winningSpeech = "Ape kill ape if ape bad";
        String losingSpeech = "Ape don't kill ape";
        String picture = "manape";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newReverendAchebe(int level) {
        String name = "Reverend Achebe";
        int experience = 100;
        int attack = 10;
        int defence = 10;
        String winningSpeech = "The Gods are good";
        String losingSpeech = "Evil will not last forever";
        String picture = "achebe";
        return new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
    }

    private static Enemy newKillMonger(int level) {
        String name = "Kill Monger";
        int experience = 100;
        int attack = 70;
        int defence = 70;
        String winningSpeech = "Wakanda must rule the world";
        String losingSpeech = "Damn you, traitor";
        String picture = "killmonger";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        enemy.getArtifacts().add(ArtificatFactory.newGun());
        return enemy;
    }

    private static Enemy newDrDoom(int level) {
        String name = "Dr Doom";
        int experience = 100;
        int attack = 90;
        int defence = 70;
        String winningSpeech = "Doom will whatever brah";
        String losingSpeech = "Okay i'm getting tired of typing now";
        String picture = "doom";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newKnife());
        enemy.getArtifacts().add(ArtificatFactory.newKnife());
        return enemy;
    }

    private static Enemy newWhiteWolf(int level) {
        String name = "White wolf";
        int experience = 100;
        int attack = 100;
        int defence = 60;
        String winningSpeech = "Damn them wakandains";
        String losingSpeech = "Fuck. This is long";
        String picture = "whitewolf";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        return enemy;
    }

    private static Enemy newKlaue(int level) {
        String name = "New Klaue";
        int experience = 100;
        int attack = 100;
        int defence = 100;
        String winningSpeech = "I will sell your body to the highest bidder";
        String losingSpeech = "I fear no man";
        String picture = "klaue";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        enemy.getArtifacts().add(ArtificatFactory.newGun());
        return enemy;
    }

    private static Enemy newBaronzemo(int level) {
        String name = "Baronzemo";
        int experience = 100;
        int attack = 30;
        int defence = 80;
        String winningSpeech = "I don't know this guy";
        String losingSpeech = "Who am i?";
        String picture = "baronzemo";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newKnife());
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        return enemy;
    }

    private static Enemy newSuperGiant(int level) {
        String name = "Super Giant";
        int experience = 100;
        int attack = 100;
        int defence = 70;
        String winningSpeech = "I have crushed your skull, puny hero";
        String losingSpeech = "I will be back";
        String picture = "supergiant";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newGun());
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        return enemy;
    }

    private static Enemy newThanos(int level) {
        String name = "Thanos";
        int experience = 100;
        int attack = 150;
        int defence = 150;
        String winningSpeech = "You should have aimed for the head";
        String losingSpeech = "I will just go back in time";
        String picture = "thanos";
        Enemy enemy =  new Enemy(name, level, experience, attack, defence, winningSpeech, losingSpeech, picture);
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        enemy.getArtifacts().add(ArtificatFactory.newSword());
        return enemy;
    }


    private static void randomisePositionValues(Position position, int mapSize) {
        Random random = new Random();
        position.y = random.nextInt(mapSize);
        position.x = random.nextInt(mapSize);
    }

}
