package state;

import factory.ArenaFactory;
import lombok.Getter;
import lombok.Setter;
import models.world.Arena;

public class GameState {
    @Getter private  Arena arena;
    @Getter@Setter
    boolean showSplashScreen;

    private static GameState gameState;
    private GameState() {
        arena = ArenaFactory.newArena();
        showSplashScreen = true;
    }

    public static GameState getInstance()
    {
        if (gameState == null)
            gameState = new GameState();
        return gameState;
    }

}
