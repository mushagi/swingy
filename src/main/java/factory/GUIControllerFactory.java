package factory;

import controllers.GUIController;

public class GUIControllerFactory {
    public static GUIController newGuiController()
    {
        return new GUIController();
    }
}
