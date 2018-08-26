package za.co.wethinkcode.mmayibo.swingy.utils;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FullScreenMac {
    public static void enableOSXFullscreen(Window window) {
        if (System.getProperty("os.name").toLowerCase().startsWith("mac os x"))
        {
            try {
                Class util = Class.forName("com.apple.eawt.FullScreenUtilities");
                Class params[] = new Class[]{Window.class, Boolean.TYPE};
                Method method = util.getMethod("setWindowCanFullScreen", params);
                method.invoke(util, window, true);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
