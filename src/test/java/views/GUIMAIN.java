package views;

import views.gui.GUI;
import views.gui.Panels.GamePanel;

class GUIMAIN {
    public static void main(String args[]) {
        GUI gui = new GUI();
        GamePanel newLoadPlayerPanel = new GamePanel(7);
        gui.addMainWindowContentPane(newLoadPlayerPanel);
    }
}