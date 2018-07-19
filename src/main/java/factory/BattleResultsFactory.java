package factory;

import models.utils.GameResults;

public class BattleResultsFactory {

    public static GameResults createResults() {
        return new GameResults();
    }
}
