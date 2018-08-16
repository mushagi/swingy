package state;

import enums.HeroType;
import factory.ArenaFactory;
import factory.HeroFactory;
import lombok.Getter;
import lombok.Setter;
import models.players.Hero;
import models.world.Arena;
import utils.ImageRepositoryImp;

import java.util.ArrayList;

public class GameState {
    @Getter private final Arena arena;
    @Getter@Setter
    boolean showSplashScreen;
    ArrayList<Hero> heroes = new ArrayList<>();

    private static GameState gameState;
    private GameState() {
        arena = ArenaFactory.newArena();
        showSplashScreen = true;
    }

    public static GameState getInstance() {
        if (gameState == null){
            gameState = new GameState();
            for (HeroType type : HeroType.values())
                gameState.heroes.add(HeroFactory.newHero(type));
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (Hero hero : gameState.heroes)
                        ImageRepositoryImp.getInstance().loadCache(hero);
                    ImageRepositoryImp.getInstance().loadCache("background");
                    ImageRepositoryImp.getInstance().getImageIcon("lightgrass");
                    ImageRepositoryImp.getInstance().getImageIcon("darkgrass");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
        return gameState;
    }

    public ArrayList<Hero> getAvailableHeroes() {
        return heroes;
    }
}
