package views;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.ArenaController;
import za.co.wethinkcode.mmayibo.swingy.factory.ArenaControllerFactory;
import za.co.wethinkcode.mmayibo.swingy.factory.ArenaFactory;
import za.co.wethinkcode.mmayibo.swingy.views.gui.GUI;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.GameEndedPanel;

import javax.swing.JPanel;


class GUIMAIN extends JPanel {
	

	
	public static void main(String[] args) {
		ArenaController arena = ArenaControllerFactory.newArenaControllerFromGameData();
		GameEndedPanel heroCell = new GameEndedPanel(ArenaFactory.newArena());
		GUI gui = new GUI();
		gui.addMainWindowContentPane(heroCell);
	}
}