package views.gui.Panels;

import models.players.Hero;
import views.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collection;

public class NewLoadPlayerPanel extends JPanel {
    JLabel lblWelcome = new JLabel("Welcome to Swingy in Wakanda");
    JButton btnNewHero = new JButton("New Hero");
    JButton btnLoadHero = new JButton("Load Hero");

    public NewLoadPlayerPanel() {
        add(lblWelcome);
        add(btnNewHero);
        add(btnLoadHero);
    }

    public void addToPanelToMainWindow(MainWindow mainWindow) {
        mainWindow.getContentPane().add(mainWindow);
    }

    public void addOnBtnNewListener(ActionListener onNewGameClickedActionListener) {
        btnNewHero.addActionListener(onNewGameClickedActionListener);

    }

    public void addOnBtnLoadHeroListener(ActionListener onLoadHeroClickedActionListener) {
        btnLoadHero.addActionListener(onLoadHeroClickedActionListener);
    }
}





