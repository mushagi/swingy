package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena;

import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;

import javax.swing.*;
import java.awt.*;

public class MiniMap extends JPanel {
	
	private JPanel playerPos = new JPanel();
	public MiniMap() {
		setSize(new Dimension(100,100));
	//	setBorder(BorderFactory.createEtchedBorder(0, Color.RED, Color.YELLOW));
		playerPos.setBorder(BorderFactory.createEtchedBorder(0, Color.RED, Color.YELLOW));
		add(playerPos);
	}
	
	public void updateMap(Arena arena) {
		//	Position heroPos = arena.getHero().getPosition();
		//double heroXPercentagePos = heroPos.x / arena.getMap().getSize() * 100;
		//double heroYPercentagePos = heroPos.y / arena.getMap().getSize() * 100;
		
	//	double localPlayerXPos = heroXPercentagePos;
		playerPos.setLocation(new Point(10000,1000));
		playerPos.revalidate();
		playerPos.repaint();
		
		repaint();
		revalidate();
	}
}
