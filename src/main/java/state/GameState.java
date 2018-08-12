package state;

import enums.HeroType;
import factory.ArenaFactory;
import factory.HeroFactory;
import lombok.Getter;
import lombok.Setter;
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
        for (HeroType type : HeroType.values())
            heroes.add(HeroFactory.newHero(type));
        return heroes;
    }
}
