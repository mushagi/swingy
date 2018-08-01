package controllers.gui;

import controllers.AUIController;
import controllers.models.ArenaController;
import models.players.Hero;
import state.GameState;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.NewLoadPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class NewLoadPlayerPanelController extends APanelController {
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
        }
    };

    @Override
    void addAllListeners() {
        loadPlayerPanel.addOnBtnNewListener(onNewGameClickedActionListener);
        loadPlayerPanel.addOnBtnLoadHeroListener(onLoadHeroClickedActionListener);
    }
}
