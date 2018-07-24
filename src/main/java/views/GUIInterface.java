package views;

import controllers.GUIController;
import factory.ControllerFactory;
import models.world.Arena;
import services.ArenaService;

public class GUIInterface implements UserInterface {
    private final GUIController controller;
    private final Arena arena;

    public GUIInterface(ArenaService arenaService) {
        this.controller = ControllerFactory.newGUIController(arenaService, this);
        this.arena = controller.getArena();
    }

    @Override
    public void updateInterface() {
    }

    @Override
    public void show() {
    }
}