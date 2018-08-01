package factory;

import controllers.cli.CLIController;
import controllers.gui.GUIController;
import controllers.models.ArenaController;
import views.cli.CLI;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaController arenaController) {
        CLI cli = new CLI();
        return new CLIController(arenaController, cli);
    }

    public static GUIController newGUIController(ArenaController arenaController) {
        return new GUIController(arenaController );
    }
}
