package controllers;

import models.players.Hero;
import models.players.Player;

public interface GameController  {
    void moveSouth();
    void moveNorth();
    void moveEast();
    void moveWest();
    void createHero(Hero hero);
    void attack();
    void runAway();
}
