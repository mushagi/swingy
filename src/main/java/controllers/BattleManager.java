package controllers;

import enums.EArtifactType;
import models.artifacts.Artifact;
import models.players.Player;

import java.util.Random;

public class
BattleManager {
    static Random random = new Random();

    private static int getTotalDefence(Player defender) {
        return defender.getDefence() + getArtifactsDefence(defender) + luckyBlock();
    }

    private static int luckyBlock() {
        return 0;
    }

    private static int getArtifactsDefence(Player defender) {
        int totalArtifcatsDefence = 0;
        for (Artifact artificat: defender.getArtifact()) {
            if (artificat.getEArtifactType() == EArtifactType.Armour)
                totalArtifcatsDefence += artificat.getPower();
        }
        return totalArtifcatsDefence;
    }

    private static int getTotalAttack(Player attacker) {
        return attacker.getAttack() + getArtifactsAttack(attacker) + luckyShot();
    }

    private static int luckyShot() {
        return 0;
    }

    private static int getArtifactsAttack(Player attacker) {
        Artifact chosenArtifact = null;
        chosenArtifact = getTheMostPowerfulArtificat(attacker, chosenArtifact);
        return chosenArtifact == null ? 0 : chosenArtifact.getPower();
    }

    private static Artifact getTheMostPowerfulArtificat(Player attacker, Artifact chosenArtifact) {
        for (Artifact artifact : attacker.getArtifact()) {
            if (artifact.getEArtifactType() == EArtifactType.Weapon) {
                if (chosenArtifact == null)
                    chosenArtifact = artifact;
                else
                    if (artifact.getPower() > chosenArtifact.getPower())
                        chosenArtifact = artifact;
            }
        }
        return chosenArtifact;
    }

    private static int getRandomNumberOfAttacks() {
        return 1;
    }

    private static Player getPlayerAttackingFirst(Player hero, Player enemy) {
        return random.nextBoolean() ? hero : enemy;
    }

    public Player battle(Player hero, Player enemy) {
        Player playerOne = getPlayerAttackingFirst(hero, enemy);
        Player playerTwo = playerOne == hero ? enemy : hero;

        while (playerOne.getHitPoint() > 0 && playerTwo.getHitPoint() > 0)
        {
            attack(playerOne, playerTwo);
            attack(playerTwo, playerOne);
        }
        return playerOne.getHitPoint() > playerTwo.getHitPoint() ? playerOne : playerTwo;
    }

    private  void attack(Player attacker, Player defender) {
        for (int i = 0; i < getRandomNumberOfAttacks(); i++) {
            int totalDamage = getTotalAttack(attacker) - getTotalDefence(defender);
            takeDamage(defender, Math.abs(totalDamage));
        }
    }

    private  void takeDamage(Player defender, int totalDamage) {
        defender.setHitPoint(defender.getHitPoint() - totalDamage);
    }
}
