package za.co.wethinkcode.mmayibo.swingy.views;

import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;

import javax.swing.*;

import static za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants.MAX_RENDERING_MAPSIZE;

public abstract class AbstractMapView extends JPanel {
	public abstract void generateNewMap(int mapSize);
	
	public void updateMap(Arena arena) {
	    int mapSize = arena.getMap().getSize();
	    int renderMapSize = Math.min(arena.getMap().getSize(), MAX_RENDERING_MAPSIZE);
	    
	    int xStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().x, mapSize, renderMapSize);
	    int xEndRenderingPos = getEndingRenderingPositionValue(xStartRenderingPos, arena.getMap().getSize(), renderMapSize);
	    int yStartRenderingPos = getStartingRenderingPositionValue(arena.getHero().getPosition().y, mapSize, renderMapSize);
	    int yEndRenderingPos = getEndingRenderingPositionValue(yStartRenderingPos, mapSize, renderMapSize);
	    
	    int count = 0;
	    Position position = new Position();
	    for (int y = yStartRenderingPos; y < yEndRenderingPos; y++) {
	        for (int x = xStartRenderingPos; x < xEndRenderingPos; x++) {
	            position.x = x;
	            position.y = y;
	            
	            PositionValue positionValue = arena.getMap().getGameMap().get(position);
		        boolean isCellInBattle = arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition());
	            updateMapCell(mapSize, count, position, positionValue, isCellInBattle);
	            count++;
	        }
	    }
	}
	
	protected abstract void updateMapCell(int mapSize, int count, Position position, PositionValue positionValue, boolean isCellInBattle);
	
	private int getStartingRenderingPositionValue(int positionValue, int realMapSize, int renderMapSize) {
	    int startingRenderingPosition = positionValue - (renderMapSize / 2);
	    startingRenderingPosition = startingRenderingPosition < 0 ? 0 : startingRenderingPosition;
	    
	    if (startingRenderingPosition + renderMapSize > realMapSize)
	        startingRenderingPosition = realMapSize - renderMapSize;
	    
	    return startingRenderingPosition;
	}
	
	private int getEndingRenderingPositionValue(int positionValue, int realMapSize, int renderMapSize) {
	    int endingRenderingPosition = positionValue + renderMapSize;
	    
	    if (endingRenderingPosition > realMapSize)
	        endingRenderingPosition = realMapSize;
	    return endingRenderingPosition;
	}
}
