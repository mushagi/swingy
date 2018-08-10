package views.gui.Panels;

import models.players.Hero;
import state.GameColors;

import javax.swing.*;
import java.awt.*;

class HeroStatisticsTextArea extends JTextArea {

	HeroStatisticsTextArea() {
        this.setBackground(new Color(0,0,0,0));
	    Font monoFont = new Font("Monospaced", Font.PLAIN, 14);
	    setFont(monoFont);
	    setEditable(false);
	    setCursor(null);
	    setHighlighter(null);
	    setBackground(GameColors.DARKEST_GRAY);
	    setForeground(GameColors.DEFAULT_FONT);
    }

    void updateWithHero(Hero hero) {
		setText(null);
	    String format = "%-20s%-20s\n";
	    append("Statistics\n\n");
	    append(String.format(format, "Hero Class", hero.getHeroClass()));
	    append(String.format(format, "Experience", hero.getExperience()));
	    append(String.format(format, "Level", hero.getLevel()));
	    append(String.format(format, "Type", hero.getType()));
	    append(String.format(format, "Attack", hero.getAttack()));
	    append(String.format(format, "Defence", hero.getDefence()));
    }
}
