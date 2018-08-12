package views.gui.windows.arena;

import controllers.models.BattleReport;
import state.GameConstants;

import javax.swing.*;

class BattleReportTextArea extends JTextArea {
	
	BattleReportTextArea(BattleReport battleReport) {
		
		setFont(GameConstants.MONO_FONT);
		setEditable(false);
		setCursor(null);
		setHighlighter(null);
		setLineWrap(true);
		setWrapStyleWord(true);
		setForeground(GameConstants.Colors.DEFAULT_FONT);
		setBackground(GameConstants.Colors.DARKEST_GRAY);
		setText(null);
		
		this.addText("Battle Report");
		this.addText("_________________________________________");
		this.addText(battleReport.isHeroIsFirstAttacker() ? "Hero" : "Enemy" + " is attacking first");
		
		
		boolean switchJustification = false;
		for (String attackSimulations: battleReport.getBattleSimulation())
		{
			String[] strings = attackSimulations.split("\n");
			
			for (String attackSim : strings){
				if (!switchJustification){
					this.addText(attackSim);
				}
				else
					this.addTextRight(attackSim);
			}
			if (!switchJustification){
				this.addText(("-----------------------"));
			}
			else
				this.addTextRight(("-----------------------"));
			switchJustification = !switchJustification;
		}
		this.addText("_________________________________________");
		this.addText(battleReport.getWinner().getType() + " Wins!!");
		this.addText(battleReport.getLoser().getType() + " says: "+battleReport.getLoser().getLosingSpeech());
		this.addText(battleReport.getWinner().getType() +" says: "+battleReport.getWinner().getWinningSpeech());
	}
	
	private void addText(String text) {
		String format = "%s\n";
		this.append(String.format(format, text));
	}
	
	private void addTextRight(String text) {
		String format = "%42s\n";
		this.append(String.format(format, text));
	}
}
