package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import views.gui.Panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelController extends AUIController {

    private final GUIController guiController;
    GamePanel gamePanel;
    
    public GamePanelController(ArenaController arenaController , GUIController guiController, GamePanel gamePanel) {
        super(arenaController);
        this.gamePanel = gamePanel;
        this.guiController = guiController;
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
    
    ActionListener onNorthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveNorth();
            updateUserInterface();
        }
    };

    ActionListener onSouthClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveSouth();
            updateUserInterface();

        }
    };

    ActionListener onEastClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveEast();
            updateUserInterface();
        }
    };

    ActionListener onWestClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveWest();
            updateUserInterface();
        }
    };

    ActionListener onFightClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            attack();
            updateUserInterface();
        }
    };

    ActionListener onRunawayClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            runAway();
            updateUserInterface();
        }
    };

    ActionListener onQuit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            showQuitDialogue();
            updateUserInterface();
        }

    };


    ActionListener onBackToMainMenu = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            showQuitDialogue();
            updateUserInterface();
        }
    };

    ActionListener onNewGame = new ActionListener() {
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