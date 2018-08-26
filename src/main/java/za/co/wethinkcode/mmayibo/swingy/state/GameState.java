package za.co.wethinkcode.mmayibo.swingy.state;

import za.co.wethinkcode.mmayibo.swingy.enums.HeroType;
import za.co.wethinkcode.mmayibo.swingy.factory.ArenaFactory;
import za.co.wethinkcode.mmayibo.swingy.factory.HeroFactory;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.utils.ImageRepositoryImp;

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
        if (gameState == null){
            gameState = new GameState();
   
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (Hero hero : getAvailableHeroes())
                        ImageRepositoryImp.getInstance().loadCache(hero.getPicture());
                    ImageRepositoryImp.getInstance().loadCache("background");
                    ImageRepositoryImp.getInstance().loadCache("danger");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
        return gameState;
    }

    public static ArrayList<Hero> getAvailableHeroes() {
    	final ArrayList<Hero> heroes = new ArrayList<>();
	    for (HeroType type : HeroType.values())
	    	heroes.add(HeroFactory.newHero(type));
        return heroes;
    }
}
