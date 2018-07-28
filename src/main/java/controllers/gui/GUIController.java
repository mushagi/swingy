package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import views.gui.GUI;
import views.gui.Panels.GamePanel;
import views.gui.Panels.NewLoadPlayerPanel;

import java.awt.*;

public class GUIController extends AUIController {
    private GUI guiInterface;

    public GUIController(ArenaController arenaController) {
        super(arenaController);
    }

    @Override
    public void switchUI() {
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

    private void showGamePanel() {
        GamePanel gamePanel = new GamePanel(arenaController.getArena().getMap().getSize());

        GamePanelController controller = new
                GamePanelController(arenaController, this, gamePanel);
        controller.updateUserInterface();

        switchMainWindowPanel(gamePanel);
    }

    private void showCreateNewLoadPlayerWindow() {
        NewLoadPlayerPanel newLoadPlayerPanel = new NewLoadPlayerPanel();

        NewLoadPlayerPanelController controller = new
                NewLoadPlayerPanelController(arenaController, this, newLoadPlayerPanel);
        controller.updateUserInterface();

        switchMainWindowPanel(newLoadPlayerPanel);
    }
    void switchMainWindowPanel(Container panel) {
        guiInterface.addMainWindowContentPane(panel);
    }
}
