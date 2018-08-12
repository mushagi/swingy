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
                        mapCell.setValues("*");
                    else if (arena.getMap().getGameMap().containsKey(position)) {
                        APlayer player = arena.getMap().getGameMap().get(position);
                        mapCell.setValues(player.getType().equals("Hero") ? "0" : "X");
                    }
                    else
                        mapCell.setValues("");

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
	    this.setBorder(BorderFactory.createEtchedBorder(GameConstants.Colors.LIGHTER_BLUE, GameConstants.Colors.DARKEST_GRAY));
	    Font font = new Font("monospaced", Font.BOLD, mapSize*5);
	    this.label.setFont(font);
        this.add(label);
    }
    void setValues(String text) {
        label.setText(text);
}
}
