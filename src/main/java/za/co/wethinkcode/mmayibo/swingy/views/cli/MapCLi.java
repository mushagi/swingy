package za.co.wethinkcode.mmayibo.swingy.views.cli;

import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;
import za.co.wethinkcode.mmayibo.swingy.views.AbstractMapView;

import java.util.Iterator;

import static za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants.MAX_RENDERING_MAPSIZE;

public class MapCLi extends AbstractMapView {
	@Setter
	Iterator<String> sideIterator;
	private final CliMapCell mapCell = new CliMapCell();
	private final String borderChar = SwingyConstants.ConsoleColors.PURPLE_BOLD + "*" + SwingyConstants.ConsoleColors.RESET;
	private final String borderSpaceChar = borderChar + "  ";
	private final String multipleBorderChar = borderChar + borderChar + borderChar;
	private static int wideCount = 0;
	@Override
	public void generateNewMap(int mapSize) {
	
	}
	
	@Override
	protected void updateMapCell(int mapSize, int count, Position position, PositionValue positionValue, boolean isCellInBattle) {
		count++;
		int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
		
		if (count == 1 && position.y == 0)
			printTopHorizontalBorder(maxMapSize, position, mapSize);
		
		System.out.print(position.x == 0 ? borderSpaceChar : "");
		mapCell.updateValues(position, mapSize, positionValue, isCellInBattle );
		System.out.print(position.x == mapSize - 1 ? borderSpaceChar : "");
		
		if (count % maxMapSize == 0) {
			String sideText = sideIterator != null && sideIterator.hasNext() ?  "\t" + sideIterator.next(): "";
			System.out.println(sideText);
		}
		
		if (count == maxMapSize * maxMapSize && position.y == mapSize - 1)
			printBottomHorizontalBorder(maxMapSize, position, mapSize);
	}
	
	private void printBottomHorizontalBorder(int renderMapSize, Position position, int mapSize) {
		if (position.x - (renderMapSize - 1) == 0 && position.x == mapSize - 1)
			renderMapSize++;
		else if (position.x - (renderMapSize - 1) > 0 && position.x != mapSize - 1)
			renderMapSize--;
		
		for (int x = 0; x < renderMapSize; x++) {
			System.out.print(multipleBorderChar);
		}
		wideCount = (renderMapSize * 3) + 1;
		System.out.println(borderChar);
	}
    private void printTopHorizontalBorder(int renderMapSize, Position position, int mapSize) {
	    if (position.x == 0 && position.x + renderMapSize == mapSize)
		    renderMapSize++;
	    else if (position.x != 0 && position.x + renderMapSize != mapSize)
		    renderMapSize--;
	    
	    for (int x = 0; x < renderMapSize; x++) {
	        System.out.print(multipleBorderChar);
	    }
	    System.out.println(borderChar);
    }

    void finishUpSideIterator() {
		while (sideIterator.hasNext()){
			for (int x = 0; x < wideCount; x++) {
				System.out.print(" ");
			}
			
			System.out.println("\t\t"+sideIterator.next() + "\n");
		}
	}
	
}
