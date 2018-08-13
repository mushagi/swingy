package controllers;

import controllers.models.ArenaController;
import enums.EInterfaceType;
import factory.ArenaControllerFactory;
import factory.ControllerFactory;

public class GameManager {
    public void startGame(EInterfaceType type) {
        ArenaController arenaController = ArenaControllerFactory.newArenaControllerFromGameData();

        AUIController uiController = type ==
                EInterfaceType.CLI ?
                ControllerFactory.newCLIController(arenaController):
                ControllerFactory.newGUIController(arenaController);

        uiController.run();
    }
}