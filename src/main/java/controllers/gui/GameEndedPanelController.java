package controllers.gui;

import views.gui.Panels.GameEndedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameEndedPanelController extends APanelController{
	
	GameEndedPanel gameEndedPanel;
	public GameEndedPanelController(GUIController guiController, GameEndedPanel gameEndedPanel) {
		super(guiController);
		this.gameEndedPanel = gameEndedPanel;
		addAllListeners();
	}
	
	@Override
	void addAllListeners() {
		gameEndedPanel.addOnQuitListener(onQuit);
		gameEndedPanel.addOnBackToMainMenuListener(onBackToMainMenu);
		gameEndedPanel.addOnNewGameListeners(onNewGame);
	}
	@Override
	void updatePanel() {
	
	}
	
	private final ActionListener onQuit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guiController.quitGame();
		}
		
	};
	
	
	private final ActionListener onBackToMainMenu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guiController.showCreateNewLoadPlayerWindow();
		}
	};
	
	private final ActionListener onNewGame = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guiController.createNewGameExistingHero();
			guiController.showGamePanel();
		}
	};
	
	
}
