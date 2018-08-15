package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Position;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;

public class MapCell extends JPanel {
	public static final int MAP_CELL_MIN_HEIGHT = 45;
	public static final int MAP_CELL_MIN_WIDTH = 45;
	public static final int MAP_CELL_MAX_HEIGHT = 85;
	public static final int MAP_CELL_MAX_WIDTH = 85;
	
	private final JLabel lblImage = new JLabel();
	
	MapCell(int mapSize) {
		setBackground(GameConstants.Colors.LIGHTER_GRAY);
		
		GridBagLayout layout = new GridBagLayout();
    	setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		layout.setConstraints(lblImage, constraints);
		
		add(lblImage);
        lblImage.setPreferredSize(
        		mapSize < 9 ? new Dimension(MAP_CELL_MAX_WIDTH,MAP_CELL_MAX_HEIGHT) :
				        new Dimension(MAP_CELL_MIN_WIDTH,MAP_CELL_MIN_HEIGHT)
        );
	}
	
	void setValues(Position position, int mapSize, APlayer player) {
		if (player != null) {
			ImageIcon imageIcon =
		            ImageRepositoryImp.getInstance().getImageIcon(
		            		player.getPicture(),
				            lblImage.getPreferredSize()
		            );
            lblImage.setIcon(imageIcon);
		}
		else
			lblImage.setIcon(null);
		EBORDER borderType = getBorderType(mapSize, position);
		createBorder(borderType);
		repaint();
    }

    private EBORDER getBorderType(int size, Position position) {
        size--;
        if (position.x == 0 && position.y == 0)
            return EBORDER.LEFTTOP;
        else if (position.x == size && position.y == 0)
            return EBORDER.RIGHTTOP;
        else if (position.x == 0 && position.y == size)
            return EBORDER.LEFTBOTTOM;
        else if (position.x == size && position.y == size)
            return EBORDER.RIGHTBOTTOM;
        else if (position.x == 0)
            return EBORDER.LEFT;
        else if (position.x == size)
            return EBORDER.RIGHT;
        else if (position.y == size)
            return EBORDER.BOTTOM;
        else if (position.y == 0)
            return EBORDER.TOP;
        return EBORDER.NONE;
    }

    enum EBORDER {
        NONE,
        LEFT,
        RIGHT,
        BOTTOM,
        TOP,
        LEFTTOP,
        RIGHTTOP,
        LEFTBOTTOM,
        RIGHTBOTTOM
    }

    private void createBorder(EBORDER eborder) {
        switch (eborder)
        {
            case TOP:
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(10,0,0,0, Color.RED),
		                BorderFactory.createMatteBorder(0,1,1,1, GameConstants.Colors.LIGHTER_BLUE)
                ));
                break;
            case RIGHTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(10,0,0,10, Color.RED),
			            BorderFactory.createMatteBorder(0,1,1,0, GameConstants.Colors.LIGHTER_BLUE)));
                break;
            case LEFT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,10,0,0, Color.RED),
			            BorderFactory.createMatteBorder(1,0,1,1, GameConstants.Colors.LIGHTER_BLUE)));
                break;
            case RIGHT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,10, Color.RED),
			            BorderFactory.createMatteBorder(1,1,1,0, GameConstants.Colors.LIGHTER_BLUE)));
                break;
            case BOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,10,0, Color.RED),
			            BorderFactory.createMatteBorder(1,1,0,1, GameConstants.Colors.LIGHTER_BLUE)));
                break;
            case LEFTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,10,10,0, Color.RED),
			            BorderFactory.createMatteBorder(1,0,0,1, GameConstants.Colors.LIGHTER_BLUE)));
  
                break;
            case LEFTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(10,10,0,0, Color.RED),
			            BorderFactory.createMatteBorder(0,0,1,1, GameConstants.Colors.LIGHTER_BLUE)));
         
                break;
            case RIGHTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,10,10, Color.RED),
			            BorderFactory.createMatteBorder(1,1,0,0, GameConstants.Colors.LIGHTER_BLUE)));
           
                break;
            case NONE:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,0, Color.RED),
			            BorderFactory.createMatteBorder(1,1,1,1, GameConstants.Colors.LIGHTER_BLUE)
	            ));
                break;
        }
    }
}
