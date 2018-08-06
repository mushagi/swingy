package controllers;

import controllers.models.GameResultsController;
import enums.EArtifactType;
import models.artifacts.Artifact;
import models.players.APlayer;

import java.util.Random;

public class
BattleManager {
    private GameResultsController gameResultsController;
    private StringBuilder attackSimulation = new StringBuilder();

    private int getTotalDefence(APlayer defender) {
        return defender.getDefence() + getArtifactsDefence(defender) + luckyBlock();
    }

    public BattleManager(GameResultsController gameResultsController) {
        this.gameResultsController = gameResultsController;
    }

    public APlayer battle(APlayer hero, APlayer enemy) {
        APlayer playerOne = getPlayerAttackingFirst(hero, enemy);
        APlayer playerTwo = playerOne == hero ? enemy : hero;

        gameResultsController.isHeroFirstAttacker(playerOne == hero);
        while (playerOne.getHitPoint() > 0 && playerTwo.getHitPoint() > 0)
        {
            attack(playerOne, playerTwo);
            attack(playerTwo, playerOne);
        }
        
        APlayer winner = playerOne.getHitPoint() > playerTwo.getHitPoint() ? playerOne : playerTwo;
	    APlayer loser = winner == playerOne ? playerTwo : playerOne;
	    gameResultsController.setWinnerLoser(winner, loser);
	
	    return winner;
    }

    private  void attack(APlayer attacker, APlayer defender) {
        for (int i = 0; i < getRandomNumberOfAttacks(); i++) {
            attackSimulation.setLength(0);
            attackSimulation.append(attacker.getName()).append(" attacks ").append(defender.getName()).append(".\n");
            int totalAttack = getTotalAttack(attacker);
            
            attackSimulation.append(defender.getName() + " defends.\n");
            int totalDefence = getTotalDefence(defender);
            gameResultsController.addAnAttackSimulation(attackSimulation.toString());

            int totalDamage = totalAttack - totalDefence;
            takeDamage(defender, Math.abs(totalDamage));
        }
    }

    private  int luckyBlock() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        if(randomNumber == 4) {
            attackSimulation.append("Lucky block\n");
            return 10;
        }
        return 0;
    }

    private  int getArtifactsDefence(APlayer defender) {
        int totalArtifactDefence = 0;
        for (Artifact artifact: defender.getArtifact()) {
            if (artifact.getEArtifactType() == EArtifactType.Armour) {
                totalArtifactDefence += artifact.getPower();
            }
        }
        attackSimulation.append("Armour defence is ").append(totalArtifactDefence).append(".\n");
        return totalArtifactDefence;
    }

    private  int getTotalAttack(APlayer attacker) {
        return attacker.getAttack() + getArtifactsAttack(attacker) + luckyShot(attacker);
    }

    private  int luckyShot(APlayer player) {
        if(player.getType().equals("Hero")) {
            Random random = new Random();
            int randomNumber = random.nextInt(5);
            if (randomNumber == 4) {
                attackSimulation.append("Lucky shot to the defender\n");
                return 10;
            }
        }
        return 0;
    }

    private  int getArtifactsAttack(APlayer attacker) {
        Artifact chosenArtifact = getTheMostPowerfulArtifact(attacker);
        if (chosenArtifact != null)
            attackSimulation.append("A ").append(chosenArtifact.getPower()).append(" is being used. ");
        return chosenArtifact == null ? 0 : chosenArtifact.getPower();
    }

    private  Artifact getTheMostPowerfulArtifact(APlayer attacker) {
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

    private  int getRandomNumberOfAttacks() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private  APlayer getPlayerAttackingFirst(APlayer hero, APlayer enemy) {
        Random random = new Random();
        return random.nextBoolean() ? hero : enemy;
    }

    private  void takeDamage(APlayer defender, int totalDamage) {
        defender.setHitPoint(defender.getHitPoint() - totalDamage);
    }
}