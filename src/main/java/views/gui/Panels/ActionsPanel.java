package views.gui.Panels;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Getter
class ActionsPanel extends JPanel {
    public final JButton north = new JButton("North");
    final JButton south = new JButton("South");
    final JButton east = new JButton("East");
    final JButton west = new JButton("West");
    final JButton attack = new JButton("Attack");
    final JButton runAway = new JButton("Run Away");
    final JButton newGame = new JButton("New Game");
    final JButton quit = new JButton("Quit");
    final JButton backToMainMenu = new JButton("Menu");

    ActionsPanel() {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        JPanel directionsPanel = getDirectionsPanel();
        JPanel actionsPanel = getActionsPanel();
        JPanel gameOptionsPanel = getGameOptionsPanel();

        add(directionsPanel);
        add(actionsPanel);
        add(gameOptionsPanel);

        layout.putConstraint(SpringLayout.NORTH, directionsPanel, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, actionsPanel, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, actionsPanel, 10, SpringLayout.EAST, directionsPanel);
        layout.putConstraint(SpringLayout.EAST, gameOptionsPanel, 0, SpringLayout.EAST, this);
    }

    private JPanel getGameOptionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel gameOptionsPanel = new JPanel();
        gameOptionsPanel.setLayout(layout);
        gameOptionsPanel.setPreferredSize(new Dimension(200, 80));

        gameOptionsPanel.add(newGame);
        gameOptionsPanel.add(backToMainMenu);
        gameOptionsPanel.add(quit);

        layout.putConstraint(SpringLayout.NORTH, newGame, 5, SpringLayout.NORTH, gameOptionsPanel);
        layout.putConstraint(SpringLayout.WEST, newGame, 5, SpringLayout.WEST, gameOptionsPanel);

        layout.putConstraint(SpringLayout.NORTH, backToMainMenu, 5, SpringLayout.NORTH, gameOptionsPanel);
        layout.putConstraint(SpringLayout.WEST, backToMainMenu, 5, SpringLayout.EAST, newGame);

        layout.putConstraint(SpringLayout.NORTH, quit, 5, SpringLayout.SOUTH, backToMainMenu);
        layout.putConstraint(SpringLayout.WEST, quit, 5, SpringLayout.WEST, backToMainMenu);

        return gameOptionsPanel;
    }

    private JPanel getActionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel actionsPanel = new JPanel();
        actionsPanel.setPreferredSize(new Dimension(170, 80));

        actionsPanel.setLayout(layout);
        actionsPanel.add(attack);
        actionsPanel.add(runAway);

        layout.putConstraint(SpringLayout.NORTH, attack, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.NORTH, runAway, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.WEST, runAway, 5, SpringLayout.EAST, attack);
        return actionsPanel;
    }

    private JPanel getDirectionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel directionsPanel = new JPanel();
        directionsPanel.setPreferredSize(new Dimension(210, 80));
        directionsPanel.setLayout(layout);
        directionsPanel.add(north);
        directionsPanel.add(south);
        directionsPanel.add(east);
        directionsPanel.add(west);

        layout.putConstraint(SpringLayout.WEST, west, 5, SpringLayout.WEST, directionsPanel);
        layout.putConstraint(SpringLayout.WEST, north, 5, SpringLayout.EAST, west);

        layout.putConstraint(SpringLayout.NORTH, west, 5, SpringLayout.SOUTH, north);

        layout.putConstraint(SpringLayout.NORTH, south, 5, SpringLayout.SOUTH, north);
        layout.putConstraint(SpringLayout.WEST, south, 5, SpringLayout.EAST, west);

        layout.putConstraint(SpringLayout.NORTH, east, 5, SpringLayout.SOUTH, north);
        layout.putConstraint(SpringLayout.WEST, east, 5, SpringLayout.EAST, north);
        return directionsPanel;
    }

    public void addOnBtnQuitListener(ActionListener onBtnQuitClicked) {
        quit.addActionListener(onBtnQuitClicked);
    }

    public void addOnBackToMainMenuQuitListener(ActionListener onBtnBackToMainMenuListener) {
        backToMainMenu.addActionListener(onBtnBackToMainMenuListener);
    }

    public void addOnNewGameListener(ActionListener onBtnNewGameListener) {
        newGame.addActionListener(onBtnNewGameListener);
    }
}