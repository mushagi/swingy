package views;

import views.gui.GUI;
import views.gui.windows.arena.MapCell;

class GUIMAIN {
	static int i;
    public static void main(String args[]) {
    	
    	GUI gui = new GUI();
    	MapCell mePanel = new MapCell(10);
	
	    gui.addMainWindowContentPane(mePanel);
	
    }

}