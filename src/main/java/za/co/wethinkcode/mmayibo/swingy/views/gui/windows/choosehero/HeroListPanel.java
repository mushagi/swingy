package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero;

import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

class HeroListPanel extends JPanel {
	private final JScrollPane scroll = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private final ArrayList<HeroCell> components = new ArrayList<>();
	
	public HeroListPanel(Collection<Hero> heroes) {
		int tag = 0;
		setLayout(new BorderLayout());

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setLayout(new FlowLayout());
		for (Hero hero: heroes){
			HeroCell heroCell = new HeroCell(hero, tag++);
			mainPanel.add(heroCell);
			components.add(heroCell);
		}

		scroll.setViewportView(mainPanel);
		scroll.setBorder(null);

		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		mainPanel.setOpaque(false);

		mainPanel.setPreferredSize(new Dimension(500,heroes.size() * 50));

		this.setBackground(SwingyConstants.Colors.TRANSPARENT);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	void addMouseListeners(MouseListener mouseListener) {
		
		for (Component component : components) {
			component.addMouseListener(mouseListener);
		}
	}
}