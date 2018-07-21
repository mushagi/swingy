package factory;

import models.utils.GameResults;

class BattleResultsFactory {

    public static GameResults createResults() {
        return new GameResults();
    }
}
