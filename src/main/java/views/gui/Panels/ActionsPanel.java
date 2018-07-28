package views.gui.Panels;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
class ActionsPanel extends JPanel {
    final JButton north;
    final JButton south;
    final JButton east;
    final JButton west;
    final JButton attack;
    final JButton runAway;
    final JButton newGame;
    final JButton quit;
    final JButton backToMainMenu;

    ActionsPanel() {
        this.setBackground(new java.awt.Color(100, 30, 4));

        north = new JButton("North");
        south = new JButton("South");
        east = new JButton("East");
        west = new JButton("West");
        attack = new JButton("Attack");
        runAway = new JButton("Run Away");
        newGame = new JButton("New Game");
        quit = new JButton("Quit");
        backToMainMenu = new JButton("Menu");

        JSplitPane mainSplit = new JSplitPane();
        mainSplit.setDividerSize(1);
        mainSplit.setResizeWeight(0.3);
        mainSplit.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        JSplitPane actionsOptionsSplit = new JSplitPane();
        actionsOptionsSplit.setDividerSize(1);
        actionsOptionsSplit.setResizeWeight(0.5);
        actionsOptionsSplit.setOrientation(JSplitPane.HORIZONTAL_SPLIT);


        JPanel directionsPanel = new JPanel();
        directionsPanel.setLayout(new GridLayout(0, 2));
        directionsPanel.add(north);
        directionsPanel.add(south);
        directionsPanel.add(east);
        directionsPanel.add(west);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(0, 2));
        actionsPanel.add(attack);
        actionsPanel.add(runAway);

        JPanel gameOptionsPanel = new JPanel();
        gameOptionsPanel.setLayout(new GridLayout(0, 2));
        gameOptionsPanel.add(newGame);
        gameOptionsPanel.add(backToMainMenu);
        gameOptionsPanel.add(quit);

        actionsOptionsSplit.setTopComponent(actionsPanel);
        actionsOptionsSplit.setBottomComponent(gameOptionsPanel);

        mainSplit.setTopComponent(directionsPanel);
        mainSplit.setBottomComponent(actionsOptionsSplit);
        this.add(mainSplit);
    }
}
