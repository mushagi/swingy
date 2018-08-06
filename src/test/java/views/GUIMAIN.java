package views;

import views.gui.GUI;
import views.gui.Panels.BattleReportBubblePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GUIMAIN {
	static int i;
    public static void main(String args[]) {
    	GUI gui = new GUI();
	    BattleReportBubblePanel heroListPanel = new BattleReportBubblePanel("This giy" +
			    "\nAtacls" +
			    "\nsgsdgsdgsdgfsdg\n" +
			    "Wasfasfasfasf\n" +
			    "Whatttttever");
	    
    	gui.addMainWindowContentPane(heroListPanel);
    	
    }
}