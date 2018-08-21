package views.cli;

import models.players.APlayer;
import models.world.Position;
import views.gui.windows.arena.AbstractMapCell;

public class CliMapCell extends AbstractMapCell {
	
	@Override
	public void updateValues(Position position, int mapSize, APlayer player, boolean isCellInBattle) {
		if ( player == null )
			System.out.print("| ");
		else if ( isCellInBattle )
			System.out.print("|*");
		else
			System.out.print(player.getType().equals("Hero") ? "|0" : "|X");
	}
	
	@Override
	protected void createBorder(EBORDER eborder) {
		switch (eborder) {
			case TOP:
				
				break;
			case RIGHTTOP:
				break;
			case LEFT:
				
				break;
			case RIGHT:
				break;
			case BOTTOM:
				break;
			case LEFTBOTTOM:
				
				break;
			case LEFTTOP:
				
				break;
			case RIGHTBOTTOM:
				
				break;
			default:
				
				break;
		}
	}
}

