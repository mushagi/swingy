package za.co.wethinkcode.mmayibo.swingy.controllers.gui;

import za.co.wethinkcode.mmayibo.swingy.controllers.AbstractUIController;
import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.factory.ControllerFactory;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.state.GameState;
import za.co.wethinkcode.mmayibo.swingy.views.gui.GUI;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero.ChooseHeroPanel;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.GameEndedPanel;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena.GamePanel;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.NewLoadPlayerPanel;

import javax.swing.*;
import java.util.Collection;

public class GUIController extends AbstractUIController {
    private GUI guiInterface;
    private JPanel previousPanel;
    private JPanel currentPanel;
    private APanelController currentPanelController;

    public GUIController(ArenaController arenaController) {
        super(arenaController);
    }

    @Override
    public void switchUI() {
        guiInterface.close();
	    AbstractUIController controller = ControllerFactory.newCLIController(arenaController);
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
	            GameState.getInstance().setShowSplashScreen(false);
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
