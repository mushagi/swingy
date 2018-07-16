package models;

import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

public class Arena {

    Hero hero;
    ArrayList<Enemy> enemies;
    Map map;
    boolean isGameInProgress;
    BattleResults battleResults;

    public Arena(Hero hero, ArrayList<Enemy> enemies, Map map, boolean isGameInProgress, BattleResults battleResults) {
        this.hero = hero;
        this.enemies = enemies;
        this.map = map;
        this.isGameInProgress = isGameInProgress;
        this.battleResults = battleResults;
    }
}
