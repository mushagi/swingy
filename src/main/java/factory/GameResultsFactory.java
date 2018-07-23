package factory;

import models.messages.GameResults;

import java.util.ArrayList;

class GameResultsFactory {

    public static GameResults newGameResults() {
        return new GameResults(new ArrayList<String>(), false, false);
    }
}