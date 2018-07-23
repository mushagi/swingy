package models.world;

import lombok.Getter;

import lombok.Setter;
import models.players.Hero;
import models.messages.GameResults;

@Getter @Setter
public class Arena {
    Hero hero;
    Map map;
    boolean isGameInProgress;
    GameResults gameResults;
    boolean isPlayerInABattle;

    public Arena(Hero hero, Map map, boolean isGameInProgress, GameResults gameResults, boolean isPlayerInABattle) {
        this.hero = hero;
        this.map = map;
        this.isGameInProgress = isGameInProgress;
        this.gameResults = gameResults;
        this.isPlayerInABattle = isPlayerInABattle;
    }
}