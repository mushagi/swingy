package views.gui.custom;

import state.SwingyConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameButton extends JButton {
    Border hoverBorder = BorderFactory.createMatteBorder(0,0,10,0, SwingyConstants.Colors.BRIGHTEST);
    Border selectedBorder = BorderFactory.createMatteBorder(0,0,10,0, SwingyConstants.Colors.REDDISH);
    private static boolean isMousePressed;
    private static GameButton activeButton;
    
    
    public GameButton(String text) throws HeadlessException {
        super(text);

        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFocusable(false);
        setForeground(SwingyConstants.Colors.DEFAULT_FONT);
        
        addMouseListener(mouseListener);
    }
    
    private MouseListener mouseListener = new MouseListener() {
        
        private boolean left = false;
        
        @Override
        public void mouseClicked(MouseEvent e) {

        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            if (activeButton != e.getSource() && activeButton != null){
                activeButton.updateBorder(null);
            }
            activeButton = (GameButton) e.getSource();
            updateBorder(selectedBorder);
            isMousePressed = true;
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            isMousePressed = false;
            updateBorder(left ? null : hoverBorder);
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if(!isMousePressed)
                updateBorder(hoverBorder);
            left = false;
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            if (!isMousePressed)
                updateBorder(null);
            left = true;
        }
        
    };

    
    void updateBorder(Border border) {
        setBorder(border);
    }
}
