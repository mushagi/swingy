package views;

import state.GameState;
import views.gui.GUI;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.GamePanel;

class GUIMAIN {
    public static void main(String args[]) {
        GUI gui = new GUI();
        ChooseHeroPanel ChooseHeroPanel = new ChooseHeroPanel(GameState.getInstance().getAvailableHeroes());
        ChooseHeroPanel.heroStatisticsPanel.updateWithHero(GameState.getInstance().getAvailableHeroes().get(0));
        gui.addMainWindowContentPane(ChooseHeroPanel);
    }
}