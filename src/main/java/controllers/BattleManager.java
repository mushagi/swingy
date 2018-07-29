package controllers;

import enums.EArtifactType;
import models.artifacts.Artifact;
import models.players.APlayer;

import java.util.Random;

public class
BattleManager {
    private static final Random random = new Random();

    private static int getTotalDefence(APlayer defender) {
        return defender.getDefence() + getArtifactsDefence(defender) + luckyBlock();
    }

    private static int luckyBlock() {
        int randomNumber = random.nextInt(5);
        if(randomNumber == 4) {
            return 10;
        }
        return 0;
    }

    private static int getArtifactsDefence(APlayer defender) {
        int totalArtifactDefence = 0;
        for (Artifact artifact: defender.getArtifact()) {
            if (artifact.getEArtifactType() == EArtifactType.Armour)
                totalArtifactDefence += artifact.getPower();
        }
        return totalArtifactDefence;
    }

    private static int getTotalAttack(APlayer attacker) {
        return attacker.getAttack() + getArtifactsAttack(attacker) + luckyShot(attacker);
    }

    private static int luckyShot(APlayer player) {
        if(player.getType().equals("Hero")) {
            int randomNumber = random.nextInt(5);
            if (randomNumber == 4) {
                return 10;
            }
        }
        return 0;
    }

    private static int getArtifactsAttack(APlayer attacker) {
        Artifact chosenArtifact = getTheMostPowerfulArtifact(attacker);
        return chosenArtifact == null ? 0 : chosenArtifact.getPower();
    }

    private static Artifact getTheMostPowerfulArtifact(APlayer attacker) {
        Artifact mostPowerfulArtifact = null;
        for (Artifact artifact : attacker.getArtifact()) {
            if (artifact.getEArtifactType() == EArtifactType.Weapon) {
                if (mostPowerfulArtifact == null)
                    mostPowerfulArtifact = artifact;
                else
                    if (artifact.getPower() > mostPowerfulArtifact.getPower())
                        mostPowerfulArtifact = artifact;
            }
        }
        return mostPowerfulArtifact;
    }

    private static int getRandomNumberOfAttacks() {
        return 1;
    }

    private static APlayer getPlayerAttackingFirst(APlayer hero, APlayer enemy) {
        return random.nextBoolean() ? hero : enemy;
    }

    public APlayer battle(APlayer hero, APlayer enemy) {
        APlayer playerOne = getPlayerAttackingFirst(hero, enemy);
        APlayer playerTwo = playerOne == hero ? enemy : hero;

        while (playerOne.getHitPoint() > 0 && playerTwo.getHitPoint() > 0)
        {
            attack(playerOne, playerTwo);
            attack(playerTwo, playerOne);
        }
        return playerOne.getHitPoint() > playerTwo.getHitPoint() ? playerOne : playerTwo;
    }

    private  void attack(APlayer attacker, APlayer defender) {
        for (int i = 0; i < getRandomNumberOfAttacks(); i++) {
            int totalDamage = getTotalAttack(attacker) - getTotalDefence(defender);
            takeDamage(defender, Math.abs(totalDamage));
        }
    }

    private  void takeDamage(APlayer defender, int totalDamage) {
        defender.setHitPoint(defender.getHitPoint() - totalDamage);
    }
}