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
		
		if (count % maxMapSize == 0 && count != 0) {
			System.out.print("| ");
			System.out.println(sideText);
		}
		mapCell.updateValues(position, mapSize, player, isCellInBattle );
	}
	
	void finishUpSideIterator() {
		
		//while (sideIterator.hasNext())
			//System.out.println(sideIterator.next() + "\n");
	}
}
