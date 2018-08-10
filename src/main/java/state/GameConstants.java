package state;

import models.players.APlayer;

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
	
	public static final Font MONO_FONT = new Font("Monospaced", Font.PLAIN, 14); ;
}