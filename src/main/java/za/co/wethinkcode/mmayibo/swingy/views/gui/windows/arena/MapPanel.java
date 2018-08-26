package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena;

import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;
import za.co.wethinkcode.mmayibo.swingy.views.AbstractMapView;

import java.awt.*;

import static za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants.MAX_RENDERING_MAPSIZE;

public class MapPanel extends AbstractMapView {

    MapPanel() {
        setBackground(SwingyConstants.Colors.DARKEST);

    }

    @Override
    public void generateNewMap(int mapSize) {
        int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
        this.setLayout(new GridLayout(maxMapSize, maxMapSize));
        for (int y = 0; y < maxMapSize; y++) {
            for (int x = 0; x < maxMapSize; x++) {
                MapCell mapCell = new MapCell(mapSize);
                this.add(mapCell);
            }
        }
    }
    
    @Override
    protected void updateMapCell(int mapSize, int count, Position position, PositionValue positionValue, boolean isCellInBattle) {
        MapCell mapCell = (MapCell) this.getComponent(count);
        mapCell.updateValues(position, mapSize, positionValue, isCellInBattle);
        
    }
    
    
}



