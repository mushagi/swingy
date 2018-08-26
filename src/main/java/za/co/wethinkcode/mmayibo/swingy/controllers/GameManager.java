package za.co.wethinkcode.mmayibo.swingy.controllers;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.enums.EInterfaceType;
import za.co.wethinkcode.mmayibo.swingy.factory.ArenaControllerFactory;
import za.co.wethinkcode.mmayibo.swingy.factory.ControllerFactory;

public class GameManager {
    public void startGame(EInterfaceType type) {
        ArenaController arenaController = ArenaControllerFactory.newArenaControllerFromGameData();

        AbstractUIController uiController = type ==
                EInterfaceType.CLI ?
                ControllerFactory.newCLIController(arenaController):
                ControllerFactory.newGUIController(arenaController);

        uiController.run();
    }
}