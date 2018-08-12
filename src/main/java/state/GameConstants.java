package state;

import java.awt.*;

public class GameConstants {
	public static final int MAX_RENDERING_MAPSIZE = 9;
    public static final String APPLICATION_HEARDER = "Swingy in Wakanda";
    public static final String APPLICATION_SLOGAN = "The battle for the vibranium";
    public static final String START_DIVIDER = "**************************************" +
            "******************************************" +
            "********************";

    public static final String ILLEGAL_MOVE_BATTLE_IN_PROGRESS = "Cannot move while player is in a battle";
    public static final String ILLEGAL_ATTACK_NO_ENEMY = "Cannot attack while there is no enemy.";
    public static final String RUN_AWAY_SUCCESS_MESSAGE = "Run away a success.";
    public static final String RUN_AWAY_FAILURE_MESSAGE = "Run away was not possible. Fight to the death";
    public static final String ENEMY_COLLISION_MESSAGE = "You encountered an enemy. \nFight or run away";
    public static final String MISSION_ACCOMPLISHED_MESSAGE = "Hero reached Destination. Mission accomplished";
    
    public static final Font MONO_FONT = new Font("Monospaced", Font.PLAIN, 14);
    
	public static class Colors {
		public static final Color LIGHTER_BLUE = new Color(0, 56, 168);
		public static final Color TRANSPARENT = new Color(0,0,0,0);
		public static final Color DEFAULT_FONT = Color.WHITE;
		public static Color BLUE = new Color(0, 0, 255);
		public static final Color DARKEST_GRAY = new Color(18, 18, 18);
		public static final Color LIGHTER_GRAY = new Color(29, 29, 29);
		public static final Color LIGHTERST__GRAY = new Color(40, 40, 40);
	}
}