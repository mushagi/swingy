package za.co.wethinkcode.mmayibo.swingy.models.world;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;

import java.util.ArrayList;

@Getter @Setter
public class PositionValue {
	AbstractPlayer occupier = null;
	ArrayList<Artifact> droppedArtificats = new ArrayList<>();
}
