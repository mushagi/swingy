package views.gui.Panels;

import models.players.Hero;

import javax.swing.*;
import java.awt.*;

public class HeroStatisticsPanel extends JPanel {
    private final JLabel lblPlayerStats = new JLabel("Player statistics");

    private final JLabel lblPlayerName = new JLabel("");
    private final JLabel lblPlayerType = new JLabel("");
    private final JLabel lblPlayerExperience = new JLabel("");
    private final JLabel lblLevel = new JLabel("");
    private final JLabel lblAttack = new JLabel("");
    private final JLabel lblDefence = new JLabel("");
    private final JLabel lblHitPoint = new JLabel("");

    public HeroStatisticsPanel() {
        this.setLayout(new GridLayout(8, 0));
        this.setBackground(new Color(0,0,0,0));
        add(lblPlayerStats);
        add(lblPlayerName);
        add(lblPlayerType);
        add(lblPlayerExperience);
        add(lblLevel);
        add(lblAttack);
        add(lblDefence);
        add(lblHitPoint);
        lblPlayerName.setHorizontalAlignment(Label.RIGHT);
        lblPlayerStats.setHorizontalAlignment(Label.RIGHT);
        lblPlayerType.setHorizontalAlignment(Label.RIGHT);
        lblPlayerExperience.setHorizontalAlignment(Label.RIGHT);
        lblLevel.setHorizontalAlignment(Label.RIGHT);
        lblAttack.setHorizontalAlignment(Label.RIGHT);
        lblHitPoint.setHorizontalAlignment(Label.RIGHT);
        lblPlayerStats.setHorizontalAlignment(Label.RIGHT);

    }

    void add(Hero hero) {

    }

    public void updateWithHero(Hero hero) {
        lblPlayerName.setText       (String.format("%-20s%20s","Hero Name",hero.getName()));
        lblPlayerType.setText       (String.format("%-20s%20s","Type",hero.getType()));
        lblPlayerExperience.setText (String.format("%-20s%20s","Experience", hero.getExperience()));
        lblLevel.setText           (String.format("%-20s%20s","Level", hero.getLevel()));
        lblAttack.setText(String.format("%-20s%s","Attack", hero.getAttack()));
        lblDefence.setText(String.format("%-20s%s","Defence", hero.getDefence()));
        lblHitPoint.setText(String.format("%-20s%s", "Point", hero.getHitPoint()));

    }
}
