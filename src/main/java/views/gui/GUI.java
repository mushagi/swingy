package views.gui;

import models.players.Hero;
import models.world.Arena;
import views.IUserInterface;
import views.gui.Panels.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class GUI implements IUserInterface {

    MainWindow mainWindow;

    public GUI() {
        mainWindow= new MainWindow();
        mainWindow.setVisible(true);
    }

    @Override
    public void updateUserInterface(Arena arena) {

    }

    @Override
    public void show(Arena arena) {

    }

    @Override
    public void showSplashScreen() {

    }

    @Override
    public void showQuitDialogue() {

    }

    @Override
    public void newGameDialogue() {

    }



    public void showHeroSelection() {
        NewLoadPlayerPanel createNewPlayerPanel = new NewLoadPlayerPanel();
        mainWindow.setContentPane(createNewPlayerPanel);
    }

    public void ShowHeroListPanel(Collection<Hero> heroes) {
        ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
        mainWindow.setContentPane(chooseHeroPanel);
    }

    public void addOnCreateLoadPlayerPanelBtnNewClickedListener() {

    }

    public void addMainWindowContentPane(Container pane) {
        mainWindow.setContentPane(pane);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}