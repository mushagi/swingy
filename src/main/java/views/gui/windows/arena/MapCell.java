package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Position;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MapCell extends JPanel {
	public static final int MAP_CELL_MIN_HEIGHT = 45;
	public static final int MAP_CELL_MIN_WIDTH = 45;
	public static final int MAP_CELL_MAX_HEIGHT = 85;
	public static final int MAP_CELL_MAX_WIDTH = 85;
    private static final Color BORDER_COLOR = new Color(119, 16, 61);
    private static final int BORDER_SIZE = 5;
    
    private ImagePanel imagePanel = new ImagePanel();
    APlayer player;
	
	MapCell(int mapSize) {
		setBackground(GameConstants.Colors.LIGHTER);
		
		GridBagLayout layout = new GridBagLayout();
    	setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		layout.setConstraints(imagePanel, constraints);
		
		add(imagePanel);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		imagePanel.setImage(player);
	}
	
	
	void setValues(Position position, int mapSize, APlayer player) {
		this.player = player;
		imagePanel.setImage(player);
		this.getParent().repaint();
		this.repaint();
		//createBorder(position, mapSize);
    }
    


    private BufferedImage getImage(APlayer player, int mapSize) {
	    if (player != null)
	        return ImageRepositoryImp.getInstance().getBufferedImage(player.getPicture());
	    String grassPicture = getGrassPicture(mapSize);
        return null;
	}

    private String getGrassPicture(int mapSize) {
        Random random = new Random();
        return random.nextBoolean() ? "lightgrass" : "darkgrass";
    }

    private void createBorder(Position position, int size) {
        size--;
        if (position.x != 0 && position.y != 0) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,0,0,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,1,1,1, GameConstants.Colors.LIGHT_SHADE)
	        ));
        }
        else if (position.x == 0 && position.y == 0) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(BORDER_SIZE,BORDER_SIZE,0,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(0,0,1,1, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.x == size && position.y == 0) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(BORDER_SIZE,0,0,BORDER_SIZE,BORDER_COLOR),
			        BorderFactory.createMatteBorder(0,1,1,0, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.x == 0 && position.y == size)
        {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,BORDER_SIZE,BORDER_SIZE,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,0,0,1, GameConstants.Colors.LIGHT_SHADE)));
	
        }
        else if (position.x == size && position.y == size) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,0,BORDER_SIZE,BORDER_SIZE,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,1,0,0, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.x == 0) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,BORDER_SIZE,0,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,0,1,1, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.x == size) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,0,0,BORDER_SIZE,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,1,1,0, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.y == size) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(0,0,BORDER_SIZE,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(1,1,0,1, GameConstants.Colors.LIGHT_SHADE)));
        }
        else if (position.y == 0) {
	        setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createMatteBorder(BORDER_SIZE,0,0,0,BORDER_COLOR),
			        BorderFactory.createMatteBorder(0,1,1,1, GameConstants.Colors.LIGHT_SHADE)
	        ));
        }
    
    }
}

class ImagePanel extends JPanel {
	BufferedImage image;
	
	public ImagePanel() {
		this.setBackground(GameConstants.Colors.TRANSPARENT);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.setSize(this.getParent().getSize());
		this.setPreferredSize(this.getParent().getSize());
		
		super.paintComponent(g);
		if ( image != null )
			g.drawImage(image, 0, 0, this.getPreferredSize().width, this.getPreferredSize().height, this);
	}
	
	void setImage(APlayer player) {
		if ( player != null )
			image = ImageRepositoryImp.getInstance().getBufferedImage(player.getPicture());
		else
			image = null;
		this.repaint();
	}
}