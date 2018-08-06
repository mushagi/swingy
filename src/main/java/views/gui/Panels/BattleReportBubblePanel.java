package views.gui.Panels;

import state.GameColors;
import views.gui.RoundedBorders;

import javax.swing.*;

public class BattleReportBubblePanel extends JTextArea {
	public BattleReportBubblePanel(String battleSimulation) {
		this.setBackground(GameColors.TRANSPARENT);
		this.append(battleSimulation);
		this.setBorder(new RoundedBorders(1000));
		
	}
}
