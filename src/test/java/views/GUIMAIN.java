package views;

import state.GameState;
import views.gui.GUI;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.NewLoadPlayerPanel;

public class GUIMAIN {
    public static void main(String args[]) {
        GUI gui = new GUI();
        ChooseHeroPanel newLoadPlayerPanel = new ChooseHeroPanel(GameState.getInstance().getAvailableHeroes());
        gui.addMainWindowContentPane(newLoadPlayerPanel);
    }
}
