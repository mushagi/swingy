package views.gui.custom;

import models.players.Hero;
import state.GameConstants;

import javax.swing.*;
import java.awt.*;

public class HeroStatisticsTextArea extends JTextArea {

	public HeroStatisticsTextArea() {
        this.setBackground(new Color(0,0,0,0));
	    Font monoFont = new Font("Monospaced", Font.PLAIN, 14);
	    setFont(monoFont);
	    setEditable(false);
	    setCursor(null);
	    setHighlighter(null);
	    setBackground(GameConstants.Colors.DARKEST_GRAY);
	    setForeground(GameConstants.Colors.DEFAULT_FONT);
    }

    public void updateWithHero(Hero hero) {
		setText(null);
	    String format = "%-20s%-20s\n";
	    append("Statistics\n\n");
	    append(String.format(format, "Name ", hero.getName()));
	    append(String.format(format, "Experience", hero.getExperience()));
	    append(String.format(format, "Level", hero.getLevel()));
	    append(String.format(format, "Type", hero.getType()));
	    append(String.format(format, "Attack", hero.getAttack()));
	    append(String.format(format, "Defence", hero.getDefence()));
    }
}
