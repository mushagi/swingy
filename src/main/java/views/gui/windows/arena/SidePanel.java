package views.gui.windows.arena;

import controllers.models.BattleReport;
import models.players.Hero;
import state.SwingyConstants;
import views.gui.custom.HeroStatisticsTextArea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SidePanel extends JPanel{
    private final JScrollPane scroll = new JScrollPane(
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
	private final BottomStatisticsPanel bottomStats = new BottomStatisticsPanel();
	private HeroStatisticsTextArea heroStatisticsTextArea = new HeroStatisticsTextArea();
	private SidePanelTextArea sidePanelTextArea = new SidePanelTextArea();
	private MessagePanel messagePanel = new MessagePanel();
	private boolean isShowingHeroStatistics = false;

    SidePanel() {
    	setLayout(new BorderLayout());
    	setOpaque(false);
    	
	    scroll.getViewport().setOpaque(false);
	    scroll.setBorder(BorderFactory.createEmptyBorder());
    	scroll.setOpaque(false);
    	
	    this.add(scroll, BorderLayout.CENTER);
	    this.add(bottomStats, BorderLayout.SOUTH);
    }
    
	void showMessage(ArrayList<String> results) {
	    isShowingHeroStatistics = false;
		messagePanel.setLabelText(results);
		showMessagePanel();
    }
	
	private void showMessagePanel() {
    	showViewComponentInScroll(messagePanel);
	}
	
	void updateBottomStatistics(Hero hero) {
    	bottomStats.update(hero);
    }

    private void showHeroStatistics(Hero hero){
	    heroStatisticsTextArea.updateWithHero(hero);
	    showViewComponentInScroll(heroStatisticsTextArea);
    }
    
    void showBattleReport(BattleReport battleReport) {
    	sidePanelTextArea.battleReportUpdate(battleReport);
        showSidePanel();
    }
	
	private void showSidePanel() {
		showViewComponentInScroll(sidePanelTextArea);
	}
	
    void toggleHeroStats(Hero hero) {
	    if ( isShowingHeroStatistics )
    		showSidePanel();
    	else
    		showHeroStatistics(hero);
    	isShowingHeroStatistics = !isShowingHeroStatistics;
     }
     private void showViewComponentInScroll(JComponent component) {
    	scroll.setViewportView(component);
    }
    
    private class MessagePanel extends JPanel{
    	JLabel label = new JLabel();
	    StringBuilder stringBuilder = new StringBuilder();
	
	    MessagePanel() {
	    	this.setOpaque(false);
		    this.setLayout(new GridBagLayout());
		    label.setFont(SwingyConstants.MONO_FONT);
	    	label.setForeground(SwingyConstants.Colors.DEFAULT_FONT);
	    	label.setHorizontalAlignment(SwingConstants.CENTER);
	    	label.setVerticalAlignment(SwingConstants.CENTER);
	    	this.add(label);

	    }
	    
	    void setLabelText(ArrayList<String> results) {
	    	stringBuilder.setLength(0);
	    	stringBuilder.append("<html><div style='text-align: center;'>");
	    	
	    	for (String message: results) {
	    		message = message.replaceAll("\n", "<br>");
	    		stringBuilder.append(message).append("<br>");
	    		
		    }
		    stringBuilder.append("</div></html>");

		    label.setText(stringBuilder.toString());
		
	    }
    }
}
