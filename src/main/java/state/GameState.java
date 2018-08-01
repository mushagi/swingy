package state;

import factory.ArenaFactory;
import lombok.Getter;
import lombok.Setter;
import models.players.BlackPanther;
import models.players.Hero;
import models.world.Arena;

import java.util.ArrayList;

public class GameState {
    @Getter private final Arena arena;
    @Getter@Setter
    boolean showSplashScreen;

    private static GameState gameState;
    private GameState() {
        arena = ArenaFactory.newArena();
        showSplashScreen = true;
    }

    public static GameState getInstance() {
        if (gameState == null)
            gameState = new GameState();
        return gameState;
    }

    public ArrayList<Hero> getAvailableHeroes() {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new BlackPanther("Nameless"));
        heroes.add(new BlackPanther("Nameless"));
        heroes.add(new BlackPanther("Nameless"));
        return heroes;
    }
}
