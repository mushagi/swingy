package views.gui;

import controllers.GUIController;
import factory.ControllerFactory;
import models.world.Arena;
import controllers.ArenaController;
import views.IUserInterface;

public class GUIInterfaceI implements IUserInterface {
    private final GUIController controller;

    public GUIInterfaceI(ArenaController arenaController) {
        this.controller = ControllerFactory.newGUIController(arenaController);
    }

    @Override
    public void updateUserInterface(Arena arena) {

    }

    @Override
    public void show() {
    }
}