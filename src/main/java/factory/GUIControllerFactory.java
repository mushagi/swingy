package factory;

import controllers.GUIController;
import services.ArenaService;

class GUIControllerFactory {
    public static GUIController newGuiController()
    {
        ArenaService arenaService = new ArenaService();
        return new GUIController(arenaService);
    }
}
