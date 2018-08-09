package views.gui.Panels;

import models.players.Hero;
import models.world.Arena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    private final MapPanel mapPanel = new MapPanel();
    private final ButtonsPanel buttonsPanel = new ButtonsPanel();
    private final SidePanel sidePanel = new SidePanel();

    public GamePanel(int mapSize) throws HeadlessException {
        this.setLayout(new BorderLayout());

        mapPanel.generateNewMap(mapSize);

        mapPanel.setPreferredSize(new Dimension(600, 450));
        buttonsPanel.setPreferredSize(new Dimension(950, 70));
        sidePanel.setPreferredSize(new Dimension(350, 490));

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
    }

    public void showHeroStats(Hero hero) {
        sidePanel.toggleHeroStats(hero);
    }

    public void addOnNewGameListeners(ActionListener onNewGame) {
        buttonsPanel.addOnNewGameListener(onNewGame);
    }

    public void addOnBackToMainMenuListener(ActionListener onBackToMainMenu) {
        buttonsPanel.addOnBackToMainMenuQuitListener(onBackToMainMenu);
    }

    public void addOnQuitListener(ActionListener onQuit) {
        buttonsPanel.addOnBtnQuitListener(onQuit);
    }

    public void addOnRunawayClickedListener(ActionListener onRunawayClicked) {
        buttonsPanel.getRunAway().addActionListener(onRunawayClicked);
    }

    public void addOnFightClickedListener(ActionListener onFightClicked) {
        buttonsPanel.getAttack().addActionListener(onFightClicked);
    }

    public void addOnWestClickedListener(ActionListener onWestClicked) {
        buttonsPanel.getWest().addActionListener(onWestClicked);
    }

    public void addOnEastClickedListener(ActionListener onEastClicked) {
        buttonsPanel.getEast().addActionListener(onEastClicked);
    }

    public void addOnSouthClickedListener(ActionListener onSouthClicked) {
        buttonsPanel.getSouth().addActionListener(onSouthClicked);
    }

    public void addOnNorthClickedListener(ActionListener onNorthClicked) {
        buttonsPanel.getNorth().addActionListener(onNorthClicked);
    }

    public void addOnBtnQuitListener(ActionListener onBtnQuitClicked) {
        buttonsPanel.addOnBtnQuitListener(onBtnQuitClicked);
    }

    public void addOnBackToMainMenuQuitListener(ActionListener onBtnBackToMainMenuListener) {
        buttonsPanel.addOnNewGameListener(onBtnBackToMainMenuListener);
    }

    public void addOnNewGameListener(ActionListener onBtnNewGameListener) {
        buttonsPanel.addOnNewGameListener(onBtnNewGameListener);
    }
	
	public void addOnNorthKeyPress(KeyListener onNorthPressed) {
		buttonsPanel.addOnNorthKeyPress(onNorthPressed);
	}
	public void addOnSouthKeyPress(KeyListener onSouthPressed) {
		buttonsPanel.addOnSouthKeyPress(onSouthPressed);
	}
	public void addOnWestKeyPress(KeyListener onWestPressed) {
		buttonsPanel.addOnWestKeyPress(onWestPressed);
	}
	public void addOnEastKeyPress(KeyListener onEastPressed) {
		buttonsPanel.addOnEastKeyPress(onEastPressed);
	}
	public void addOnShowHeroStatisticsListener(ActionListener onShowHeroStatistics) {
		buttonsPanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
	}
	
}
