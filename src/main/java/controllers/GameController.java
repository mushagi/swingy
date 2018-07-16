package controllers;

import models.players.Player;

public interface GameController  {
    void moveSouth();
    void moveNorth();
    void moveEast();
    void moveWest();
    void createPlayer(Player hero);
    void attack();
    void runAway();
}
