package controllers.gui;

import views.gui.Panels.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GamePanelController extends APanelController {
    private final GamePanel gamePanel;

    
    GamePanelController(GUIController guiController, GamePanel gamePanel) {
        super(guiController);
        this.gamePanel = gamePanel;
        addAllListeners();
        updateUserInterface();
    }

    private final ActionListener onNorthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            guiController.moveNorth();
            updateUserInterface();
        }
    };

    private final ActionListener onSouthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveSouth();
            updateUserInterface();
        }
    };

    private final ActionListener onEastClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveEast();
            updateUserInterface();
        }
    };

    private final ActionListener onWestClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.moveWest();
            updateUserInterface();
        }
    };

    private final ActionListener onFightClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.attack();
            updateUserInterface();
        }
    };

    private final ActionListener onRunawayClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.runAway();
            updateUserInterface();
        }
    };

    private final ActionListener onQuit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.quitGame();
        }

    };


    private final ActionListener onBackToMainMenu = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    };
    
    private KeyListener onEastPressed = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_D)
            {
                guiController.moveEast();
                updateUserInterface();
            }

        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
    };
    
    private KeyListener onNorthPressed = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W)
                guiController.moveNorth();
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
    };
    private KeyListener onWestPressed = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A)
                guiController.moveWest();
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
    };
    private KeyListener onSouthPressed = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S)
                guiController.moveSouth();
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
    };
    
    private final ActionListener onNewGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            newGameDialogue();

        }
    };
	
	private final ActionListener onShowHeroStatistics = new ActionListener() {
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
        gamePanel.addOnEastKeyPress(onEastPressed);
        gamePanel.addOnShowHeroStatisticsListener(onShowHeroStatistics);
 //       gamePanel.addOnWestKeyPress(onWestPressed);
//        gamePanel.addOnSouthKeyPress(onSouthPressed);
     //   gamePanel.addOnNorthKeyPress(onNorthPressed);
    }

    @Override
    void updatePanel() {
    }


}