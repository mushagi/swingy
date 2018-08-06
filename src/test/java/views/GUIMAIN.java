package views;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GUIMAIN {
	static int i;
    public static void main(String args[]) {
        //GUI gui = new GUI();
	   // GamePanel heroListPanel = new GamePanel(5);
        //gui.addMainWindowContentPane(heroListPanel);
	    JFrame frame = new JFrame();
	    JPanel jPanel = new JPanel();
	    final JLabel label = new JLabel("label");

	
	    label.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
			
		    }
		
		    @Override
		    public void keyPressed(KeyEvent e) {
		    	i++;
		    	label.setText(""+i);
		    }
		
		    @Override
		    public void keyReleased(KeyEvent e) {
			
		    }
	    });
	    frame.add(jPanel);
	    jPanel.add(label);
	    jPanel.setFocusable(true);
	    jPanel.requestFocusInWindow();
	    frame.setVisible(true);
    }
}