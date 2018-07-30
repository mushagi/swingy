package views.gui.Panels;

import models.world.Arena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private final MapPanel mapPanel = new MapPanel();
    private final ActionsPanel actionsPanel = new ActionsPanel();
    private final MessagesPanel messagesPanel = new MessagesPanel();

    public GamePanel(int mapSize) throws HeadlessException {
        init(mapSize);
    }

    private void init(int mapSize) {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        mapPanel.generateNewMap(mapSize);
        mapPanel.setPreferredSize(new Dimension(600, 450));
        messagesPanel.setPreferredSize(new Dimension(300, 450));
        actionsPanel.setPreferredSize(new Dimension(950, 70));

        this.add(mapPanel);
        this.add(messagesPanel);
        this.add(actionsPanel);

        layout.putConstraint(SpringLayout.NORTH, mapPanel, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, mapPanel, 10, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, messagesPanel, 0, SpringLayout.NORTH, mapPanel);
        layout.putConstraint(SpringLayout.WEST, messagesPanel, 50, SpringLayout.EAST, mapPanel);

        layout.putConstraint(SpringLayout.NORTH, actionsPanel, 20, SpringLayout.SOUTH, mapPanel);
        layout.putConstraint(SpringLayout.WEST, actionsPanel, 0, SpringLayout.WEST, mapPanel);


    }

    public void updateUserInterface(Arena arena) {
        mapPanel.updateMap(arena);
        for (String message: arena.getGameResults().getResult()) {
            messagesPanel.add(message);
        }
    }

    public void addOnNewGameListeners(ActionListener onNewGame) {
        actionsPanel.addOnNewGameListener(onNewGame);
    }

    public void addOnBackToMainMenuListener(ActionListener onBackToMainMenu) {
        actionsPanel.addOnBackToMainMenuQuitListener(onBackToMainMenu);
    }

    public void addOnQuitListener(ActionListener onQuit) {
        actionsPanel.addOnBtnQuitListener(onQuit);
    }

    public void addOnRunawayClickedListener(ActionListener onRunawayClicked) {
        actionsPanel.getRunAway().addActionListener(onRunawayClicked);
    }

    public void addOnFightClickedListener(ActionListener onFightClicked) {
        actionsPanel.getAttack().addActionListener(onFightClicked);
    }

    public void addOnWestClickedListener(ActionListener onWestClicked) {
        actionsPanel.getWest().addActionListener(onWestClicked);
    }

    public void addOnEastClickedListener(ActionListener onEastClicked) {
        actionsPanel.getEast().addActionListener(onEastClicked);
    }

    public void addOnSouthClickedListener(ActionListener onSouthClicked) {
        actionsPanel.getSouth().addActionListener(onSouthClicked);
    }

    public void addOnNorthClickedListener(ActionListener onNorthClicked) {
        actionsPanel.getNorth().addActionListener(onNorthClicked);
    }

    public void addOnBtnQuitListener(ActionListener onBtnQuitClicked) {
        actionsPanel.addOnBtnQuitListener(onBtnQuitClicked);
    }

    public void addOnBackToMainMenuQuitListener(ActionListener onBtnBackToMainMenuListener) {
        actionsPanel.addOnNewGameListener(onBtnBackToMainMenuListener);
    }

    public void addOnNewGameListener(ActionListener onBtnNewGameListener) {
        actionsPanel.addOnNewGameListener(onBtnNewGameListener);
    }
}
