package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Position;
import state.SwingyConstants;
import utils.ImageRepositoryImp;
import views.gui.custom.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MapCell extends AbstractMapCell {
	public static final int MAP_CELL_MIN_HEIGHT = 45;
	public static final int MAP_CELL_MIN_WIDTH = 45;
	public static final int MAP_CELL_MAX_HEIGHT = 85;
	public static final int MAP_CELL_MAX_WIDTH = 85;
    private static final Color BORDER_COLOR = SwingyConstants.Colors.REDDISH;
    private static final int BORDER_SIZE = 5;
    
    private ImagePanel imagePanel = new ImagePanel();
	
	MapCell(int mapSize) {
		setBackground(SwingyConstants.Colors.LIGHTER);
		
		BorderLayout layout = new BorderLayout();
    	setLayout(layout);
    	imagePanel.setPreferredSize(new Dimension(200,200));
		add(imagePanel, BorderLayout.CENTER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
	@Override
	public void updateValues(Position position, int mapSize, APlayer player, boolean isCellInBattle) {
		this.player = player;
		if (isCellInBattle)
			imagePanel.changeImage(ImageRepositoryImp.getInstance().getBufferedImage("danger"));
		else
			imagePanel.changeImage(player);
		imagePanel.revalidate();
		imagePanel.repaint();
		EBORDER eborder = getBorderType(mapSize, position);
        createBorder(eborder);
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
	
	@Override
	protected void createBorder(EBORDER eborder) {
        switch (eborder)
        {
            case TOP:
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(BORDER_SIZE,0,0,0,BORDER_COLOR),
		                BorderFactory.createMatteBorder(0,1,1,1, SwingyConstants.Colors.LIGHT_SHADE)
                ));
                break;
            case RIGHTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(BORDER_SIZE,0,0,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(0,1,1,0, SwingyConstants.Colors.LIGHT_SHADE)));
                break;
            case LEFT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,BORDER_SIZE,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,0,1,1, SwingyConstants.Colors.LIGHT_SHADE)));
                break;
            case RIGHT:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,1,0, SwingyConstants.Colors.LIGHT_SHADE)));
                break;
            case BOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,BORDER_SIZE,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,0,1, SwingyConstants.Colors.LIGHT_SHADE)));
                break;
            case LEFTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,BORDER_SIZE,BORDER_SIZE,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,0,0,1, SwingyConstants.Colors.LIGHT_SHADE)));
  
                break;
            case LEFTTOP:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(BORDER_SIZE,BORDER_SIZE,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(0,0,1,1, SwingyConstants.Colors.LIGHT_SHADE)));
         
                break;
            case RIGHTBOTTOM:
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,BORDER_SIZE,BORDER_SIZE,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,0,0, SwingyConstants.Colors.LIGHT_SHADE)));
           
                break;
            default :
	            setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createMatteBorder(0,0,0,0,BORDER_COLOR),
			            BorderFactory.createMatteBorder(1,1,1,1, SwingyConstants.Colors.LIGHT_SHADE)
	            ));
                break;
        }
    
    }
}

