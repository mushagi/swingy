package views.gui.Panels;

import controllers.models.BattleReport;
import state.GameColors;

import javax.swing.*;
import java.awt.*;

public class BattleReportTextArea extends JTextArea {
	
	public BattleReportTextArea(BattleReport battleReport) {
		
		Font monoFont = new Font("Monospaced", Font.PLAIN, 14);
		setFont(monoFont);
		setEditable(false);
		setCursor(null);
		setHighlighter(null);
		setLineWrap(true);
		setWrapStyleWord(true);
		setForeground(GameColors.DEFAULT_FONT);
		setBackground(GameColors.DARKEST_GRAY);
		setText(null);
		
		this.addText("Battle Report");
		this.addText("_________________________________________");
		this.addText(battleReport.isHeroIsFirstAttacker() ? "Hero" : "Enemy" + " is attacking first");
		
		
		boolean switchAllignment = false;
		for (String attakSimulations: battleReport.getBattleSimulation())
		{
			String[] attackSimulations = attakSimulations.split("\n");
			
			for (String attackSim : attackSimulations){
				if (!switchAllignment){
					this.addText(attackSim);
				}
				else
					this.addTextRight(attackSim);
			}
			if (!switchAllignment){
				this.addText(("-----------------------"));
			}
			else
				this.addTextRight(("-----------------------"));
			switchAllignment = !switchAllignment;
		}
		this.addText("_________________________________________");
		this.addText(battleReport.getWinner().getType() + " Wins!!");
		this.addText(battleReport.getLoser().getType() + " says: "+battleReport.getLoser().getLosingSpeech());
		this.addText(battleReport.getWinner().getType() +" says: "+battleReport.getWinner().getWinningSpeech());
	}
	
	void addText(String text) {
		String format = "%s\n";
		this.append(String.format(format, text));
	}
	
	void addTextRight(String text) {
		String format = "%42s\n";
		this.append(String.format(format, text));
	}
}
