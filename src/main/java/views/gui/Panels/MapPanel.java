package views.gui.Panels;

import models.players.APlayer;
import models.world.Arena;
import models.world.Position;
import state.GameColors;

import javax.swing.*;
import java.awt.*;

import static state.GameConstants.MAX_RENDERING_MAPSIZE;

class MapPanel extends JPanel {

    public MapPanel() {
        setBackground(GameColors.LIGHTER_GRAY);
    }

    public void generateNewMap(int mapSize) {
        int maxMapSize = Math.min(mapSize, MAX_RENDERING_MAPSIZE);
    
        this.setLayout(new GridLayout(maxMapSize, maxMapSize));
        for (int y = 0; y < maxMapSize; y++) {
            for (int x = 0; x < maxMapSize; x++) {
                MapCell mapCell = new MapCell(maxMapSize);
                this.add(mapCell);
            }
        }
    }

    public void updateMap(Arena arena) {
        
        int maxMapSize = Math.min(arena.getMap().getSize(), MAX_RENDERING_MAPSIZE);
    
        int xPossibleStartingPosLeft = arena.getHero().getPosition().x - (maxMapSize / 2);
        int xStartPos = xPossibleStartingPosLeft < 0? 0: xPossibleStartingPosLeft;
        
        int xPossibleStartingPosRight = arena.getHero().getPosition().x - (maxMapSize / 2);
        int xEndPos = xPossibleStartingPosLeft > arena.getMap().getSize() ? maxMapSize: xPossibleStartingPosLeft;
    
    
        int count = 0;
        for (int y = 0; y < maxMapSize; y++) {
            for (int x = xStartPos; x < xEndPos; x++) {
                if (this.getComponentCount() > 0) {
                    Position position = new Position(y, x);
                    MapCell mapCell = (MapCell) this.getComponent(count++);
                    if (arena.isPlayerInABattle() && position.equals(arena.getHero().getPosition()))
                        mapCell.setValues("*"+ position.toString());
                    else if (arena.getMap().getGameMap().containsKey(position)) {
                        APlayer player = arena.getMap().getGameMap().get(position);
                        mapCell.setValues(player.getType().equals("Hero") ? "0" : "X" + " " + position.toString());
                    }
                    else
                        mapCell.setValues(""+ position.toString());

                }
            }
        }
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
    	this.setBackground(GameColors.LIGHTER_GRAY);
        label.setForeground(GameColors.DEFAULT_FONT);
	    this.setBorder(BorderFactory.createEtchedBorder(GameColors.LIGHTER_BLUE, GameColors.DARKEST_GRAY));
	    Font font = new Font("monospaced", Font.BOLD, mapSize*5);
	    this.label.setFont(font);
        this.add(label);
    }
    void setValues(String text) {
        label.setText(text);
}
}
