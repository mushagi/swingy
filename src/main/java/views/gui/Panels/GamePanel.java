package views.gui.Panels;

import controllers.models.BattleReport;
import models.players.Hero;
import models.world.Arena;
import state.GameColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private final MapPanel mapPanel = new MapPanel();
    private final ActionsPanel actionsPanel = new ActionsPanel();
    private  JScrollPane messagesPanel;
    private final JPanel innerMessagePanel = new JPanel();
	JLabel label = new JLabel();
	
	JPanel sidePanel = new JPanel();

    public GamePanel(int mapSize) throws HeadlessException {
        init(mapSize);
    }

    private void init(int mapSize) {
        this.setLayout(new BorderLayout());
        
        mapPanel.generateNewMap(mapSize);
        mapPanel.setPreferredSize(new Dimension(600, 450));
        actionsPanel.setPreferredSize(new Dimension(950, 70));
        sidePanel.setPreferredSize(new Dimension(350, 490));
        sidePanel.setBackground(GameColors.DARKEST_GRAY);
        initMessagesPanel();
        
        this.add(mapPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);
        this.add(actionsPanel, BorderLayout.SOUTH);


    }
    
    private void initMessagesPanel() {
	    SpringLayout layout = new SpringLayout();
	    
	    innerMessagePanel.setLayout(layout);
	    innerMessagePanel.setBackground(GameColors.DARKEST_GRAY);
	    label.setForeground(GameColors.DEFAULT_FONT);
	    innerMessagePanel.add(label);
	    
	    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, innerMessagePanel);
	    layout.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, innerMessagePanel);
	
	    messagesPanel = new JScrollPane(innerMessagePanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        messagesPanel.setPreferredSize(sidePanel.getPreferredSize());
	    messagesPanel.setBackground(GameColors.TRANSPARENT);
	    messagesPanel.setBorder(BorderFactory.createEmptyBorder());
	    sidePanel.add(messagesPanel);
	
    }
    
    public void updateUserInterface(Arena arena) {
        mapPanel.updateMap(arena);
	
	    if (arena.getGameResults().isWasBattle())
        {
	        BattleReport battleReport = arena.getGameResults().getBattleReport();
	        BattleReportTextArea battleReportTextArea = new BattleReportTextArea(battleReport);
	
	        messagesPanel = new JScrollPane(battleReportTextArea,
			        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        
	        sidePanel.remove(0);
	        messagesPanel.setPreferredSize(sidePanel.getPreferredSize());
	        messagesPanel.setBackground(GameColors.TRANSPARENT);
	        messagesPanel.setBorder(BorderFactory.createEmptyBorder());
	        
	        sidePanel.add(messagesPanel);
	
        }
        else{
		    StringBuilder stringBuilder  = new StringBuilder();
		
		    if (sidePanel.getComponent(0) != null)
	    		sidePanel.remove(0);
		    initMessagesPanel();
		    for (String message: arena.getGameResults().getResult())
			    stringBuilder.append(message + "\n");
		    label.setText(stringBuilder.toString());

	    }
	    sidePanel.repaint();
	    sidePanel.revalidate();

    }
    
    public void showHeroStats(Hero hero) {
    	if ( sidePanel.getComponent(0) instanceof HeroStatisticsPanel) {
		    sidePanel.remove(0);
		    initMessagesPanel();
		    sidePanel.add(messagesPanel);
		    sidePanel.revalidate();
		    messagesPanel.revalidate();
	    }
	    
	    else
	    {
		    HeroStatisticsPanel heroStatisticsPanel = new HeroStatisticsPanel();
		    heroStatisticsPanel.updateWithHero(hero);
		    heroStatisticsPanel.setSize(sidePanel.getSize());
		    sidePanel.remove(0);
		    sidePanel.add(heroStatisticsPanel);
		    sidePanel.revalidate();
		    heroStatisticsPanel.revalidate();
		
	    }
 
    }
    
    public void showMessagesPanel() {
        sidePanel.removeAll();
        sidePanel.add(messagesPanel);
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
	
	public void addOnNorthKeyPress(KeyListener onNorthPressed) {
		actionsPanel.addOnNorthKeyPress(onNorthPressed);
	}
	public void addOnSouthKeyPress(KeyListener onSouthPressed) {
		actionsPanel.addOnSouthKeyPress(onSouthPressed);
	}
	public void addOnWestKeyPress(KeyListener onWestPressed) {
		actionsPanel.addOnWestKeyPress(onWestPressed);
	}
	public void addOnEastKeyPress(KeyListener onEastPressed) {
		actionsPanel.addOnEastKeyPress(onEastPressed);
	}
	public void addOnShowHeroStatisticsListener(ActionListener onShowHeroStatistics) {
		actionsPanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
	}
	
}
