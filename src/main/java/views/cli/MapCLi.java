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
		int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE)  ;
		String sideText = sideIterator.hasNext() ? sideIterator.next() : "";
		if (count == 0){
            printHorizontalBorder(mapSize);
            printVerticalBorder();
        }
		if (count % maxMapSize == 0 && count != 0) {
			System.out.print("  ");
			System.out.println(sideText);
            printVerticalBorder();

        }
        mapCell.updateValues(position, mapSize, player, isCellInBattle );

        if (count == (mapSize * mapSize) - 1)
            printHorizontalBorder(mapSize);
	}

    private void printVerticalBorder() {
	    if
        System.out.print("*");
    }

    private void printHorizontalBorder(int mapSize) {
        System.out.println();
	    for (int x = 0; x <= mapSize; x++) {
	        System.out.print("**");
	    }
	    System.out.println();
    }

    void finishUpSideIterator() {
		
		//while (sideIterator.hasNext())
			//System.out.println(sideIterator.next() + "\n");
	}
}
