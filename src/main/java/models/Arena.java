package models;

import lombok.Getter;

import lombok.Setter;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

@Getter @Setter
public class Arena {
    Hero hero;
    ArrayList<Enemy> enemies;
    Map map;
    boolean isGameInProgress;
    BattleResults lastBattleResults;

    public Arena(Hero hero, ArrayList<Enemy> enemies, Map map, boolean isGameInProgress, BattleResults lastBattleResults) {
        this.hero = hero;
        this.enemies = enemies;
        this.map = map;
        this.isGameInProgress = isGameInProgress;
        this.lastBattleResults = lastBattleResults;
    }
}