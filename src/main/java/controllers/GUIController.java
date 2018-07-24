package controllers;

import services.ArenaService;
import views.UserInterface;

public class GUIController extends ArenaController {

    public GUIController(ArenaService arenaService, UserInterface userInterface) {
        super(arenaService, userInterface);
    }

    @Override
    void switchUI() {

    }
}
