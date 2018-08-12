package views;

import state.GameConstants;
import views.gui.GUI;
import views.gui.windows.arena.MiniMap;

import javax.swing.*;
import java.awt.*;

class GUIMAIN {
	static int i;
    public static void main(String args[]) {
    	
    	JFrame frame = new JFrame();
    	
    	JPanel pa = new JPanel();
	    JPanel p = new JPanel();
	
	    frame.getContentPane().setLayout(null);    	pa.setBackground(GameConstants.Colors.BLUE);
	    p.setBackground(GameConstants.Colors.LIGHTER_GRAY);
	
	    frame.setSize(new Dimension(1000, 500));
	    pa.setPreferredSize(new Dimension(100, 100));

	    pa.setLocation(100, 199);
	
	    frame.add(pa);
	
	    frame.add(p);
    	frame.setVisible(true);
    /*	GUI gui = new GUI();
	    MiniMap mePanel = new MiniMap();
	    gui.addMainWindowContentPane(mePanel);
	    mePanel.updateMap(null);*/
    
    
    }
}