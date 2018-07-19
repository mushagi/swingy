package models.utils;

import lombok.Getter;

import lombok.Setter;
import enums.Direction;
import models.players.Enemy;
import models.players.Hero;

import java.util.ArrayList;

@Getter @Setter
public class Arena {
    Hero hero;
    ArrayList<Enemy> enemies;
    Map map;
    boolean isGameInProgress;
    GameResults gameResults;
    boolean isPlayerInABattle;
    Direction lastPlayerDirection;

    public Arena(Hero hero, ArrayList<Enemy> enemies, Map map, boolean isGameInProgress, GameResults gameResults, boolean isPlayerInABattle) {
        this.hero = hero;
        this.enemies = enemies;
        this.map = map;
        this.isGameInProgress = isGameInProgress;
        this.gameResults = gameResults;
    }
}