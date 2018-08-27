package services;

import za.co.wethinkcode.mmayibo.swingy.controllers.BattleManager;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.GameResultsController;
import za.co.wethinkcode.mmayibo.swingy.factory.EnemyFactory;
import za.co.wethinkcode.mmayibo.swingy.models.messages.GameResults;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import org.junit.jupiter.api.Test;

class BattleManagerTest {

    @Test
    void battle() {
        BattleManager battleManager = new BattleManager(new GameResultsController(new GameResults()));




    }
}