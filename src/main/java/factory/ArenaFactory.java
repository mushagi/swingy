package factory;

import models.Arena;
import models.BattleResults;
import models.Map;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

public class ArenaFactory {
    public static Arena createNewArena(Hero hero)
    {
        Map map = MapFactory.createNewMap(hero.getLevel());
        ArrayList<Enemy> enemies = EnemyFactory.createRandomEnemies();
        BattleResults battleResults = BattleResultsFactory.createResults();
        return new Arena(hero, enemies, map, false, battleResults);
    }
}
