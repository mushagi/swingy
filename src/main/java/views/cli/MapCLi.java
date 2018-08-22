package views.cli;

import lombok.Setter;
import models.players.APlayer;
import models.world.Position;
import views.gui.custom.AbstractMapView;

import java.util.Iterator;

import static state.SwingyConstants.MAX_RENDERING_MAPSIZE;

public class MapCLi extends AbstractMapView {
	@Setter
	Iterator<String> sideIterator;
	CliMapCell mapCell = new CliMapCell();
	
	@Override
	public void generateNewMap(int mapSize) {
	
	}
	
	@Override
	protected void updateMapCell(int mapSize, int count, Position position, APlayer player, boolean isCellInBattle) {
		count++;
		int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
		
		if (count == 1 && position.x == 0)
		{
			printHorizontalBorder(maxMapSize, position.x, mapSize);
			if (position.x + maxMapSize >= mapSize)
				System.out.print("***");
			System.out.println();
		}
		
		
		if (position.x == 0)
			System.out.print("*  ");

		mapCell.updateValues(position, mapSize, player, isCellInBattle );
		
		if (position.x == mapSize - 1)
			System.out.print("*");
		
		if (count % maxMapSize == 0) {
			String sideText = sideIterator != null && sideIterator.hasNext() ? sideIterator.next() : "";
			System.out.println(sideText);
		}
		if (count == maxMapSize * maxMapSize && position.x == mapSize - 1){
			printHorizontalBorder(maxMapSize, position.x, mapSize);
  			if (position.x + maxMapSize >= mapSize)
				System.out.print("***");
			System.out.println();
		}
	}

    private void printVerticalBorder() {
		
    }

    private void printHorizontalBorder(int renderMapSize, int positionValue, int mapSize) {
		
	    for (int x = 0; x < renderMapSize; x++) {
	        System.out.print("***");
	    }

	    System.out.print("*");

    }

    void finishUpSideIterator() {
		
		//while (sideIterator.hasNext())
			//System.out.println(sideIterator.next() + "\n");
	}
}
