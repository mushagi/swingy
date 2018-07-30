package views;

import state.GameState;
import views.gui.GUI;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.GamePanel;
import views.gui.Panels.HeroStatisticsPanel;
import views.gui.Panels.NewLoadPlayerPanel;

public class GUIMAIN {
    public static void main(String args[]) {
        GUI gui = new GUI();
        GamePanel newLoadPlayerPanel = new GamePanel(7);
        gui.addMainWindowContentPane(newLoadPlayerPanel);
    }
}