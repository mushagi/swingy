package za.co.wethinkcode.mmayibo.swingy.views.cli;

import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.models.world.Position;
import za.co.wethinkcode.mmayibo.swingy.models.world.PositionValue;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena.AbstractMapCell;

public class CliMapCell extends AbstractMapCell {
	
	@Override
	public void updateValues(Position position, int mapSize, PositionValue positionValue, boolean isCellInBattle) {
		AbstractPlayer player = null;
		if (positionValue != null)
			player = positionValue.getOccupier();
		if (positionValue == null )
			System.out.print(".  ");
		else if ( isCellInBattle )
			System.out.print("^  ");
		else if (player != null && player.getType().equals("Hero") && !positionValue.getDroppedArtificats().isEmpty())
			System.out.print("0$ ");
		else if (!positionValue.getDroppedArtificats().isEmpty())
			System.out.print("$  ");
		else
			System.out.print(player.getType().equals("Hero") ? "0  " : "X  ");

	}
	
	@Override
	protected void createBorder(EBORDER eborder) {
	
	}
}

