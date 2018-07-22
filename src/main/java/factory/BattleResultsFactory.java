package factory;

import models.messages.GameResults;

class BattleResultsFactory {

    public static GameResults createResults() {
        return new GameResults();
    }
}
