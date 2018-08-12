package views.gui.windows;

import models.messages.GameResults;
import models.world.Arena;
import state.GameConstants;
import views.gui.custom.ButtonRounded;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameEndedPanel extends JPanel {
	private final Arena arena;
	private final GameResults gameResults;
	
	private final ButtonRounded btnNewGame = new ButtonRounded("");
	private final ButtonRounded btnBackToMenu = new ButtonRounded("Main Menu");
	private final ButtonRounded btnQuit = new ButtonRounded("Quit");
	
	public GameEndedPanel(Arena arena) {
		this.arena = arena;
		this.gameResults =  arena.getGameResults();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		btnNewGame.setText(gameResults.isHeroWon()? "New Game" : "Try again");
		
		this.setBackground(GameConstants.Colors.DARKEST_GRAY);

		
		JPanel messagePanel = getMessagePanel();

		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, messagePanel, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, messagePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, btnNewGame, 0, SpringLayout.SOUTH ,messagePanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnNewGame, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, btnBackToMenu, 0, SpringLayout.SOUTH ,messagePanel);
		layout.putConstraint(SpringLayout.EAST, btnBackToMenu, -50, SpringLayout.WEST, btnNewGame);
		
		layout.putConstraint(SpringLayout.NORTH, btnQuit, 0, SpringLayout.SOUTH ,messagePanel);
		layout.putConstraint(SpringLayout.WEST, btnQuit, 50, SpringLayout.EAST, btnNewGame);
		
		this.add(messagePanel);
		this.add(btnNewGame);
		this.add(btnBackToMenu);
		this.add(btnQuit);
		
	}
	
	private JPanel getMessagePanel() {
		JPanel messagePanel = new JPanel();
		JLabel label = new JLabel();
		StringBuilder stringBuilder = new StringBuilder();
		
		for (String string : arena.getGameResults().getResult())
			stringBuilder.append(string).append("\n");
		
		label.setText(stringBuilder.toString());
		label.setForeground(GameConstants.Colors.DEFAULT_FONT);
		messagePanel.setBackground(GameConstants.Colors.TRANSPARENT);
		messagePanel.add(label);
		return messagePanel;
	}
	
	public void addOnQuitListener(ActionListener onQuit) {
		btnQuit.addActionListener(onQuit);
	}
	
	public void addOnBackToMainMenuListener(ActionListener onBackToMainMenu) {
		btnBackToMenu.addActionListener(onBackToMainMenu);
		
	}
	
	public void addOnNewGameListeners(ActionListener onNewGame) {
		btnNewGame.addActionListener(onNewGame);
		
	}
}
