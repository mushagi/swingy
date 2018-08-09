package views.gui.Panels;

import controllers.models.BattleReport;
import models.players.Hero;
import state.GameColors;

import javax.swing.*;
import java.util.ArrayList;

public class SidePanel extends JPanel{
    private JScrollPane scroll;
    private final JPanel innerPanel = new JPanel();
    private final JLabel label = new JLabel();
    private boolean isShowingHeroStatistics = false;

    public SidePanel() {
        setBackground(GameColors.DARKEST_GRAY);

    }

    void showMessage(ArrayList<String> results) {

        StringBuilder stringBuilder  = new StringBuilder();

        if (this.getComponents().length > 0)
            this.remove(0);

        for (String message: results)
            stringBuilder.append(message + "\n");

        label.setText(stringBuilder.toString());
        showInnerPanelWithMessage();
    }

    private void showInnerPanelWithMessage() {
        SpringLayout layout = new SpringLayout();
        innerPanel.setLayout(layout);
        innerPanel.setBackground(GameColors.DARKEST_GRAY);
        label.setForeground(GameColors.DEFAULT_FONT);
        innerPanel.add(label);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, innerPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, innerPanel);

        scroll = new JScrollPane(innerPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setBackground(GameColors.TRANSPARENT);
        this.add(scroll);

        this.repaint();
        this.revalidate();
    }

    void showBattleReport(BattleReport battleReport) {
        BattleReportTextArea battleReportTextArea = new BattleReportTextArea(battleReport);

        scroll = new JScrollPane(battleReportTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        if (getComponents().length > 0)
            this.remove(0);

        scroll.setBackground(GameColors.TRANSPARENT);
        innerPanel.setBackground(GameColors.DARKEST_GRAY);

        this.add(scroll);

        this.repaint();
        this.revalidate();
    }

     void toggleHeroStats(Hero hero) {

         if (isShowingHeroStatistics) {
             if (getComponents().length > 0 && getComponent(0) instanceof HeroStatisticsPanel) {
                 this.remove(0);
                 showInnerPanelWithMessage();
             }
         }
         else {
             HeroStatisticsPanel heroStatisticsPanel = new HeroStatisticsPanel();

             add(scroll);
             scroll.revalidate();
             heroStatisticsPanel.updateWithHero(hero);
             heroStatisticsPanel.setMinimumSize(getPreferredSize());
             remove(0);
             add(heroStatisticsPanel);
             revalidate();
             heroStatisticsPanel.revalidate();
             
             isShowingHeroStatistics = true;
         }
         this.repaint();
         this.revalidate();
     }
}
