package views.gui.Panels;

import lombok.Getter;
import models.players.Hero;

import javax.swing.*;
import java.awt.*;

public class HeroCell extends JPanel {
    @Getter
    private int tag ;

    HeroCell(Hero hero, int tag) {
        JLabel textField = new JLabel(hero.getName());
        this.add(textField);
        this.tag = tag;
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(150,150));
        this.setMaximumSize(new Dimension(150, 150));
    }

    void selected() {
        this.setBackground(Color.RED);
    }
    void unSelected() {
        this.setBackground(Color.CYAN);
    }
}