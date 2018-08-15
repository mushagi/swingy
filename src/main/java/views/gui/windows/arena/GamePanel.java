package views.gui.windows.arena;

import models.players.Hero;
import models.world.Arena;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final MapPanel mapPanel = new MapPanel();
    private final ButtonsPanel buttonsPanel = new ButtonsPanel();
    private final SidePanel sidePanel = new SidePanel();
    
    private final String KEY_BINDING_MOVE_UP = "move up";
	private final String KEY_BINDING_MOVE_DOWN = "move down";
	private final String KEY_BINDING_MOVE_RIGHT = "move right";
	private final String KEY_BINDING_MOVE_LEFT = "move left";
	private final String KEY_BINDING_FIGHT = "fight";
	private final String KEY_BINDING_RUN = "run";
	private final String KEY_BINDING_SHOW_HERO_STATS = "show hero stats";
	private final String KEY_BINDING_QUIT = "quit";
	private final String KEY_BINDING_MAIN_MENU = "menu";
	private final String KEY_BINDING_NEW_GAME = "menu";
	
	
	private final int WIF = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	public GamePanel(int mapSize) throws HeadlessException {
        this.setLayout(new BorderLayout());
        
        mapPanel.generateNewMap(mapSize);
        
        mapPanel.setPreferredSize(new Dimension(600, 450));
        buttonsPanel.setPreferredSize(new Dimension(950, 70));
        sidePanel.setPreferredSize(new Dimension(350, 450));
        
        add(mapPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
    
    public void updateUserInterface(Arena arena) {
    	mapPanel.updateMap(arena);
    	if (arena.getGameResults().isWasBattle())
	        sidePanel.showBattleReport(arena.getGameResults().getBattleReport());
        else
            sidePanel.showMessage(arena.getGameResults().getResult());
        sidePanel.updateBottomStatistics(arena.getHero());
        repaint();
    }

    public void showHeroStats(Hero hero) {
        sidePanel.toggleHeroStats(hero);
    }
    
    public void addOnNewGameListeners(AbstractAction onNewGame) {
        buttonsPanel.addOnNewGameListener(onNewGame);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("N"), KEY_BINDING_NEW_GAME);
	    this.getActionMap().put(KEY_BINDING_NEW_GAME,  onNewGame);
    }

    public void addOnBackToMainMenuListener(AbstractAction onBackToMainMenu) {
        buttonsPanel.addOnBackToMainMenuQuitListener(onBackToMainMenu);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("B"), KEY_BINDING_MAIN_MENU);
	    this.getActionMap().put(KEY_BINDING_MAIN_MENU,  onBackToMainMenu);
    }

    public void addOnQuitListener(AbstractAction onQuit) {
        buttonsPanel.addOnBtnQuitListener(onQuit);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("Q"), KEY_BINDING_QUIT);
	    this.getActionMap().put(KEY_BINDING_QUIT,  onQuit);
    }

    public void addOnRunawayClickedListener(AbstractAction onRunawayClicked) {
        buttonsPanel.getRunAway().addActionListener(onRunawayClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("R"), KEY_BINDING_RUN);
	    this.getActionMap().put(KEY_BINDING_FIGHT,  onRunawayClicked);
    }

    public void addOnFightClickedListener(AbstractAction onFightClicked) {
        buttonsPanel.getAttack().addActionListener(onFightClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("F"), KEY_BINDING_FIGHT);
	    this.getActionMap().put(KEY_BINDING_FIGHT,  onFightClicked);
    }

    public void addOnWestClickedListener(AbstractAction onWestClicked) {
        buttonsPanel.getWest().addActionListener(onWestClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("A"), KEY_BINDING_MOVE_LEFT);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("LEFT ARROW"), KEY_BINDING_MOVE_LEFT);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_LEFT,  onWestClicked);
    }

    public void addOnEastClickedListener(AbstractAction onEastClicked) {
        buttonsPanel.getEast().addActionListener(onEastClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("D"), KEY_BINDING_MOVE_RIGHT);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("RIGHT ARROW"), KEY_BINDING_MOVE_RIGHT);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_RIGHT,  onEastClicked);
    }

    public void addOnSouthClickedListener(AbstractAction onSouthClicked) {
        buttonsPanel.getSouth().addActionListener(onSouthClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("S"), KEY_BINDING_MOVE_DOWN);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("DOWN ARROW"), KEY_BINDING_MOVE_DOWN);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_DOWN,  onSouthClicked);
    }

    public void addOnNorthClickedListener(AbstractAction onNorthClicked) {
        buttonsPanel.getNorth().addActionListener(onNorthClicked);
        this.getInputMap(WIF).put(KeyStroke.getKeyStroke("W"), KEY_BINDING_MOVE_UP);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("UP ARROW"), KEY_BINDING_MOVE_UP);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_UP,  onNorthClicked);
    }

    public void addOnBtnQuitListener(AbstractAction onBtnQuitClicked) {
        buttonsPanel.addOnBtnQuitListener(onBtnQuitClicked);
    }

    public void addOnBackToMainMenuQuitListener(AbstractAction onBtnBackToMainMenuListener) {
        buttonsPanel.addOnNewGameListener(onBtnBackToMainMenuListener);
    }

    public void addOnNewGameListener(AbstractAction onBtnNewGameListener) {
        buttonsPanel.addOnNewGameListener(onBtnNewGameListener);
    }
    
	
	public void addOnShowHeroStatisticsListener(AbstractAction onShowHeroStatistics) {
		buttonsPanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
		this.getInputMap(WIF).put(KeyStroke.getKeyStroke("H"), KEY_BINDING_SHOW_HERO_STATS);
		this.getActionMap().put(KEY_BINDING_SHOW_HERO_STATS,  onShowHeroStatistics);
	}
}
