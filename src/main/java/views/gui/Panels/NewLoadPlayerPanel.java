package views.gui.Panels;

import views.gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewLoadPlayerPanel extends JPanel {
    private final JButton btnNewHero = new JButton("New Hero");
    private final JButton btnLoadHero = new JButton("Load Hero");

    public NewLoadPlayerPanel() {
        JLabel lblWelcome = new JLabel("Welcome to Swingy in Wakanda");
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





