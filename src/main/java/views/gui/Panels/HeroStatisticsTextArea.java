package views.gui.Panels;

import models.players.Hero;
import state.GameColors;

import javax.swing.*;
import java.awt.*;

public class HeroStatisticsTextArea extends JTextArea {
	private JTextArea textArea= new JTextArea();
	
	HeroStatisticsTextArea() {
        this.setBackground(new Color(0,0,0,0));
	    Font monoFont = new Font("Monospaced", Font.PLAIN, 14);
	    textArea.setFont(monoFont);
	    textArea.setEditable(false);
	    textArea.setCursor(null);
	    textArea.setHighlighter(null);
	    textArea.setBackground(GameColors.TRANSPARENT);
	    textArea.setForeground(GameColors.DEFAULT_FONT);
	    add(textArea);
    }
    
    public void updateWithHero(Hero hero) {
		textArea.setText(null);
	    String format = "%-20s%-20s\n";
	    textArea.append("Statistics\n\n");
	    textArea.append(String.format(format, "Hero Class", hero.getHeroClass()));
	    textArea.append(String.format(format, "Experience", hero.getExperience()));
	    textArea.append(String.format(format, "Level", hero.getLevel()));
	    textArea.append(String.format(format, "Type", hero.getType()));
	    textArea.append(String.format(format, "Attack", hero.getAttack()));
	    textArea.append(String.format(format, "Defence", hero.getDefence()));
    }
}
