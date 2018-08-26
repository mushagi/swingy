package za.co.wethinkcode.mmayibo.swingy.controllers.gui;

import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.NewLoadPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewLoadPlayerPanelController extends APanelController {
    private final NewLoadPlayerPanel loadPlayerPanel;

    NewLoadPlayerPanelController(GUIController guiController, NewLoadPlayerPanel loadPlayerPanel) {
        super(guiController);
        this.loadPlayerPanel = loadPlayerPanel;
        addAllListeners();
    }

    private final ActionListener onNewGameClickedActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.showChooseHeroPanel();
        }
    };

    private final ActionListener onLoadHeroClickedActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.showChooseHeroPanelFromDatabase();
    
        }
    };
    private final ActionListener onQuitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.quitGame();

        }
    };


    @Override
    void addAllListeners() {
        loadPlayerPanel.addOnBtnNewListener(onNewGameClickedActionListener);
        loadPlayerPanel.addOnBtnLoadHeroListener(onLoadHeroClickedActionListener);

        loadPlayerPanel.addOnBtnQuitListener(onQuitListener);
    }

    @Override
    void updatePanel() {

    }
}
