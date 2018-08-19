package controllers.gui;

import controllers.AUIController;
import controllers.models.ArenaController;
import factory.ControllerFactory;
import models.players.Hero;
import state.GameState;
import views.gui.GUI;
import views.gui.windows.choosehero.ChooseHeroPanel;
import views.gui.windows.GameEndedPanel;
import views.gui.windows.arena.GamePanel;
import views.gui.windows.NewLoadPlayerPanel;

import javax.swing.*;
import java.util.Collection;

public class GUIController extends AUIController {
    private GUI guiInterface;
    private JPanel previousPanel;
    private JPanel currentPanel;
    private APanelController currentPanelController;

    public GUIController(ArenaController arenaController) {
        super(arenaController);
    }

    @Override
    public void switchUI() {
        AUIController controller = ControllerFactory.newCLIController(arenaController);
        controller.run();
    }
	
	@Override
	public void promptGameEnded() {
		GameEndedPanel gameEndedPanel = new GameEndedPanel(arenaController.getArena());
		currentPanelController = new GameEndedPanelController(this, gameEndedPanel);
		switchMainWindowPanel(gameEndedPanel);
	}
	
	@Override
    public void updateUserInterface() {
        currentPanelController.updatePanel();
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                guiInterface = new GUI();
                if (!arenaController.isPLayerNameLoaded())
                    showCreateNewLoadPlayerWindow();
                else
                    showGamePanel();
            }
        });
    }

    void showGamePanel() {
        GamePanel gamePanel = new GamePanel(arenaController.getArena().getMap().getSize());
        currentPanelController = new GamePanelController(this, gamePanel);
        switchMainWindowPanel(gamePanel);
    }

    void showCreateNewLoadPlayerWindow() {
        NewLoadPlayerPanel newLoadPlayerPanel = new NewLoadPlayerPanel();
    
        currentPanelController = new NewLoadPlayerPanelController( this, newLoadPlayerPanel);
        switchMainWindowPanel(newLoadPlayerPanel);
    }

    void showChooseHeroPanel() {
        Collection<Hero> heroes = GameState.getInstance().getAvailableHeroes();
        ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
        currentPanelController = new ChooseHeroPanelController(this, chooseHeroPanel);
        
        switchMainWindowPanel(chooseHeroPanel);
    }

    private void switchMainWindowPanel(JPanel panel) {
        previousPanel = currentPanel;
        currentPanel = panel;
        currentPanelController.updatePanel();
        guiInterface.addMainWindowContentPane(panel);
    }

    void switchToPreviousPanel() {
        switchMainWindowPanel(previousPanel);
    }
    
    void showChooseHeroPanelFromDatabase() {
        Collection<Hero> heroes = arenaController.getAllHeroes();
        ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
        currentPanelController = new ChooseHeroPanelController(this, chooseHeroPanel);
        switchMainWindowPanel(chooseHeroPanel);
    }
}
