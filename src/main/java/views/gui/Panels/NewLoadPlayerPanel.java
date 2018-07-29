package views.gui.Panels;

import views.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewLoadPlayerPanel extends JPanel {
    private final JButton btnNewHero = new JButton("New Hero");
    private final JButton btnLoadHero = new JButton("Load Hero");

    public NewLoadPlayerPanel() {

        this.setLayout(new GridLayout(3, 1));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel headerPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        headerPanel.setSize(this.getSize().width, 10);
        JLabel lblWelcome = new JLabel("Welcome to Swingy in Wakanda");
        headerPanel.add(lblWelcome);
        headerPanel.setBorder(BorderFactory.createEtchedBorder());

        optionsPanel.setLayout(layout);
        optionsPanel.add(btnNewHero);
        optionsPanel.add(btnLoadHero);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        optionsPanel.add(btnNewHero, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10);
        optionsPanel.add(btnLoadHero, gbc);

        JLabel lblAuthor = new JLabel("by mmayibo | WeThinkCode_");

        bottomPanel.add(lblAuthor);

        add(headerPanel);
        add(optionsPanel);
        add(bottomPanel);

    }

    public void addOnBtnNewListener(ActionListener onNewGameClickedActionListener) {
        btnNewHero.addActionListener(onNewGameClickedActionListener);

    }

    public void addOnBtnLoadHeroListener(ActionListener onLoadHeroClickedActionListener) {
        btnLoadHero.addActionListener(onLoadHeroClickedActionListener);
    }
}





