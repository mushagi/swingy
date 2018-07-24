package state;

import factory.ArenaFactory;
import lombok.Getter;
import models.world.Arena;

public class GameData {
    @Getter private  Arena arena;

    private static GameData gameData;

    private GameData() {
        arena = ArenaFactory.newArena();
    }

    public static GameData getInstance()
    {
        if (gameData == null)
            gameData = new GameData();
        return gameData;
    }

}
