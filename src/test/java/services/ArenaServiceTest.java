package services;

import factory.HeroFactory;
import models.utils.Arena;
import enums.Direction;
import models.utils.Position;
import models.players.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaServiceTest {

    @Test
    void movePlayer() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arena.getHero().getPosition().setY(1);
        arenaService.movePlayer(Direction.NORTH);
        assertEquals("Player won. Destination reached",
                arena.getGameResults().getGameErrorMessage().getErrorMessage());
    }

    @Test
    void movePlayerNorth() {
        ArenaService arenaService = new ArenaService();
        arenaService.registerHero("BlackPanther", "Mushagi");

        Arena arena = arenaService.getArena();
        arenaService.movePlayer(Direction.NORTH);
        assertEquals(1, arena.getHero().getPosition().getY());
        assertEquals(arena.getHero(), arena.getMap().getPlayer(arena.getHero().getPosition()));
    }

    @Test
    void registerPlayer() {
    }

    @Test
    void fight() {
    }

    @Test
    void runAway() {
    }

    @Test
    void registerUserInterface() {
    }



    @Test
    void createArena() {
    }

    @Test
    void isGameInProgress() {
    }

    @Test
    void isHeroInArena() {
    }

    @Test
    void movePlayer1() {
    }

    @Test
    void registerPlayer1() {
    }

    @Test
    void fight1() {
    }

    @Test
    void runAway1() {
    }

    @Test
    void createArena1() {
    }

    @Test
    void isGameInProgress1() {
    }

    @Test
    void isHeroInArena1() {
    }


}