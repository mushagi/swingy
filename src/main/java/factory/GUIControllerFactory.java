package factory;

import controllers.GUIController;

class GUIControllerFactory {
    public static GUIController newGuiController()
    {
        return new GUIController();
    }
}
