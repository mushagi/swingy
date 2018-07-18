package models;

import lombok.Getter;
import lombok.Setter;
import models.players.Player;

import java.util.ArrayList;

@Setter @Getter
public class BattleResults {
    Player playerWon;
    Player playerLost;
    ArrayList<String> battleSimulation;
}
