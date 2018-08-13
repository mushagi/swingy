package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Arena;
import models.world.Position;
import state.GameConstants;

import javax.swing.*;
import java.awt.*;

import static state.GameConstants.MAX_RENDERING_MAPSIZE;

class MapPanel extends JPanel {

    MapPanel() {
        setBackground(GameConstants.Colors.LIGHTER_GRAY);
    }

    void generateNewMap(int mapSize) {
        int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
    
        this.setLayout(new GridLayout(maxMapSize, maxMapSize));
        for (int y = 0; y < maxMapSize; y++) {
            for (int x = 0; x < maxMapSize; x++) {
                MapCell mapCell = new MapCell(maxMapSize);
                this.add(mapCell);
            }
        }
    }

    void updateMap(Arena arena) {

        int mapSize = arena.getMap().getSize();
        int renderMaxMapSize = Math.min(arena.getMap().getSize(), MAX_RENDERING_MAPSIZE);
        
        int xStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().x, arena.getMap().getSize(), renderMaxMapSize);
        int xEndRenderingPos = getEndingRenderingPositionValue(xStartRenderingPos, arena.getMap().getSize(), renderMaxMapSize);
        
        int yStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().y, arena.getMap().getSize(), renderMaxMapSize);
        int yEndRenderingPos = getEndingRenderingPositionValue(yStartRenderingPos, arena.getMap().getSize(), renderMaxMapSize);
        
        int count = 0;
        for (int y = yStartRenderingPos; y < yEndRenderingPos; y++) {
            for (int x = xStartRenderingPos; x < xEndRenderingPos; x++) {
                if (this.getComponentCount() > 0) {
                    Position position = new Position(y, x);
                    MapCell mapCell = (MapCell) this.getComponent(count++);
                    if (arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition()))
                        mapCell.setValues("*", position, mapSize);
                    else if (arena.getMap().getGameMap().containsKey(position)) {
                        APlayer player = arena.getMap().getGameMap().get(position);
                        mapCell.setValues(player.getType().equals("Hero") ? "0" : "X", position, mapSize);
                    }
                    else
                        mapCell.setValues("", position, mapSize);

                }
            }
        }
    }



    private int getStartingRenderingPositionValue(int positionValue, int realMapSize, int renderMapSize)
    {
        int startingRenderingPosition = positionValue - (renderMapSize / 2);
        startingRenderingPosition = startingRenderingPosition < 0 ? 0 : startingRenderingPosition;
        
        if (startingRenderingPosition + renderMapSize > realMapSize)
            startingRenderingPosition = realMapSize - renderMapSize;
        
        return startingRenderingPosition;
    }
    
    private int getEndingRenderingPositionValue(int positionValue, int realMapSize, int renderMapSize)
    {
        int endingRenderingPosition = positionValue + renderMapSize;
        
        if (endingRenderingPosition > realMapSize)
            endingRenderingPosition = realMapSize;
        return endingRenderingPosition;
    }

}


class MapCell extends JPanel {
    private final JLabel label = new JLabel();
    MapCell(int mapSize) {
    	GridBagLayout layout = new GridBagLayout();
    	setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        layout.setConstraints(label, constraints);
    	this.setBackground(GameConstants.Colors.LIGHTER_GRAY);
        label.setForeground(GameConstants.Colors.DEFAULT_FONT);
	    Font font = new Font("monospaced", Font.BOLD, 9);
	    this.label.setFont(font);
        this.add(label);
    }



    void setValues(String text, Position position, int mapSize) {
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

    void createBorder(EBORDER eborder) {
        switch (eborder)
        {
            case TOP:
                setBorder(BorderFactory.createMatteBorder(10,0,0,0, Color.RED));
                break;
            case RIGHTTOP:
                setBorder(BorderFactory.createMatteBorder(10,0,0,10, Color.RED));
                break;
            case LEFT:
                setBorder(BorderFactory.createMatteBorder(0,10,0,0, Color.RED));
                break;
            case RIGHT:
                setBorder(BorderFactory.createMatteBorder(0,0,0,10, Color.RED));
                break;
            case BOTTOM:
                setBorder(BorderFactory.createMatteBorder(0,0,10,0, Color.RED));
                break;
            case LEFTBOTTOM:
                setBorder(BorderFactory.createMatteBorder(0,10,10,0, Color.RED));
                break;
            case LEFTTOP:
                setBorder(BorderFactory.createMatteBorder(10,10,0,0, Color.RED));
                break;
            case RIGHTBOTTOM:
                setBorder(BorderFactory.createMatteBorder(0,0,10,10, Color.RED));
                break;
            case NONE:
                setBorder(BorderFactory.createEtchedBorder(GameConstants.Colors.LIGHTER_BLUE, GameConstants.Colors.DARKEST_GRAY));
                break;
        }
    }
}



