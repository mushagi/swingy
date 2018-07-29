package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import views.gui.Panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelController extends AUIController {

    private final GamePanel gamePanel;

    GamePanelController(ArenaController arenaController , GUIController guiController, GamePanel gamePanel) {
        super(arenaController);
        this.gamePanel = gamePanel;
        addAllListeners();
    }


    private void addAllListeners() {
        gamePanel.addOnNorthClickedListener(onNorthClicked);
        gamePanel.addOnSouthClickedListener(onSouthClicked);
        gamePanel.addOnEastClickedListener(onEastClicked);
        gamePanel.addOnWestClickedListener(onWestClicked);
        gamePanel.addOnFightClickedListener(onFightClicked);
        gamePanel.addOnRunawayClickedListener(onRunawayClicked);
        gamePanel.addOnQuitListener(onQuit);
        gamePanel.addOnBackToMainMenuListener(onBackToMainMenu);
        gamePanel.addOnNewGameListeners(onNewGame);
    }
    
    private final ActionListener onNorthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveNorth();
            updateUserInterface();
        }
    };

    private final ActionListener onSouthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveSouth();
            updateUserInterface();

        }
    };

    private final ActionListener onEastClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveEast();
            updateUserInterface();
        }
    };

    private final ActionListener onWestClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveWest();
            updateUserInterface();
        }
    };

    private final ActionListener onFightClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            attack();
            updateUserInterface();
        }
    };

    private final ActionListener onRunawayClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            runAway();
            updateUserInterface();
        }
    };

    private final ActionListener onQuit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            showQuitDialogue();
            updateUserInterface();
        }

    };


    private final ActionListener onBackToMainMenu = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            showQuitDialogue();
            updateUserInterface();
        }
    };

    private final ActionListener onNewGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            newGameDialogue();
            updateUserInterface();
        }
    };

    private void newGameDialogue() {

    }

    @Override
    public void switchUI() {
        
    }

    @Override
    protected void updateUserInterface() {
        gamePanel.updateUserInterface(arenaController.getArena());
    }


    private void showQuitDialogue() {
    }

    @Override
    public void run() {

    }
}