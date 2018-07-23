package services;

import enums.Direction;
import factory.ArenaFactory;
import factory.HeroFactory;
import lombok.Getter;
import models.players.Hero;
import models.players.Player;
import models.world.Arena;
import models.world.Map;
import state.GameData;
import utils.Formulas;

import java.util.Random;

public class ArenaService {
    @Getter private Arena arena;
    private final MapService mapService;
    private final GameResultsService gameResultsService;
    private final BattleService battleService;


    public ArenaService() {
        this.mapService = new MapService();
        this.gameResultsService = new GameResultsService();
        this.battleService = new BattleService();
    }

    public void moveHero(Direction direction) {
        gameResultsService.clearGameResults();
        if (!arena.isPlayerInABattle()) {
            if (mapService.isMoveWithinBounds(direction)) {
                if (!mapService.moveHeroInTheMap(direction))
                    setHeroToBattle();
            }
            else
                playerReachedDestination();
        }
        else
            gameResultsService.setGameError("Cannot move while player is in a battle");
    }

    public void fight() {
        gameResultsService.clearGameResults();
        if (arena.isPlayerInABattle()) {
            Player enemy = arena.getMap().getGameMap().get(arena.getHero().getPosition());
            Player won = battleService.battle(arena.getHero(), enemy);
            if (won == arena.getHero()) {
                gameResultsService.addMessage("This guy " + won.getName() + " won");
                arena.setPlayerInABattle(false);
                arena.getMap().addPlayer(arena.getHero());
                heroLevelUp();
            }
            else
                gameOver(enemy);
        } else
            gameResultsService.setGameError("Cannot attack while there is no enemy.");
    }

    private void heroLevelUp() {
        int level = getLevel(arena.getHero().getExperience(), arena.getHero().getLevel());
        arena.getHero().setLevel(level);
    }

    int getLevel(int experience, int level) {
        if (experience < Formulas.calculateRequiredLevelExperience(level + 1))
            return level;
        return getLevel(experience, ++level);
    }


    private void gameOver(Player enemy) {
        gameResultsService.addMessage("Enemy " + enemy.getName()+" won");
        gameResultsService.isGameWon(false);
        arena.setGameInProgress(false);
    }

    public void runAway() {
        Random random = new Random();
        boolean isRunningAwayAllowed = random.nextBoolean();
        if (isRunningAwayAllowed && mapService.heroFoundARunAwayPosition())
            gameResultsService.addMessage("Run away a success.");
        else {
            gameResultsService.addMessage("Run away was not possible. Fight to the death");
            fight();
        }
        arena.setPlayerInABattle(false);
    }

    private void setHeroToBattle() {
        arena.setPlayerInABattle(true);
        gameResultsService.addMessage("You encountered an enemy");
    }

    private void playerReachedDestination() {
        arena.setGameInProgress(false);
        gameResultsService.addMessage("Player reached Destination. Mission accomplished");
    }

    public void inValidInput() {
        gameResultsService.setGameError("Invalid input");
    }

    private void registerArena(Hero hero, Map map)
    {
        GameData.arena = ArenaFactory.newArena(hero, map);
        arena = GameData.arena;
    }

    private Map registerMap(Hero hero) {
        return mapService.createMap(hero);
    }

    public void registerHero(String type, String name) {
        Hero hero = HeroFactory.newHero(type, name);
        registerMapAndHero(hero);
        registerGameResult();
    }

    public void registerGameResult() {
        gameResultsService.registerGameResults(arena.getGameResults());
    }

    public void registerHero(Hero hero) {
        registerMapAndHero(hero);
    }

    private void registerMapAndHero(Hero hero) {
        Map map = registerMap(hero);
        registerArena(hero, map);
    }
}