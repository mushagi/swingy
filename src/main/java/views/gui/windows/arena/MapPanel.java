package views.gui.windows.arena;

import models.players.APlayer;
import models.world.Arena;
import models.world.Position;

import javax.swing.*;
import java.awt.*;

import static state.GameConstants.MAX_RENDERING_MAPSIZE;

class MapPanel extends JPanel {

    MapPanel() {
    }

    void generateNewMap(int mapSize) {
        int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
        this.setLayout(new GridLayout(maxMapSize, maxMapSize));
        for (int y = 0; y < maxMapSize; y++) {
            for (int x = 0; x < maxMapSize; x++) {
                MapCell mapCell = new MapCell();
                this.add(mapCell);
            }
        }
	
	    maxMapSize = 1;
    }

    void updateMap(Arena arena) {
        int mapSize = arena.getMap().getSize();
        int renderMapSize = Math.min(arena.getMap().getSize(), MAX_RENDERING_MAPSIZE);
        int xStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().x, mapSize, renderMapSize);
        int xEndRenderingPos = getEndingRenderingPositionValue(xStartRenderingPos, arena.getMap().getSize(), renderMapSize);
        int yStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().y, mapSize, renderMapSize);
        int yEndRenderingPos = getEndingRenderingPositionValue(yStartRenderingPos, mapSize, renderMapSize);
        
        int count = 0;
        for (int y = yStartRenderingPos; y < yEndRenderingPos; y++) {
            for (int x = xStartRenderingPos; x < xEndRenderingPos; x++) {
                if (this.getComponentCount() > 0) {
                    Position position = new Position(y, x);
	                APlayer player = arena.getMap().getGameMap().get(position);
	                MapCell mapCell = (MapCell) this.getComponent(count++);
                    if (arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition()))
                        mapCell.setValues("*", position, mapSize, player);
                    else if (arena.getMap().getGameMap().containsKey(position)) {
                        mapCell.setValues(player.getType().equals("Hero") ? "0" : "X", position, mapSize, player);
                    }
                    else
                        mapCell.setValues("", position, mapSize, player);
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



