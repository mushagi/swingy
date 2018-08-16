package views.gui.windows.arena;

import models.players.Hero;
import state.GameConstants;

import javax.swing.*;
import java.awt.*;

class BottomStatisticsPanel extends JPanel {
	private final JLabel lblName = new JLabel();
	private final JLabel lblXp = new JLabel();
	private final JLabel lblLevel = new JLabel();
	
	BottomStatisticsPanel() {
		this.setBackground(GameConstants.Colors.DARKEST);
		
		setLayout(new GridLayout(1,3));
		setFont(GameConstants.MONO_FONT);
		lblName.setForeground(GameConstants.Colors.DEFAULT_FONT);
		lblXp.setForeground(GameConstants.Colors.DEFAULT_FONT);
		lblLevel.setForeground(GameConstants.Colors.DEFAULT_FONT);
		
		add(lblName);
		add(lblXp);
		add(lblLevel);
	}
	
	void update(Hero hero) {
		lblName.setText(hero.getName());
		lblXp.setText("Xp:  "+hero.getExperience());
		lblLevel.setText("Levelb: " + hero.getLevel());
	}
}
