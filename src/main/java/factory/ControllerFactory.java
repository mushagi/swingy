package factory;

import controllers.CLIController;
import controllers.GUIController;
import controllers.ArenaController;
import views.cli.CLIInterfaceI;
import views.gui.GUIInterfaceI;

public class ControllerFactory{

    public static CLIController newCLIController(ArenaController arenaController) {
        CLIInterfaceI cliInterface = new CLIInterfaceI();
        return new CLIController(arenaController, cliInterface );
    }

    public static GUIController newGUIController(ArenaController arenaController) {
        GUIInterfaceI guiInterface = new GUIInterfaceI(arenaController);
        return new GUIController(arenaController,guiInterface );
    }
}
