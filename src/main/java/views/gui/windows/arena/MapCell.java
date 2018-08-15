package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Position;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapCell extends JPanel {
	
    private final JLabel label = new JLabel();
	private final JLabel lblImage = new JLabel();
	
	public MapCell(int mapSize) {
    	GridBagLayout layout = new GridBagLayout();
    	setLayout(layout);

    	this.setBackground(GameConstants.Colors.LIGHTER_GRAY);
        label.setForeground(GameConstants.Colors.DEFAULT_FONT);
        
	    Font font = new Font("monospaced", Font.BOLD, 9);
	    
	    this.label.setFont(font);
	    
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		layout.setConstraints(lblImage, constraints);
		add(lblImage);
        lblImage.setPreferredSize(mapSize < 9 ? new Dimension(85,85) : new Dimension(45,45));
	}
	
	public void setValues(String text, Position position, int mapSize, APlayer player) {
		if (player != null) {
            ImageIcon imageIcon = ImageRepositoryImp.getImageIcon(getClass().getResource("/images/blackpanther.jpg").getPath(), lblImage.getPreferredSize());
            lblImage.setIcon(imageIcon);
		}
		else
		{
			lblImage.setIcon(null);
		}

		EBORDER borderType = getBorderType(mapSize, position);
        createBorder(borderType);
        label.setText(text + " ");

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
	private final SwingWorker<Integer, ImageIcon> swingWorker = new SwingWorker<Integer, ImageIcon>() {
		@Override
		protected Integer doInBackground() {
			ImageIcon imageIcon = ImageRepositoryImp.getImageIcon(getClass().getResource("/images/blackpanther.jpg").getPath(), lblImage.getPreferredSize());
			publish(imageIcon);
			return 0;
		}
		
		@Override
		protected void process(List<ImageIcon> chunks) {
			for (ImageIcon imageIcon: chunks) {
				lblImage.setIcon(imageIcon);
			}
		}
		
		@Override
		protected void done() {

		}
	};
	
	
}
