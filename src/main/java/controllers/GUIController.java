package controllers;

import models.world.Arena;
import services.ArenaService;

public class GUIController extends ArenaController {

    public GUIController(ArenaService arenaService) {
        super(arenaService);
    }

    @Override
    void switchUI() {

    }

    @Override
    public Arena getArena() {
        return null;
    }
}
