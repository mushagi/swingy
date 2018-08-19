package views.gui.windows.choosehero;

import models.players.Hero;
import state.SwingyConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

class HeroListPanel extends JPanel {
	private final ArrayList<HeroCell> components = new ArrayList<>();
	
	public HeroListPanel(Collection<Hero> heroes) {
		int tag = 0;
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(580,heroes.size() * 53));
		mainPanel.setLayout(new FlowLayout());
		
		for (Hero hero: heroes){
			HeroCell heroCell = new HeroCell(hero, tag++);
			mainPanel.add(heroCell);
			components.add(heroCell);
		}
		
		JScrollPane scroll = new JScrollPane(mainPanel,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(null);
		scroll.setBackground(SwingyConstants.Colors.TRANSPARENT);
		mainPanel.setBackground(SwingyConstants.Colors.TRANSPARENT);
		scroll.setPreferredSize(new Dimension(600, 600));
		
		this.setBackground(SwingyConstants.Colors.TRANSPARENT);
		this.add(scroll);
	}
	
	void addMouseListeners(MouseListener mouseListener) {
		
		for (Component component : components) {
			component.addMouseListener(mouseListener);
		}
	}
}