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

    public GUIController(ArenaController arenaController) {
        super(arenaController);
    }

    @Override
    public void switchUI() {
        AUIController controller = ControllerFactory.newCLIController(arenaController);
        controller.run();
    }

    @Override
    public void updateUserInterface() {
        guiInterface.updateUserInterface(arenaController.getArena());
    }

    @Override
    public void run() {
        guiInterface = new GUI();

        if (!arenaController.isPLayerNameLoaded())
            showCreateNewLoadPlayerWindow();
        else
            showGamePanel();
    }

    void showGamePanel() {
        GamePanel gamePanel = new GamePanel(arenaController.getArena().getMap().getSize());

        GamePanelController controller = new
                GamePanelController(this, gamePanel);
        switchMainWindowPanel(gamePanel);
    }

    public void showCreateNewLoadPlayerWindow() {
        NewLoadPlayerPanel newLoadPlayerPanel = new NewLoadPlayerPanel();

        NewLoadPlayerPanelController controller = new
                NewLoadPlayerPanelController( this, newLoadPlayerPanel);
        switchMainWindowPanel(newLoadPlayerPanel);
    }

    void showChooseHeroPanel() {
        Collection<Hero> heroes = GameState.getInstance().getAvailableHeroes();
        ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
        
        ChooseHeroPanelController controller =
                new ChooseHeroPanelController(this, chooseHeroPanel);
        
        switchMainWindowPanel(chooseHeroPanel);
    }

    private void switchMainWindowPanel(JPanel panel) {
        previousPanel = currentPanel;
        currentPanel = panel;
        guiInterface.addMainWindowContentPane(panel);
    }

    void switchToPreviousPanel() {
        switchMainWindowPanel(previousPanel);
    }
    
    public void showChooseHeroPanelFromDatabase() {
        Collection<Hero> heroes = arenaController.getAllHeroes();
        ChooseHeroPanel chooseHeroPanel = new ChooseHeroPanel(heroes);
    
    
        ChooseHeroPanelController controller =
                new ChooseHeroPanelController(this, chooseHeroPanel);
    
        switchMainWindowPanel(chooseHeroPanel);
    }
    
    public void showGameEndedPanel() {
        GameEndedPanel gameEndedPanel = new GameEndedPanel(getArena());
    
    
        GameEndedPanelController controller =
                new GameEndedPanelController(this, gameEndedPanel);
    
        switchMainWindowPanel(gameEndedPanel);
    }
	

}
