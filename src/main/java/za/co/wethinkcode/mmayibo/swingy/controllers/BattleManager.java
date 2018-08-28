package za.co.wethinkcode.mmayibo.swingy.controllers;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.GameResultsController;
import za.co.wethinkcode.mmayibo.swingy.enums.EArtifactType;
import za.co.wethinkcode.mmayibo.swingy.models.world.Artifact;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;

import java.util.Random;

public class
BattleManager {
    private final GameResultsController gameResultsController;
    private final StringBuilder attackSimulation = new StringBuilder();

    private int getTotalDefence(AbstractPlayer defender) {
        attackSimulation.append("Basic defence : ").append(defender.getDefence()).append(". ");
    
        return defender.getDefence() + getArtifactsDefence(defender) + luckyBlock();
    }

    public BattleManager(GameResultsController gameResultsController) {
        this.gameResultsController = gameResultsController;
    }

    public AbstractPlayer battle(AbstractPlayer hero, AbstractPlayer enemy) {
        AbstractPlayer playerOne = getPlayerAttackingFirst(hero, enemy);
        AbstractPlayer playerTwo = playerOne == hero ? enemy : hero;

        gameResultsController.isHeroFirstAttacker(playerOne == hero);
        while (playerOne.getHitPoint() > 0 && playerTwo.getHitPoint() > 0)
        {
            attack(playerOne, playerTwo);
            attack(playerTwo, playerOne);
        }
        
        AbstractPlayer winner = playerOne.getHitPoint() > playerTwo.getHitPoint() ? playerOne : playerTwo;
	    AbstractPlayer loser = winner == playerOne ? playerTwo : playerOne;
	    gameResultsController.setWinnerLoser(winner, loser);
	
	    return winner;
    }

    private  void attack(AbstractPlayer attacker, AbstractPlayer defender) {
        for (int i = 0; i < getRandomNumberOfAttacks(); i++) {
            attackSimulation.setLength(0);
            attackSimulation.append(attacker.getName()).append(" attacks ").append(defender.getName()).append(".\n");
            int totalAttack = getTotalAttack(attacker);
    
            attackSimulation.append(defender.getName()).append(" defends. ");
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
            attackSimulation.append("Lucky block of 10. \n");
            return 10;
        }
        return 0;
    }

    private  int getArtifactsDefence(AbstractPlayer defender) {
        int totalArtifactDefence = 0;
        for (Artifact artifact: defender.getArtifacts()) {
            if (artifact.getEArtifactType() == EArtifactType.Armour) {
                totalArtifactDefence += artifact.getPower();
            }
        }
        attackSimulation.append("Armour defence is ").append(totalArtifactDefence).append(". ");
        return totalArtifactDefence;
    }

    private  int getTotalAttack(AbstractPlayer attacker) {
        return attacker.getAttack() + getArtifactsAttack(attacker) + luckyShot(attacker);
    }

    private  int luckyShot(AbstractPlayer player) {
        if (player.getType().equals("Hero")){
            Random random = new Random();
            int randomNumber = random.nextInt(2);
            if (randomNumber == 1) {
                attackSimulation.append("Lucky shot to the defender. ");
                return 70;
            }
        }

            return 0;
    }

    private  int getArtifactsAttack(AbstractPlayer attacker) {
        int artificactPowers = 0;
        for (Artifact artifact: attacker.getArtifacts()) {
            attackSimulation.append("A ").append(artifact.getName()).append(" with power of ").append(artifact.getPower()).append(" is being used. ");
            if (artifact.getName() != null && artifact.getName().equals("Helm"))
                attacker.setHitPoint(artifact.getPower());
            else
                artificactPowers += artifact.getPower();
        }
        return artificactPowers;
    }

    private  int getRandomNumberOfAttacks() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private AbstractPlayer getPlayerAttackingFirst(AbstractPlayer hero, AbstractPlayer enemy) {
        Random random = new Random();
        return random.nextBoolean() ? hero : enemy;
    }

    private  void takeDamage(AbstractPlayer defender, int totalDamage) {
        defender.setHitPoint(defender.getHitPoint() - totalDamage);
    }
}