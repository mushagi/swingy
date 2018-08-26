package za.co.wethinkcode.mmayibo.swingy.views.gui.windows;

import za.co.wethinkcode.mmayibo.swingy.models.messages.GameResults;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.GameButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameEndedPanel extends JPanel {
	private final Arena arena;
	private final GameResults gameResults;
	
	private final GameButton btnNewGame = new GameButton("");
	private final GameButton btnBackToMenu = new GameButton("Main Menu");
	private final GameButton btnQuit = new GameButton("Quit");
	private final ResultsPanel resultsPanel = new ResultsPanel();
	private final Dimension dimension = new Dimension(200,40);
	
	public GameEndedPanel(Arena arena) {
		this.arena = arena;
		this.gameResults =  arena.getGameResults();
		setUpLayout();
		
		btnNewGame.setText(gameResults.isHeroWon()? "New Game" : "Try again");
		
		btnBackToMenu.setPreferredSize(dimension);
		btnQuit.setPreferredSize(dimension);
		btnNewGame.setPreferredSize(dimension);
		
		this.setBackground(SwingyConstants.Colors.DARKEST);
		if (gameResults.isHeroWon()) 
			resultsPanel.setUpHeroWonMessage(arena);
		else 
			resultsPanel.setUpHeroLostMessage(arena);
		
		this.add(resultsPanel);
		this.add(btnNewGame);
		this.add(btnBackToMenu);
		this.add(btnQuit);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(0, 0, SwingyConstants.Colors.DARKEST, 12, h,SwingyConstants.Colors.BRIGHTER);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}
	
	
	private void setUpLayout() {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, resultsPanel, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, resultsPanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, btnNewGame, 0, SpringLayout.SOUTH ,resultsPanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnNewGame, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, btnBackToMenu, 0, SpringLayout.SOUTH ,resultsPanel);
		layout.putConstraint(SpringLayout.EAST, btnBackToMenu, -50, SpringLayout.WEST, btnNewGame);
		
		layout.putConstraint(SpringLayout.NORTH, btnQuit, 0, SpringLayout.SOUTH ,resultsPanel);
		layout.putConstraint(SpringLayout.WEST, btnQuit, 50, SpringLayout.EAST, btnNewGame);
		
	}
	
	private JPanel getMessagePanel() {
		JPanel messagePanel = new JPanel();
		JLabel label = new JLabel();
		StringBuilder stringBuilder = new StringBuilder();
		
		for (String string : arena.getGameResults().getResult())
			stringBuilder.append(string).append("\n");
		
		label.setText(stringBuilder.toString());
		label.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
		messagePanel.setBackground(SwingyConstants.Colors.TRANSPARENT);
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
	
	private class ResultsPanel extends JPanel{
		JLabel label = new JLabel();
		StringBuilder stringBuilder = new StringBuilder();
		
		public ResultsPanel() {
			this.setLayout(new GridBagLayout());
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(700, 400));
			label.setFont(SwingyConstants.MONO_FONT);
			label.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.CENTER);
			this.add(label);
		}
		
		public void setUpHeroWonMessage(Arena arena) {
			stringBuilder.setLength(0);
			stringBuilder.append("<html><div style='text-align: center;'>");
			stringBuilder
					.append("<h1>You reached your destination!!</h1>").append("<br>")
					.append("<h2>Wakanda Forever</h2>").append("<br>")
					.append("Experience ").append(arena.getHero().getExperience())
					.append(" <font color = 'green'>+").append(arena.getHero().getExperience() - gameResults.getHeroBeforeGame().getExperience()).append(" </font><br>")
					.append("Level ").append(arena.getHero().getLevel()).append(" <br>");
			
			stringBuilder.append("</div></html>");
			
			label.setText(stringBuilder.toString());
			
		}
		
		public void setUpHeroLostMessage(Arena arena) {
			stringBuilder.setLength(0);
			stringBuilder.append("<html><div style='text-align: center;'>");
			stringBuilder
					.append("<h1>You Lost bro!!</h1>").append("<br>")
					.append("<h2>")
					.append(arena.getGameResults().getEnemyWon().getName())
					.append(" says ").append(arena.getGameResults().getEnemyWon().getWinningSpeech()).append("</h2> <br>")
					.append("Experience ").append(arena.getHero().getExperience())
					.append(" <font color = 'green'>+").append(arena.getHero().getExperience() - gameResults.getHeroBeforeGame().getExperience()).append(" </font><br>")
					.append("Level ").append(arena.getHero().getLevel()).append(" <br>");
			
			stringBuilder.append("</div></html>");
			
			label.setText(stringBuilder.toString());
		}
	}
}
