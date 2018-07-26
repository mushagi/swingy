package services;

import controllers.MapController;
import models.players.APlayer;
import models.players.Hero;
import models.world.Map;
import models.world.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapControllerTest {

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

        MapController mapController = new MapController(map);

        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);
        APlayer player = new Hero("Mushagi");
        assertTrue(mapController.addPlayer(position, player));
        APlayer actual = map.getGameMap().get(position2);
        assertEquals(player, actual);
    }

    @Test
    void addPlayerToAMapY() {
        Map map = map = new Map();
        MapController mapController = new MapController(map);

        Position position = new Position(2, 1);
        Position position2 = new Position(2, 1);

        APlayer player = new Hero("Mushagi");
        APlayer player1 = new Hero("MushagiO");
        assertTrue(mapController.addPlayer(position, player));
        assertTrue(mapController.addPlayer(position2, player1));
        assertTrue(mapController.addPlayer(position, player));
        assertTrue(mapController.addPlayer(position2, player1));
        assertTrue(mapController.addPlayer(position, player));
        assertTrue(mapController.addPlayer(position2, player1));

        System.out.println(position.hashCode());
        System.out.println(position2.hashCode());

        APlayer actual = map.getGameMap().get(position);
        assertEquals(player1, actual);
    }

    @Test
    void removePlayer() {
        Map map = map = new Map();
        MapController mapController = new MapController(map);

        Position position = new Position(0, 0);
        Position position2 = new Position(0, 0);

        APlayer player = new Hero("Mushagi");

        assertTrue(mapController.addPlayer(position, player));
        APlayer player2 = new Hero("Mushagi");

        assertTrue(mapController.addPlayer(position, player2));
        APlayer player3 = new Hero("Mushagi");

        assertTrue(mapController.addPlayer(position, player3));
        assertEquals(player3, mapController.getPlayer(position2));

        boolean b= mapController.removePlayer(position);
        assertTrue(b);
    }

    @Test
    void checkIfPlayerExists() {
        Map map = map = new Map();
        MapController mapController = new MapController(map);

        Position position = new Position(0, 0);
        APlayer player = new Hero("Mushagi");

        assertTrue(mapController.addPlayer(position, player));
        assertTrue(mapController.playerExists(position));
        position.y = (6);

        assertFalse(mapController.playerExists(position));
    }

}