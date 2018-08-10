package controllers.gui;

import views.gui.Panels.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

class GamePanelController extends APanelController {
    private final GamePanel gamePanel;

    
    GamePanelController(GUIController guiController, GamePanel gamePanel) {
        super(guiController);
        this.gamePanel = gamePanel;
        addAllListeners();
        updateUserInterface();
    }

    private final AbstractAction onNorthClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveNorth();
            updateUserInterface();
        }
    };

    private final AbstractAction onSouthClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveSouth();
            updateUserInterface();
        }
    };

    private final AbstractAction onEastClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveEast();
            updateUserInterface();
        }
    };

    private final AbstractAction onWestClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveWest();
            updateUserInterface();
        }
    };

    private final AbstractAction onFightClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.attack();
            updateUserInterface();
        }
    };

    private final AbstractAction onRunawayClicked = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.runAway();
            updateUserInterface();
        }
    };

    private final AbstractAction onQuit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.quitGame();
        }

    };


    private final AbstractAction onBackToMainMenu = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    };
    
  
    private final AbstractAction onNewGame = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            newGameDialogue();

        }
    };
	
	private final AbstractAction onShowHeroStatistics = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					gamePanel.showHeroStats(guiController.getArena().getHero());
				}
			});
		}
	};
	
    private void newGameDialogue() {
    }

    private void updateUserInterface() {
        if (!guiController.getArena().isGameInProgress()) {
            guiController.showGameEndedPanel();
        }
        else
            gamePanel.updateUserInterface(guiController.getArena());

    }

    @Override
    void addAllListeners() {
        gamePanel.addOnNorthClickedListener(onNorthClicked);
        gamePanel.addOnSouthClickedListener(onSouthClicked);
        gamePanel.addOnEastClickedListener(onEastClicked);
        gamePanel.addOnWestClickedListener(onWestClicked);
        gamePanel.addOnFightClickedListener(onFightClicked);
        gamePanel.addOnRunawayClickedListener(onRunawayClicked);
        gamePanel.addOnQuitListener(onQuit);
        gamePanel.addOnBackToMainMenuListener(onBackToMainMenu);
        gamePanel.addOnNewGameListeners(onNewGame);
        gamePanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
    }
    
    @Override
    void updatePanel() {
    }
}