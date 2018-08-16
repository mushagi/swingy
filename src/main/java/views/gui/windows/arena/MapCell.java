package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Position;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MapCell extends JPanel {
	public static final int MAP_CELL_MIN_HEIGHT = 45;
	public static final int MAP_CELL_MIN_WIDTH = 45;
	public static final int MAP_CELL_MAX_HEIGHT = 85;
	public static final int MAP_CELL_MAX_WIDTH = 85;
    private static final Color BORDER_COLOR = new Color(119, 16, 61);
    private static final int BORDER_SIZE = 5;
    private  Image backgroundImage;

    private final JLabel lblImage = new JLabel();
	
	MapCell(int mapSize) {
		setBackground(GameConstants.Colors.LIGHTER);
		
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0,0,getWidth(),getHeight(),null);
    }

    void setValues(Position position, int mapSize, APlayer player) {

	  //  backgroundImage = ImageRepositoryImp.getInstance().getBufferedImage(getGrassPicture(mapSize));

	    ImageIcon imageIcon = getImage(player, mapSize);

	    lblImage.setIcon(imageIcon);
		EBORDER borderType = getBorderType(mapSize, position);
		createBorder(borderType);
		repaint();
    }

    private ImageIcon getImage(APlayer player, int mapSize) {
	    if (player != null)
	        return ImageRepositoryImp.getInstance().getImageIcon(
	                player.getPicture(),
                    lblImage.getPreferredSize()
        );

	    String grassPicture = getGrassPicture(mapSize);
        return null;
	}

    private String getGrassPicture(int mapSize) {
        Random random = new Random();
        return random.nextBoolean() ? "lightgrass" : "darkgrass";
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
                        BorderFactory.createMatteBorder(BORDER_SIZE,0,0,0,BORDER_COLOR),
		                BorderFactory.createMatteBorder(0,1,1,1, GameConstants.Colors.LIGHT_SHADE)
                ));
                break;
            case RIGHTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(BORDER_SIZE,0,0,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(0,1,1,0, GameConstants.Colors.LIGHT_SHADE)));
                break;
            case LEFT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,BORDER_SIZE,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,0,1,1, GameConstants.Colors.LIGHT_SHADE)));
                break;
            case RIGHT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,1,0, GameConstants.Colors.LIGHT_SHADE)));
                break;
            case BOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,BORDER_SIZE,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,0,1, GameConstants.Colors.LIGHT_SHADE)));
                break;
            case LEFTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,BORDER_SIZE,BORDER_SIZE,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,0,0,1, GameConstants.Colors.LIGHT_SHADE)));
  
                break;
            case LEFTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(BORDER_SIZE,BORDER_SIZE,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(0,0,1,1, GameConstants.Colors.LIGHT_SHADE)));
         
                break;
            case RIGHTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,BORDER_SIZE,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,0,0, GameConstants.Colors.LIGHT_SHADE)));
           
                break;
            case NONE:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,1,1, GameConstants.Colors.LIGHT_SHADE)
	            ));
                break;
        }
    }
}
