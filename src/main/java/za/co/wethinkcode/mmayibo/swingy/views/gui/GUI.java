package za.co.wethinkcode.mmayibo.swingy.views.gui;

import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.utils.FullScreenMac;
import za.co.wethinkcode.mmayibo.swingy.views.ISplashScreen;
import za.co.wethinkcode.mmayibo.swingy.views.IUserInterface;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class GUI implements IUserInterface {

    private final MainWindow mainWindow;

    public GUI() {
        mainWindow= new MainWindow();
        mainWindow.setVisible(true);
        showSplashScreen();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        FullScreenMac.enableOSXFullscreen(mainWindow);
    }

    @Override
    public void updateUserInterface(Arena arena) {
    
    }

    @Override
    public void showSplashScreen() {
        ISplashScreen splashScreen = new SplashScreenGUI();
        splashScreen.showSplashScreen();
        addMainWindowContentPane((JPanel) splashScreen);
    }

    @Override
    public void showQuitDialogue() {

    }

    public void addMainWindowContentPane(Container pane) {
        mainWindow.setContentPane(pane);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        pane.setFocusable(true);
        pane.requestFocusInWindow();
    }
    
    public void close() {
        mainWindow.setVisible(false);
        mainWindow.dispose();
    }
}