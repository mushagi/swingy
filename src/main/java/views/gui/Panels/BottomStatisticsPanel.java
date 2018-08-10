package views.gui.Panels;

import models.players.Hero;
import state.GameColors;
import state.GameConstants;

import javax.swing.*;
import java.awt.*;

public class BottomStatisticsPanel extends JPanel {
	private JLabel lblName = new JLabel();
	private JLabel lblXp = new JLabel();
	private JLabel lblLevel = new JLabel();
	
	BottomStatisticsPanel() {
		this.setBackground(GameColors.DARKEST_GRAY);
		setLayout(new GridLayout(1,3));
		setFont(GameConstants.MONO_FONT);
		lblName.setForeground(GameColors.DEFAULT_FONT);
		lblXp.setForeground(GameColors.DEFAULT_FONT);
		lblLevel.setForeground(GameColors.DEFAULT_FONT);
		
		add(lblName);
		add(lblXp);
		add(lblLevel);
	}
	
	void update(Hero hero) {
		lblName.setText(hero.getName());
		lblXp.setText("Xp:  "+hero.getExperience());
		lblLevel.setText("Level : " +hero.getLevel());
		
	}
}
