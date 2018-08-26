package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.BattleReport;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;

import javax.swing.*;

class SidePanelTextArea extends JTextArea {
	
	SidePanelTextArea() {
		
		setFont(SwingyConstants.MONO_FONT);
		setEditable(false);
		setCursor(null);
		setHighlighter(null);
		setLineWrap(true);
		setWrapStyleWord(true);
		setForeground(SwingyConstants.Colors.DEFAULT_FONT);
		setBackground(SwingyConstants.Colors.DARKEST);
		setText(null);
		

	}
	
	private void addText(String text) {
		String format = "%s\n";
		this.append(String.format(format, text));
	}
	
	private void addTextRight(String text) {
		String format = "%42s\n";
		this.append(String.format(format, text));
	}
	
	void battleReportUpdate(BattleReport battleReport) {
		this.setText(null);
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
	

}
