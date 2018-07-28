package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseHeroPanelController extends AUIController {

    private final GUIController guiController;
    ChooseHeroPanel chooseHeroPanel;

    public ChooseHeroPanelController(ArenaController arenaController , GUIController guiController, ChooseHeroPanel chooseHeroPanel) {
        super(arenaController);
        this.chooseHeroPanel = chooseHeroPanel;
        this.guiController = guiController;
        addAllListeners();
    }


    private void addAllListeners() {
        chooseHeroPanel.addOnNextActionListener(onNextActionListener);
    }
    
    private ActionListener onNextActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GamePanel gamePanel = new GamePanel(arenaController.getArena().getMap().getSize());
            GamePanelController controller =
                    new GamePanelController(arenaController, guiController, gamePanel);
            controller.updateUserInterface();
            guiController.switchMainWindowPanel(gamePanel);
        }
    };

    @Override
    public void switchUI() {
        
    }

    @Override
    protected void updateUserInterface() {
        guiController.updateUserInterface();
    }


    @Override
    public void run() {

    }
}