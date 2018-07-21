package factory;

import models.utils.Arena;
import models.utils.GameResults;
import models.utils.Map;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

public class ArenaFactory {
    public static Arena createNewArena(Hero hero)
    {
        Map map = MapFactory.createNewMap(hero.getLevel());
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies(map.getSize());
        map.addPlayers(enemies);
        GameResults gameResults = BattleResultsFactory.createResults();
        return new Arena(hero, enemies, map, true, gameResults, false);
    }


}
