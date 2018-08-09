package views.gui.Panels;

import lombok.Getter;
import state.GameColors;
import views.gui.ButtonRounded;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

@Getter
    class ButtonsPanel extends JPanel {
    
    public final ButtonRounded north = new ButtonRounded("North");
    final ButtonRounded south = new ButtonRounded("South");
    final ButtonRounded east = new ButtonRounded("East");
    final ButtonRounded west = new ButtonRounded("West");
    final ButtonRounded attack = new ButtonRounded("Attack");
    final ButtonRounded runAway = new ButtonRounded("Run Away");
    final ButtonRounded newGame = new ButtonRounded("New Game");
    final ButtonRounded quit = new ButtonRounded("Quit");
    final ButtonRounded backToMainMenu = new ButtonRounded("Menu");
    final ButtonRounded btnShowHeroStatistics = new ButtonRounded("Show Hero Stats");

    ButtonsPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(GameColors.LIGHTERST__GRAY);
    
        JPanel directionsPanel = getDirectionsPanel();
        JPanel actionsPanel = getActionsPanel();
        JPanel gameOptionsPanel = getGameOptionsPanel();

        add(directionsPanel, BorderLayout.WEST);
        add(actionsPanel, BorderLayout.CENTER);
        add(gameOptionsPanel, BorderLayout.EAST);

    }

    private JPanel getGameOptionsPanel() {
        SpringLayout layout = new SpringLayout();
        JPanel gameOptionsPanel = new JPanel();
        
        gameOptionsPanel.setLayout(layout);
        gameOptionsPanel.setPreferredSize(new Dimension(200, 80));
        gameOptionsPanel.setBackground(GameColors.TRANSPARENT);
        
        gameOptionsPanel.add(newGame);
        gameOptionsPanel.add(backToMainMenu);
        gameOptionsPanel.add(quit);
    
        layout.putConstraint(SpringLayout.EAST, backToMainMenu, -10, SpringLayout.EAST, gameOptionsPanel);
        layout.putConstraint(SpringLayout.NORTH, backToMainMenu, 5, SpringLayout.NORTH, gameOptionsPanel);
        
        layout.putConstraint(SpringLayout.NORTH, newGame, 5, SpringLayout.NORTH, gameOptionsPanel);
        layout.putConstraint(SpringLayout.EAST, newGame, -10, SpringLayout.WEST, backToMainMenu);
    
    
        layout.putConstraint(SpringLayout.NORTH, quit, 5, SpringLayout.SOUTH, backToMainMenu);
        layout.putConstraint(SpringLayout.EAST, quit, -10, SpringLayout.EAST, gameOptionsPanel);
        
        return gameOptionsPanel;
    }

    private JPanel getActionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel actionsPanel = new JPanel();
        actionsPanel.setBackground(GameColors.TRANSPARENT);
    
        actionsPanel.setPreferredSize(new Dimension(150, 70));
        
        actionsPanel.setLayout(layout);
        
        actionsPanel.add(attack);
        actionsPanel.add(runAway);
        actionsPanel.add(btnShowHeroStatistics);
        
        layout.putConstraint(SpringLayout.NORTH, attack, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.NORTH, runAway, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.WEST, runAway, 5, SpringLayout.EAST, attack);
        
        layout.putConstraint(SpringLayout.NORTH, btnShowHeroStatistics, 5, SpringLayout.SOUTH, attack);
        layout.putConstraint(SpringLayout.WEST, btnShowHeroStatistics, 0, SpringLayout.WEST, attack);
    
        return actionsPanel;
    }

    private JPanel getDirectionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel directionsPanel = new JPanel();
        directionsPanel.setBackground(GameColors.TRANSPARENT);

        directionsPanel.setPreferredSize(new Dimension(240, 70));
        directionsPanel.setLayout(layout);

        directionsPanel.add(north);
        directionsPanel.add(south);
        directionsPanel.add(east);
        directionsPanel.add(west);
        
        layout.putConstraint(SpringLayout.NORTH, north, 5, SpringLayout.NORTH, directionsPanel);
        layout.putConstraint(SpringLayout.WEST, west, 5, SpringLayout.WEST, directionsPanel);
        
        layout.putConstraint(SpringLayout.WEST, north, 5, SpringLayout.EAST, west);

        layout.putConstraint(SpringLayout.NORTH, west, 5, SpringLayout.SOUTH, north);

        layout.putConstraint(SpringLayout.NORTH, south, 5, SpringLayout.SOUTH, north);
        layout.putConstraint(SpringLayout.WEST, south, 5, SpringLayout.EAST, west);

        layout.putConstraint(SpringLayout.NORTH, east, 5, SpringLayout.SOUTH, north);
        layout.putConstraint(SpringLayout.WEST, east, 5 , SpringLayout.EAST, north);
        return directionsPanel;
    }

    void addOnBtnQuitListener(ActionListener onBtnQuitClicked) {
        quit.addActionListener(onBtnQuitClicked);
    }

    void addOnBackToMainMenuQuitListener(ActionListener onBtnBackToMainMenuListener) {
        backToMainMenu.addActionListener(onBtnBackToMainMenuListener);
    }

    void addOnNewGameListener(ActionListener onBtnNewGameListener) {
        newGame.addActionListener(onBtnNewGameListener);
    }
    
    void addOnShowHeroStatisticsListener(ActionListener onShowHeroStatistics) {
        btnShowHeroStatistics.addActionListener(onShowHeroStatistics);
    }
    
    
    public void addOnNorthKeyPress(KeyListener onNorthPressed) {
        addKeyListener(onNorthPressed);
    }
    
    public void addOnSouthKeyPress(KeyListener onSouthPressed) {
        addKeyListener(onSouthPressed);
    }
    
    public void addOnWestKeyPress(KeyListener onWestPressed) {
        addKeyListener(onWestPressed);
    }
    
    public void addOnEastKeyPress(KeyListener onEastPressed) {
        addKeyListener(onEastPressed);
    }
}