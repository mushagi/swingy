package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena;

import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;

import javax.swing.*;

public abstract class AbstractMapCell extends JPanel {
	AbstractPlayer player;
	
	public abstract void updateValues(Position position, int mapSize, PositionValue positionValue, boolean isCellInBattle);
	
	public EBORDER getBorderType(int size, Position position) {
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
	
	protected abstract void createBorder(EBORDER eborder);
	
	protected enum EBORDER {
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
}
