package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import models.players.Hero;
import state.GameState;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.NewLoadPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class NewLoadPlayerPanelController extends AUIController {
    private final GUIController guiController;
    private final NewLoadPlayerPanel loadPlayerPanel;

    NewLoadPlayerPanelController(ArenaController arenaController , GUIController guiController, NewLoadPlayerPanel loadPlayerPanel) {
        super(arenaController);
        this.loadPlayerPanel = loadPlayerPanel;
        this.guiController = guiController;
        addAllListeners();
    }

    @Override
    public void switchUI() {

    }

    @Override
    public void updateUserInterface() {

    }

    private void addAllListeners() {
        loadPlayerPanel.addOnBtnNewListener(onNewGameClickedActionListener);
        loadPlayerPanel.addOnBtnLoadHeroListener(onLoadHeroClickedActionListener);
    }

    @Override
    public void run() {
    }

    private final ActionListener onNewGameClickedActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collection<Hero> heroes = GameState.getInstance().getAvailableHeroes();
            ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
            ChooseHeroPanelController controller =
                    new ChooseHeroPanelController(arenaController, guiController, chooseHeroPanel, loadPlayerPanel);
            controller.updateUserInterface();
            guiController.switchMainWindowPanel(chooseHeroPanel);
        }
    };

    private final ActionListener onLoadHeroClickedActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
}
