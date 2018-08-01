package controllers.gui;

import views.gui.Panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelController extends APanelController {
    GamePanel gamePanel;

    GamePanelController(GUIController guiController, GamePanel gamePanel) {
        super(guiController);
        this.gamePanel = gamePanel;
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

    private final ActionListener onNewGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            newGameDialogue();

        }
    };

    private void newGameDialogue() {

    }

    protected void updateUserInterface() {
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
    }

    @Override
    void updatePanel() {

    }


}