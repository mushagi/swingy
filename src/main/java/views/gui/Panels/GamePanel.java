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
        JSplitPane mainSplitPane = new JSplitPane();
        JSplitPane topSplitPane = new JSplitPane();
        mapPanel.generateNewMap(mapSize);
        topSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        topSplitPane.setTopComponent(mapPanel);
        topSplitPane.setBottomComponent(messagesPanel);
        topSplitPane.setResizeWeight(0.7);
        topSplitPane.setDividerSize(1);

        mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setBottomComponent(actionsPanel);
        mainSplitPane.setTopComponent(topSplitPane);
        mainSplitPane.setResizeWeight(0.7);
        mainSplitPane.setDividerSize(1);

        this.add(mainSplitPane);
    }

    public void updateUserInterface(Arena arena) {
        mapPanel.updateMap(arena);
        messagesPanel.add(arena.getGameResults().getResult().toString());
    }

    public void addOnNewGameListeners(ActionListener onNewGame) {
        actionsPanel.getNorth().addActionListener(onNewGame);
    }

    public void addOnBackToMainMenuListener(ActionListener onBackToMainMenu) {
        actionsPanel.getBackToMainMenu().addActionListener(onBackToMainMenu);
    }

    public void addOnQuitListener(ActionListener onQuit) {
        actionsPanel.getBackToMainMenu().addActionListener(onQuit);
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
}
