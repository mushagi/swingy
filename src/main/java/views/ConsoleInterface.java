package views;

import factory.CLIControllerFactory;
import factory.HeroFactory;
import models.Arena;
import models.players.Hero;
import services.ArenaService;

public class ConsoleInterface extends UserInterface{
    private Arena arena;

    public void run() {
        ArenaService.getInstance().registerUserInterface(this);

        gameController = CLIControllerFactory.newGuiController(ArenaService.getInstance());

        loadHero();

        arena = ArenaService.getInstance().getArena();

        gameLoop();
    }

    private void loadHero() {
        String input;
        Hero hero;

        boolean isNewHero = true;
        System.out.println("Do you want to create a new player or load a player?/n1. New/2. Load");
        input = "1";

        hero = isNewHero ? createNewHero() : loadExistingHero();
        gameController.createHero(hero);
    }

    private Hero loadExistingHero() {
        return null;
    }

    private Hero createNewHero() {
        Hero hero;
        String heroName;


        System.out.println("Enter your name: ");
        heroName = "Scan hero name";

        System.out.println("Choose a hero: ");

        return HeroFactory.newHero(heroName);
    }

    private void gameLoop()
    {
        while (arena.isGameInProgress()) {
            getInput();
        }
    }

    private void getInput() {

    }

    @Override
    public void update() {

    }
}
