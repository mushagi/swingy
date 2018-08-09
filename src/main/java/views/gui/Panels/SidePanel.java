package views.gui.Panels;

import controllers.models.BattleReport;
import models.players.Hero;
import state.GameColors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SidePanel extends JPanel{
    private final JScrollPane scroll = new JScrollPane(
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JPanel messagePanel = new JPanel();
    private final JLabel label = new JLabel();
    
    private boolean isShowingHeroStatistics = false;

    SidePanel() {
    	setLayout(new BorderLayout());
	    label.setForeground(GameColors.DEFAULT_FONT);
	    
	    messagePanel.setLayout(new BorderLayout());
	    messagePanel.add(label, BorderLayout.CENTER);
	    messagePanel.setBackground(GameColors.DARKEST_GRAY);
	    
	    
	    scroll.setBackground(GameColors.TRANSPARENT);
	    this.add(scroll, BorderLayout.CENTER);
    }

    void showMessage(ArrayList<String> results) {
	    isShowingHeroStatistics = false;
	    label.setText("");
	    StringBuilder stringBuilder  = new StringBuilder();
        
        for (String message: results)
            stringBuilder.append(message).append("\n");
        
        label.setText(stringBuilder.toString());
        
	    showMessagePanel();
    }

    private void showMessagePanel() {
    	showViewComponentInScroll(messagePanel);
    }
    
    private void showHeroStatistics(Hero hero){
	    HeroStatisticsTextArea heroStatisticsTextArea = new HeroStatisticsTextArea();
	    heroStatisticsTextArea.updateWithHero(hero);
	    heroStatisticsTextArea.setMinimumSize(getPreferredSize());
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
	     scroll.getViewport().revalidate();
	     scroll.getViewport().invalidate();
	     scroll.getViewport().repaint();
	     
     }
}
