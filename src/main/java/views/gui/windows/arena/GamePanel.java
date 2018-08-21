package views.gui.windows.arena;

import models.players.Hero;
import models.world.Arena;
import state.SwingyConstants;
import views.gui.custom.AbstractMapView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final AbstractMapView abstractMapView = new MapPanel();
    private final ControlPanel controlPanel = new ControlPanel();
    private final SidePanel sidePanel = new SidePanel();
    
    private final String KEY_BINDING_MOVE_UP = "move up";
	private final String KEY_SWITCHUI = "switch ui";
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
        setBackground(SwingyConstants.Colors.DARKEST);
        abstractMapView.generateNewMap(mapSize);
        
        sidePanel.setPreferredSize(new Dimension(350, 450));
		controlPanel.setPreferredSize(new Dimension(950, 100));
		
		add(abstractMapView, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    public void updateUserInterface(Arena arena) {
    	abstractMapView.updateMap(arena);
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
        controlPanel.addOnNewGameListener(onNewGame);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("N"), KEY_BINDING_NEW_GAME);
	    this.getActionMap().put(KEY_BINDING_NEW_GAME,  onNewGame);
    }

    public void addOnBackToMainMenuListener(AbstractAction onBackToMainMenu) {
        controlPanel.addOnBackToMainMenuQuitListener(onBackToMainMenu);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("B"), KEY_BINDING_MAIN_MENU);
	    this.getActionMap().put(KEY_BINDING_MAIN_MENU,  onBackToMainMenu);
    }

    public void addOnQuitListener(AbstractAction onQuit) {
        controlPanel.addOnBtnQuitListener(onQuit);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("Q"), KEY_BINDING_QUIT);
	    this.getActionMap().put(KEY_BINDING_QUIT,  onQuit);
    }

    public void addOnRunawayClickedListener(AbstractAction onRunawayClicked) {
        controlPanel.getRunAway().addActionListener(onRunawayClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("R"), KEY_BINDING_RUN);
	    this.getActionMap().put(KEY_BINDING_RUN,  onRunawayClicked);
    }

    public void addOnFightClickedListener(AbstractAction onFightClicked) {
        controlPanel.getAttack().addActionListener(onFightClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("F"), KEY_BINDING_FIGHT);
	    this.getActionMap().put(KEY_BINDING_FIGHT,  onFightClicked);
    }

    public void addOnWestClickedListener(AbstractAction onWestClicked) {
        controlPanel.getWest().addActionListener(onWestClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("A"), KEY_BINDING_MOVE_LEFT);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("LEFT ARROW"), KEY_BINDING_MOVE_LEFT);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_LEFT,  onWestClicked);
    }

    public void addOnEastClickedListener(AbstractAction onEastClicked) {
        controlPanel.getEast().addActionListener(onEastClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("D"), KEY_BINDING_MOVE_RIGHT);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("RIGHT ARROW"), KEY_BINDING_MOVE_RIGHT);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_RIGHT,  onEastClicked);
    }

    public void addOnSouthClickedListener(AbstractAction onSouthClicked) {
        controlPanel.getSouth().addActionListener(onSouthClicked);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("S"), KEY_BINDING_MOVE_DOWN);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("DOWN ARROW"), KEY_BINDING_MOVE_DOWN);
	
	    this.getActionMap().put(KEY_BINDING_MOVE_DOWN,  onSouthClicked);
    }

    public void addOnNorthClickedListener(AbstractAction onNorthClicked) {
        controlPanel.getNorth().addActionListener(onNorthClicked);
        this.getInputMap(WIF).put(KeyStroke.getKeyStroke("W"), KEY_BINDING_MOVE_UP);
	    this.getInputMap(WIF).put(KeyStroke.getKeyStroke("UP ARROW"), KEY_BINDING_MOVE_UP);
	    this.getActionMap().put(KEY_BINDING_MOVE_UP,  onNorthClicked);
    }
	
	
	public void onSwitchUI(AbstractAction onSwitchUI) {
		controlPanel.addOnSwitchUI(onSwitchUI);
		this.getInputMap(WIF).put(KeyStroke.getKeyStroke("X"), KEY_SWITCHUI);
		this.getActionMap().put(KEY_SWITCHUI,  onSwitchUI);
	}
	
	
	public void addOnBtnQuitListener(AbstractAction onBtnQuitClicked) {
        controlPanel.addOnBtnQuitListener(onBtnQuitClicked);
    }

    public void addOnBackToMainMenuQuitListener(AbstractAction onBtnBackToMainMenuListener) {
        controlPanel.addOnNewGameListener(onBtnBackToMainMenuListener);
    }

    public void addOnNewGameListener(AbstractAction onBtnNewGameListener) {
        controlPanel.addOnNewGameListener(onBtnNewGameListener);
    }
    
	
	public void addOnShowHeroStatisticsListener(AbstractAction onShowHeroStatistics) {
		controlPanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
		this.getInputMap(WIF).put(KeyStroke.getKeyStroke("H"), KEY_BINDING_SHOW_HERO_STATS);
		this.getActionMap().put(KEY_BINDING_SHOW_HERO_STATS,  onShowHeroStatistics);
	}
}
