package services;

import controllers.BattleManager;
import controllers.models.GameResultsController;
import factory.EnemyFactory;
import factory.HeroFactory;
import models.messages.GameResults;
import models.players.APlayer;
import org.junit.jupiter.api.Test;

class BattleManagerTest {

    @Test
    void battle() {
        BattleManager battleManager = new BattleManager(new GameResultsController(new GameResults()));

        APlayer enemy = EnemyFactory.newEnemy("BlackW", "The guy");



    }
}