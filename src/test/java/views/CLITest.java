package views;

import enums.HeroType;
import factory.ArenaFactory;
import factory.HeroFactory;
import models.players.Hero;
import models.world.Arena;
import org.junit.jupiter.api.Test;
import views.cli.CLI;
import views.cli.CliMapCell;
import views.cli.MapCLi;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CLITest {

    @Test
    void run() {
        MapCLi mapCell = new MapCLi();
        Arena arena = ArenaFactory.newArena();
        arena.getMap().setSize(12);
        Hero hero = HeroFactory.newHero(HeroType.BLACK_PANTHER);
        arena.setHero(hero);
        arena.getMap().getGameMap().put(hero.getPosition(), hero);
        mapCell.updateMap(arena);
    }

    @Test
    void displayOptions() {
        CLI cliUi= new CLI();
        
    }

    @Test
    void printHeader() {
        CLI cliUi= new CLI();
    }
}