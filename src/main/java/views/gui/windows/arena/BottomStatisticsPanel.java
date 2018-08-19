package views.gui.windows.arena;

import models.players.Hero;
import state.SwingyConstants;

import javax.swing.*;
import java.awt.*;

class BottomStatisticsPanel extends JPanel {
	private final JLabel lblName = new JLabel();
	private final JLabel lblXp = new JLabel();
	private final JLabel lblLevel = new JLabel();
	
	BottomStatisticsPanel() {
		this.setBackground(SwingyConstants.Colors.DARKEST);
		
		setLayout(new GridLayout(1,3));
		setFont(SwingyConstants.MONO_FONT);
		lblName.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
		lblXp.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
		lblLevel.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
		
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
