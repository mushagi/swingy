package views;

import controllers.models.ArenaController;
import factory.ArenaControllerFactory;
import factory.ArenaFactory;
import views.gui.GUI;
import views.gui.windows.GameEndedPanel;

import javax.swing.JPanel;


public class GUIMAIN extends JPanel {
	

	
	public static void main(String[] args) {
		ArenaController arena = ArenaControllerFactory.newArenaControllerFromGameData();
		GameEndedPanel heroCell = new GameEndedPanel(ArenaFactory.newArena());
		GUI gui = new GUI();
		gui.addMainWindowContentPane(heroCell);
	}
}