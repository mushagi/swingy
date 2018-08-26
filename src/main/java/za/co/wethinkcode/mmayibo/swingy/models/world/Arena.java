package za.co.wethinkcode.mmayibo.swingy.models.world;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.messages.GameResults;

@Getter @Setter
public class Arena {
    Hero hero;
    Map map;
    boolean isGameInProgress;
    GameResults gameResults;
    boolean isPlayerInABattle;
    private String playerName;
    private boolean isPLayerNameLoaded;
    private boolean isHeroRunningAway;

    public Arena(Hero hero, Map map, boolean isGameInProgress, GameResults gameResults, boolean isPlayerInABattle) {
        this.hero = hero;
        this.map = map;
        this.isGameInProgress = isGameInProgress;
        this.gameResults = gameResults;
        this.isPlayerInABattle = isPlayerInABattle;
        this.isHeroRunningAway = false;
    }
}