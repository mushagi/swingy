package controllers.models;

import lombok.Getter;
import lombok.Setter;
import models.players.APlayer;

import java.util.ArrayList;

@Getter @Setter
public class BattleReport {
	boolean heroIsFirstAttacker;
	APlayer winner;
	APlayer loser;
	boolean isHeroWinner;
	
	ArrayList<String> battleSimulation;
	public BattleReport() {
		battleSimulation = new ArrayList<>();
		this.heroIsFirstAttacker = false;
		this.isHeroWinner = false;
	}
}
