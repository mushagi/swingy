package views.gui;

import models.world.Arena;
import views.ISplashScreen;
import views.IUserInterface;

import javax.swing.*;
import java.awt.*;

public class GUI implements IUserInterface {

    private final MainWindow mainWindow;

    public GUI() {
        mainWindow= new MainWindow();
        mainWindow.setVisible(true);
    }

    @Override
    public void updateUserInterface(Arena arena) {

    }

    @Override
    public void showSplashScreen() {
        ISplashScreen splashScreen = new SplashScreenGUI();
        splashScreen.showSplashScreen();
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
}