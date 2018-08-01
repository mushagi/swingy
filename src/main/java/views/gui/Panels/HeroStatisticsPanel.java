package views.gui.Panels;

import models.players.Hero;

import javax.swing.*;
import java.awt.*;

class HeroStatisticsPanel extends JPanel {
    private final JLabel lblPlayerStats = new JLabel("Player statistics");

    private final JLabel lblPlayerName = new JLabel("sfd");
    private final JLabel lblPlayerType = new JLabel("sdf");
    private final JLabel lblPlayerExperience = new JLabel("sdfsasdasdasd");
    private final JLabel lblLevel = new JLabel("sfd");
    private final JLabel lblAttack = new JLabel("sdf");
    private final JLabel lblDefence = new JLabel("sdfsasdasdasd");
    private final JLabel lblHitPoint = new JLabel("sdfsasdasdasd");

    public HeroStatisticsPanel() {
        this.setLayout(new GridLayout(8, 0));

        add(lblPlayerStats);
        add(lblPlayerName);
        add(lblPlayerType);
        add(lblPlayerExperience);
        add(lblLevel);
        add(lblAttack);
        add(lblDefence);
        add(lblHitPoint);

    }

    void add(Hero hero) {

    }

    public void updateWithHero(Hero hero) {
        lblPlayerName.setText("Hero Name" + hero.getName());
        lblPlayerType.setText("Type" +hero.getType());
        lblPlayerExperience.setText("Experience : "+hero.getExperience());
        lblLevel.setText("Level : "+ hero.getLevel());
        lblAttack.setText("Attack : "+ hero.getAttack());
        lblDefence.setText("Defence : "+ hero.getDefence());
        lblHitPoint.setText("Hit Point : "+ hero.getHitPoint());

    }
}
