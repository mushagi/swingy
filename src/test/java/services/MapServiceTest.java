package services;

import models.players.Hero;
import models.players.Player;
import models.world.Map;
import models.world.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapServiceTest {

    @Test
    void moveHeroInTheMap() {
    }

    @Test
    void addMapValues() {
    }

    @Test
    void isMoveWithinBounds() {
    }

    @Test
    void heroFoundARunAwayPosition() {
    }
    @Test
    void addPlayerToAMap() {
        Map map = map = new Map();

        MapService mapService = new MapService(map);

        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);
        Player player = new Hero("Mushagi");
        assertTrue(mapService.addPlayer(position, player));
        Player actual = map.getGameMap().get(position2);
        assertEquals(player, actual);
    }

    @Test
    void addPlayerToAMapY() {
        Map map = map = new Map();
        MapService mapService = new MapService(map);

        Position position = new Position(2, 1);
        Position position2 = new Position(2, 1);

        Player player = new Hero("Mushagi");
        Player player1 = new Hero("MushagiO");
        assertTrue(mapService.addPlayer(position, player));
        assertTrue(mapService.addPlayer(position2, player1));
        assertTrue(mapService.addPlayer(position, player));
        assertTrue(mapService.addPlayer(position2, player1));
        assertTrue(mapService.addPlayer(position, player));
        assertTrue(mapService.addPlayer(position2, player1));

        System.out.println(position.hashCode());
        System.out.println(position2.hashCode());

        Player actual = map.getGameMap().get(position);
        assertEquals(player1, actual);
    }

    @Test
    void removePlayer() {
        Map map = map = new Map();
        MapService mapService = new MapService(map);

        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);

        Player player = new Hero("Mushagi");

        assertTrue(mapService.addPlayer(position, player));
        Player player2 = new Hero("Mushagi");

        assertTrue(mapService.addPlayer(position, player2));
        Player player3 = new Hero("Mushagi");

        assertTrue(mapService.addPlayer(position, player3));
        assertEquals(player3, mapService.getPlayer(position2));

        boolean b= mapService.removePlayer(position);
        assertTrue(b);
    }

    @Test
    void checkIfPlayerExists() {
        Map map = map = new Map();
        MapService mapService = new MapService(map);

        Position position = new Position(0, 0);
        Player player = new Hero("Mushagi");

        assertTrue(mapService.addPlayer(position, player));
        assertTrue(mapService.playerExists(position));
        position.y = (6);

        assertFalse(mapService.playerExists(position));
    }

}