package controllers;

import controllers.gui.GUIController;
import enums.EInterfaceType;
import factory.ArenaControllerFactory;
import factory.ControllerFactory;

public class GameController {

    public void startGame(EInterfaceType type) {
        ArenaController arenaController = ArenaControllerFactory.newArenaControllerFromGameData();
        if (type == EInterfaceType.CLI) {
            CLIController controller = ControllerFactory.newCLIController(arenaController);
            controller.run();
        }
        else if (type == EInterfaceType.GUI) {
            GUIController controller = ControllerFactory.newGUIController(arenaController);
            controller.run();
        }
    }
}
