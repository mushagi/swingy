package factory;

import controllers.GUIController;
import services.ArenaService;

class GUIControllerFactory {
    public static GUIController newGuiController()
    {
        ArenaService arenaService = ArenaServiceFactory.newArenaServiceFromGameData();
        return new GUIController(arenaService);
    }
}
