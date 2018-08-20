package views.gui.windows.arena;

import lombok.Getter;
import state.SwingyConstants;
import views.gui.custom.GameButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Getter
    class ControlPanel extends JPanel {
    
    public final GameButton north = new GameButton("North");
    final GameButton south = new GameButton("South");
    final GameButton east = new GameButton("East");
    final GameButton west = new GameButton("West");
    final GameButton attack = new GameButton("Attack");
    final GameButton runAway = new GameButton("Run Away");
    final GameButton newGame = new GameButton("New Game");
    final GameButton quit = new GameButton("Quit");
    final GameButton backToMainMenu = new GameButton("Menu");
    final GameButton btnShowHeroStatistics = new GameButton("Show Hero Stats");
	final GameButton btnPickUp = new GameButton("Pick Up");
	final GameButton btnSwitchUI = new GameButton("Switch To CLI");
	
	private final Dimension dimension = new Dimension(100,35);

    ControlPanel() {
        SpringLayout layout = new SpringLayout();
    
        this.setLayout(layout);
        this.setBackground(SwingyConstants.Colors.LIGHTEST);
        
        JPanel directionsPanel = getDirectionsPanel();
        JPanel actionsPanel = getActionsPanel();
        JPanel gameOptionsPanel = getGameOptionsPanel();
        directionsPanel.setPreferredSize(new Dimension(300, 100));
        actionsPanel.setPreferredSize(new Dimension(300, 100));
        gameOptionsPanel.setPreferredSize(new Dimension(300, 100));
    
        setButtonsSizes();
        
        add(directionsPanel);
        add(actionsPanel);
        add(gameOptionsPanel);
    
        layout.putConstraint(SpringLayout.WEST, directionsPanel, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, directionsPanel, 0, SpringLayout.NORTH, this);
    
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, actionsPanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
	    layout.putConstraint(SpringLayout.VERTICAL_CENTER, actionsPanel, 0, SpringLayout.VERTICAL_CENTER, this);
	
	    layout.putConstraint(SpringLayout.NORTH, actionsPanel, 0, SpringLayout.NORTH, this);
    
        layout.putConstraint(SpringLayout.EAST, gameOptionsPanel, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, gameOptionsPanel, 0, SpringLayout.NORTH, this);
    }
    
    private void setButtonsSizes() {
        north.setPreferredSize(dimension);
        south.setPreferredSize(dimension);
        east.setPreferredSize(dimension);
        west.setPreferredSize(dimension);
    }
    
    
    private JPanel getGameOptionsPanel() {
        SpringLayout layout = new SpringLayout();
        JPanel gameOptionsPanel = new JPanel();
        
        gameOptionsPanel.setLayout(layout);
        gameOptionsPanel.setOpaque(false);
        
        gameOptionsPanel.add(newGame);
        gameOptionsPanel.add(backToMainMenu);
        gameOptionsPanel.add(quit);
	    gameOptionsPanel.add(btnSwitchUI);
	
	    layout.putConstraint(SpringLayout.EAST, backToMainMenu, -10, SpringLayout.EAST, gameOptionsPanel);
        layout.putConstraint(SpringLayout.NORTH, backToMainMenu, 5, SpringLayout.NORTH, gameOptionsPanel);
        
        layout.putConstraint(SpringLayout.NORTH, newGame, 5, SpringLayout.NORTH, gameOptionsPanel);
        layout.putConstraint(SpringLayout.EAST, newGame, -10, SpringLayout.WEST, backToMainMenu);
    
    
        layout.putConstraint(SpringLayout.NORTH, quit, 5, SpringLayout.SOUTH, backToMainMenu);
        layout.putConstraint(SpringLayout.EAST, quit, -10, SpringLayout.EAST, gameOptionsPanel);
	   
	    layout.putConstraint(SpringLayout.NORTH, btnSwitchUI, 5, SpringLayout.SOUTH, newGame);
	    layout.putConstraint(SpringLayout.EAST, btnSwitchUI, -10, SpringLayout.WEST, quit);
	
	    newGame.setPreferredSize(dimension);
	    quit.setPreferredSize(dimension);
	    backToMainMenu.setPreferredSize(dimension);
	    btnSwitchUI.setPreferredSize(dimension);
	    btnSwitchUI.setHorizontalAlignment(SwingConstants.RIGHT);
	
	    newGame.setHorizontalAlignment(SwingConstants.RIGHT);
	    quit.setHorizontalAlignment(SwingConstants.RIGHT);
	    backToMainMenu.setHorizontalAlignment(SwingConstants.RIGHT);
	
	    return gameOptionsPanel;
    }

    private JPanel getActionsPanel() {
        SpringLayout layout = new SpringLayout();

        JPanel actionsPanel = new JPanel();
        actionsPanel.setOpaque(false);
        actionsPanel.setLayout(layout);
        
        actionsPanel.add(attack);
        actionsPanel.add(runAway);
	    actionsPanel.add(btnPickUp);
	    actionsPanel.add(btnShowHeroStatistics);
        
        
        layout.putConstraint(SpringLayout.NORTH, attack, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.NORTH, runAway, 5, SpringLayout.NORTH, actionsPanel);
        layout.putConstraint(SpringLayout.WEST, runAway, 5, SpringLayout.EAST, attack);
        
        layout.putConstraint(SpringLayout.NORTH, btnPickUp, 5, SpringLayout.SOUTH, attack);
        layout.putConstraint(SpringLayout.WEST, btnPickUp, 0, SpringLayout.WEST, attack);
	
	    layout.putConstraint(SpringLayout.NORTH, btnShowHeroStatistics, 5, SpringLayout.SOUTH, attack);
	    layout.putConstraint(SpringLayout.WEST, btnShowHeroStatistics, 5, SpringLayout.EAST, btnPickUp);
	    
	    attack.setPreferredSize(dimension);
	    runAway.setPreferredSize(dimension);
	    btnPickUp.setPreferredSize(dimension);
	    btnShowHeroStatistics.setPreferredSize(dimension);
	
	    attack.setHorizontalAlignment(SwingConstants.LEFT);
	    runAway.setHorizontalAlignment(SwingConstants.LEFT);
	    btnPickUp.setHorizontalAlignment(SwingConstants.LEFT);
	    btnShowHeroStatistics.setPreferredSize(dimension);
	
	    return actionsPanel;
    }

    private JPanel getDirectionsPanel() {
        SpringLayout layout = new SpringLayout();
			    

        JPanel directionsPanel = new JPanel();
        directionsPanel.setOpaque(false);
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
	
	
	void addOnSwitchUI(ActionListener onSwitchUI) {
		btnSwitchUI.addActionListener(onSwitchUI);
	}
}