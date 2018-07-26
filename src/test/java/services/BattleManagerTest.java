package services;

import controllers.BattleManager;
import factory.EnemyFactory;
import factory.HeroFactory;
import models.players.Player;
import org.junit.jupiter.api.Test;

class BattleManagerTest {

    @Test
    void battle() {
        BattleManager battleManager = new BattleManager();

        Player player = HeroFactory.newHero("BlackPanther", "Mushagi");
        Player enemy = EnemyFactory.newEnemy("BlackW", "The guy");


        System.out.println(player.toString());
        System.out.println(enemy.toString());
        Player won = battleManager.battle(player, enemy);
        System.out.println(player.toString());
        System.out.println(enemy.toString());

        System.out.println("Player won " + won.getName());

    }
}