package services;

import controllers.BattleManager;
import factory.EnemyFactory;
import factory.HeroFactory;
import models.players.APlayer;
import org.junit.jupiter.api.Test;

class BattleManagerTest {

    @Test
    void battle() {
        BattleManager battleManager = new BattleManager();

        APlayer player = HeroFactory.newHero("BlackPanther", "Mushagi");
        APlayer enemy = EnemyFactory.newEnemy("BlackW", "The guy");


        System.out.println(player.toString());
        System.out.println(enemy.toString());
        APlayer won = battleManager.battle(player, enemy);
        System.out.println(player.toString());
        System.out.println(enemy.toString());

        System.out.println("APlayer won " + won.getName());

    }
}