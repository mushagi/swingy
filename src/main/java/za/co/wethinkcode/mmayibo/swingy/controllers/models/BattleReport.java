package za.co.wethinkcode.mmayibo.swingy.controllers.models;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;

import java.util.ArrayList;

@Getter @Setter
public class BattleReport {
	boolean heroIsFirstAttacker;
	AbstractPlayer winner;
	AbstractPlayer loser;
	boolean isHeroWinner;
	
	ArrayList<String> battleSimulation;
	public BattleReport() {
		battleSimulation = new ArrayList<>();
		this.heroIsFirstAttacker = false;
		this.isHeroWinner = false;
	}
}
