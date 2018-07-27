package factory;

import controllers.CLIController;
import controllers.GUIController;
import controllers.ArenaController;
import views.cli.CLIInterface;
import views.gui.GUIInterfaceI;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaController arenaController) {
        CLIInterface cliInterface = new CLIInterface();
        return new CLIController(arenaController, cliInterface );
    }

    public static GUIController newGUIController(ArenaController arenaController) {
        GUIInterfaceI guiInterface = new GUIInterfaceI(arenaController);
        return new GUIController(arenaController,guiInterface );
    }
}
