package factory;

import controllers.GUIController;
import controllers.GameController;

import java.lang.reflect.Constructor;

public class GUIControllerFactory {
    public static GUIController newGuiController()
    {
        return new GUIController();
    }
}
