package services;

import factory.EnemyFactory;
import factory.HeroFactory;
import models.players.Hero;
import models.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleServiceTest {

    @Test
    void battle() {
        BattleService battleService = new BattleService();

        Player player = HeroFactory.newHero("BlackPanther", "Mushagi");
        Player enemy = EnemyFactory.newEnemy("BlackW", "The guy");


        System.out.println(player.toString());
        System.out.println(enemy.toString());
        Player won = battleService.battle(player, enemy);
        System.out.println(player.toString());
        System.out.println(enemy.toString());

        System.out.println("Player won " + won.getName());

    }
}