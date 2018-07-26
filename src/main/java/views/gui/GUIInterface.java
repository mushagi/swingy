package views.gui;

import controllers.GUIController;
import factory.ControllerFactory;
import models.world.Arena;
import controllers.ArenaController;
import views.UserInterface;

public class GUIInterface implements UserInterface {
    private final GUIController controller;
    private final Arena arena;

    public GUIInterface(ArenaController arenaController) {
        this.controller = ControllerFactory.newGUIController(arenaController, this);
        this.arena = controller.getArena();
    }

    @Override
    public void updateUserInterface() {
    }

    @Override
    public void show() {
    }
}