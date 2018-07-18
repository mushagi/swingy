package models;

import models.players.Hero;
import models.players.Player;
import org.junit.jupiter.api.Test;
import factory.MapFactory;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void createAMapWithALevelOfSevenAndMakeAMapWith1521Squares()
    {
        Map map = map = MapFactory.createNewMap(7);
        int expected = 39*39;
        int actual = map.getSize();
        assertEquals(expected, actual);
    }

    @Test
    void addPlayerToAMap() {
        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);
        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");
        assertEquals(true, map.addPlayer(position, player));
        Player actual = map.getGameMap().get(position2);
        assertEquals(player, actual);
    }

    @Test
    void removePlayer() {
        Position position = new Position(0, 0);
        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");

        assertEquals(true, map.addPlayer(position, player));
        Player player2 = new Hero("Mushagi");
        position.setX(1);
        assertEquals(true, map.addPlayer(position, player2));
        Player player3 = new Hero("Mushagi");
        position.setX(2);
        assertEquals(true, map.addPlayer(position, player3));
        Player player4 = new Hero("Mushagi");
        position.setX(3);
        assertEquals(true, map.addPlayer(position, player4));

        assertEquals(4, map.getNumberOfPlayers());
        assertEquals(true, map.removePlayer(player2));
        assertEquals(true, map.removePlayer(player3));
        assertEquals(2, map.getNumberOfPlayers());

    }
}