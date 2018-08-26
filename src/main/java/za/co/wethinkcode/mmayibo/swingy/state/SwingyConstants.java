package za.co.wethinkcode.mmayibo.swingy.state;

import java.awt.*;

public class SwingyConstants {
	public static final int MAX_RENDERING_MAPSIZE = 9;
    public static final String APPLICATION_HEARDER = "Swingy in Wakanda";
    public static final String APPLICATION_SLOGAN = "The battle for the vibranium";
    public static final String START_DIVIDER = "**************************************" +
            "******************************************" +
            "********************";

    public static final String ILLEGAL_MOVE_BATTLE_IN_PROGRESS = "Cannot move while player is in a battle\nFight or run away";
    public static final String ILLEGAL_ATTACK_NO_ENEMY = "Cannot attack while there is no enemy";
    public static final String RUN_AWAY_SUCCESS_MESSAGE = "Run away a success";
    public static final String RUN_AWAY_FAILURE_MESSAGE = "Run away was not possible. Fight to the death";
    public static final String ENEMY_COLLISION_MESSAGE = "You encountered an enemy. \nFight or run away";
    public static final String MISSION_ACCOMPLISHED_MESSAGE = "Hero reached Destination. Mission accomplished";
    
    public static final Font MONO_FONT = new Font("Monospaced", Font.PLAIN, 14);
	public static final Font MONO_FONT_BOLD = new Font("Monospaced", Font.BOLD, 15);
	
	
	public static class Colors {
		public static final Color LIGHT_SHADE = new Color(100, 96, 182);
		public static final Color TRANSPARENT = new Color(0,0,0,0);
		public static final Color DEFAULT_FONT = Color.WHITE;
		public static final Color REDDISH = new Color(119, 16, 61);
		public static final Color BRIGHTEST = new Color(112, 33, 185);
		public static final Color BRIGHTERSHADE = new Color(0, 68, 255) ;
		public static Color BRIGHTER = new Color(28, 26, 61);
		public static final Color DARKEST = new Color(4, 4, 14);
		public static final Color LIGHTER = new Color(16, 16, 32);
		public static final Color LIGHTEST = new Color(23, 23, 35);
	}
	public class ConsoleColors {
		// Reset
		public static final String RESET = "\033[0m";  // Text Reset
		
		// Regular Colors
		public static final String BLACK = "\033[0;30m";   // BLACK
		public static final String RED = "\033[0;31m";     // RED
		public static final String GREEN = "\033[0;32m";   // GREEN
		public static final String YELLOW = "\033[0;33m";  // YELLOW
		public static final String BLUE = "\033[0;34m";    // BLUE
		public static final String PURPLE = "\033[0;35m";  // PURPLE
		public static final String CYAN = "\033[0;36m";    // CYAN
		public static final String WHITE = "\033[0;37m";   // WHITE
		
		// Bold
		public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
		public static final String RED_BOLD = "\033[1;31m";    // RED
		public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
		public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
		public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
		public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
		public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
		public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
		
		// Underline
		public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
		public static final String RED_UNDERLINED = "\033[4;31m";    // RED
		public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
		public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
		public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
		public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
		public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
		public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
		
		// Background
		public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
		public static final String RED_BACKGROUND = "\033[41m";    // RED
		public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
		public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
		public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
		public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
		public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
		public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
		
		// High Intensity
		public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
		public static final String RED_BRIGHT = "\033[0;91m";    // RED
		public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
		public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
		public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
		public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
		public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
		public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
		
		// Bold High Intensity
		public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
		public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
		public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
		public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
		public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
		public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
		public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
		public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
		
		// High Intensity backgrounds
		public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
		public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
		public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
		public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
		public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
		public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
		public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
		public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
	}
}