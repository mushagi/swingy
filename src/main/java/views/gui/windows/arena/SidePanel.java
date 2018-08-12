package views.gui.windows.arena;

import controllers.models.BattleReport;
import models.players.Hero;
import state.GameConstants;
import views.gui.custom.HeroStatisticsTextArea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SidePanel extends JPanel{
    private final JScrollPane scroll = new JScrollPane(
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JPanel messagePanel = new JPanel();
    private final JLabel label = new JLabel();
	private final BottomStatisticsPanel bottomStats = new BottomStatisticsPanel();
	
	private boolean isShowingHeroStatistics = false;

    SidePanel() {
    	setLayout(new BorderLayout());
	
    	scroll.setBorder(BorderFactory.createEmptyBorder());
	    this.add(scroll, BorderLayout.CENTER);
	    this.add(bottomStats, BorderLayout.SOUTH);
    	setUpMessagePanel();
    }
	
	private void setUpMessagePanel() {
    	label.setForeground(GameConstants.Colors.DEFAULT_FONT);
        messagePanel.setLayout(new GridBagLayout());
		messagePanel.add(label);
		messagePanel.setBackground(GameConstants.Colors.DARKEST_GRAY);
	}

	void showMessage(ArrayList<String> results) {
	    isShowingHeroStatistics = false;
	    
	    StringBuilder stringBuilder  = new StringBuilder();
        for (String message: results)
            stringBuilder.append(message).append("\n");
        label.setText(stringBuilder.toString());
	    showMessagePanel();
    }
    
    void updateBottomStatistics(Hero hero) {
    	bottomStats.update(hero);
    }
    private void showMessagePanel() {
    	showViewComponentInScroll(messagePanel);
    }

    private void showHeroStatistics(Hero hero){
	    HeroStatisticsTextArea heroStatisticsTextArea = new HeroStatisticsTextArea();
	    heroStatisticsTextArea.updateWithHero(hero);
	    showViewComponentInScroll(heroStatisticsTextArea);
    }
    
    void showBattleReport(BattleReport battleReport) {
        BattleReportTextArea battleReportTextArea =
		        new BattleReportTextArea(battleReport);
        showViewComponentInScroll(battleReportTextArea);
    }
    
    void toggleHeroStats(Hero hero) {
	    if ( isShowingHeroStatistics )
    		showMessagePanel();
    	else
    		showHeroStatistics(hero);
    	isShowingHeroStatistics = !isShowingHeroStatistics;
     }
     
     private void showViewComponentInScroll(JComponent component) {
	     scroll.setViewportView(component);
         scroll.setOpaque(false);
         scroll.getViewport().setOpaque(false);
     }
}
