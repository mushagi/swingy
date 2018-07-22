package models;

import factory.PositionFactory;
import models.players.Hero;
import models.players.Player;
import models.world.Map;
import models.world.Position;
import org.junit.jupiter.api.Test;
import factory.MapFactory;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void createAMapWithALevelOfSevenAndMakeAMapWith1521Squares()
    {
        Map map = map = MapFactory.createNewMap(7);
        int expected = 39;
        int actual = map.getSize();
        assertEquals(expected, actual);
    }

    @Test
    void addPlayerToAMap() {
        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);
        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");
        assertTrue(map.addPlayer(position, player));
        Player actual = map.getGameMap().get(position2);
        assertEquals(player, actual);
    }

    @Test
    void addPlayerToAMapY() {
        Position position = new Position(2, 1);
        Position position2 = PositionFactory.clone(position);
        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");
        Player player1 = new Hero("MushagiO");

        assertTrue(map.addPlayer(position, player));
        assertTrue(map.addPlayer(position2, player1));
        assertTrue(map.addPlayer(position, player));
        assertTrue(map.addPlayer(position2, player1));
        assertTrue(map.addPlayer(position, player));
        assertTrue(map.addPlayer(position2, player1));

        System.out.println(position.hashCode());
        System.out.println(position2.hashCode());

        Player actual = map.getGameMap().get(position);
        assertEquals(player1, actual);
    }

    @Test
    void removePlayer() {
        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);

        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");

        assertTrue(map.addPlayer(position, player));
        Player player2 = new Hero("Mushagi");

        assertTrue(map.addPlayer(position, player2));
        Player player3 = new Hero("Mushagi");

        assertTrue(map.addPlayer(position, player3));
        assertEquals(player3, map.getPlayer(position2));

        boolean b= map.removePlayer(position);
        assertTrue(b);
    }

    @Test
    void checkIfPlayerExists() {
        Position position = new Position(0, 0);
        Map map = map = MapFactory.createNewMap(1);
        Player player = new Hero("Mushagi");

        assertTrue(map.addPlayer(position, player));
        assertTrue(map.playerExists(position));
        position.y = (6);
        assertFalse(map.playerExists(position));
    }
}