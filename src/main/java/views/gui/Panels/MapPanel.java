package views.gui.Panels;

import models.players.APlayer;
import models.world.Arena;
import models.world.Position;

import javax.swing.*;
import java.awt.*;

class MapPanel extends JPanel {

    public MapPanel() {

    }

    public void generateNewMap(int mapSize) {
        this.setLayout(new GridLayout(0, mapSize));
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                MapCell mapCell = new MapCell();
                this.add(mapCell);
            }
        }
    }

    public void updateMap(Arena arena) {
        int count = 0;
        for (int y = 0; y < arena.getMap().getSize(); y++) {
            for (int x = 0; x < arena.getMap().getSize(); x++) {
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
}

class MapCell extends JPanel {
    private final JLabel label = new JLabel();
    public MapCell() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.add(label);
    }

    void setValues(String text) {
        label.setText(text);
}
}
