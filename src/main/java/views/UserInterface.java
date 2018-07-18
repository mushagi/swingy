package views;

import controllers.GameController;
import models.Arena;
import services.ArenaService;

public abstract class UserInterface {
    GameController gameController;
    ArenaService arenaService;
    Arena arena;

    public abstract void update();
}
