package services;

import models.world.Arena;
import enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaServiceTest {

    @Test
    void movePlayer() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arena.getHero().getPosition().y = 0;
        arenaService.moveHero(Direction.NORTH);
        arenaService.moveHero(Direction.NORTH);
        assertEquals("Player won. Destination reached",
                arena.getGameResults().getResult());
    }

    @Test
    void movePlayerNorth() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        System.out.println(arena.getHero().getPosition());
        arenaService.moveHero(Direction.NORTH);
        arenaService.moveHero(Direction.NORTH);
        arenaService.inValidInput();
        assertEquals(0, arena.getHero().getPosition().y);
        assertEquals(arena.getHero(), arena.getMap().getPlayer(arena.getHero().getPosition()));
    }

    @Test
    void movePlayerSouth() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arenaService.moveHero(Direction.SOUTH);
        arenaService.inValidInput();
        assertEquals(3, arena.getHero().getPosition().y);
        assertEquals(arena.getHero(), arena.getMap().getPlayer(arena.getHero().getPosition()));
    }

    @Test
    void movePlayerWest() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arenaService.moveHero(Direction.WEST);
        arenaService.inValidInput();
        assertEquals(1, arena.getHero().getPosition().x);
        assertEquals(arena.getHero(), arena.getMap().getPlayer(arena.getHero().getPosition()));
    }

    @Test
    void movePlayerEast() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arenaService.moveHero(Direction.EAST);
        arenaService.moveHero(Direction.SOUTH);
        arenaService.moveHero(Direction.SOUTH);
        arenaService.inValidInput();
        assertEquals(3, arena.getHero().getPosition().x );
        assertEquals(arena.getHero(), arena.getMap().getPlayer(arena.getHero().getPosition()));
        assertEquals(4, arena.getHero().getPosition().y);
    }

    @Test
     void getLevel() {
        ArenaService arenaService = new ArenaService();
        int level = arenaService.getLevel(9000, 0);
        assertEquals(4, level);
    }

}