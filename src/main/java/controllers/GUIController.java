package controllers;

import views.gui.GUIInterfaceI;

public class GUIController extends AUIController {
    GUIInterfaceI guiInterface;
    public GUIController(ArenaController arenaController, GUIInterfaceI guiInterface) {
        super(arenaController);
        this.guiInterface =guiInterface;
    }

    @Override
    void switchUI() {

    }

    @Override
    void updateUserInterface() {

    }

    @Override
    public void run() {

    }
}
