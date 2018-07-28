package views.gui.Panels;

import models.players.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ChooseHeroPanel extends JPanel {

    private final JButton btnNext = new JButton("Next");

    public ChooseHeroPanel(Collection<Hero> heroes) {
        JLabel  label = new JLabel("Choose a Wakandian: ");
        add(label, BorderLayout.CENTER);

        HeroListPanel heroListPanel = new HeroListPanel(heroes);
        add(heroListPanel, BorderLayout.CENTER);

        add(btnNext);
    }

    public void addOnNextActionListener(ActionListener nextActionListener) {
        btnNext.addActionListener(nextActionListener);
    }
}

class HeroListPanel extends JPanel {
    public HeroListPanel(Collection<Hero> heroes) {
        this.setLayout(new GridLayout(5,5));
        for (Hero hero: heroes) {
            add(new HeroCell(hero));
        }
    }
}

class HeroCell extends JPanel {

    public HeroCell(Hero hero) {
        JLabel textField = new JLabel(hero.getName());
        this.add(textField);
    }

}
