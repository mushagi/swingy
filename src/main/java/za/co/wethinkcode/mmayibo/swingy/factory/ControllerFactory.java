package za.co.wethinkcode.mmayibo.swingy.factory;

import za.co.wethinkcode.mmayibo.swingy.controllers.cli.CLIController;
import za.co.wethinkcode.mmayibo.swingy.controllers.gui.GUIController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.views.cli.CLI;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaController arenaController) {
        CLI cli = new CLI();
        return new CLIController(arenaController, cli);
    }

    public static GUIController newGUIController(ArenaController arenaController) {
        return new GUIController(arenaController );
    }
}
