package controllers;

public interface GameController  {
    void moveSouth();
    void moveNorth();
    void moveEast();
    void moveWest();
    void createNewHero(String type, String name);
    void attack();
    void runAway();
}
