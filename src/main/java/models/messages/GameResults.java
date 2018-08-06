package models.messages;

import controllers.models.BattleReport;
import lombok.Getter;
import lombok.Setter;
import models.players.APlayer;
import models.players.Enemy;

import java.util.ArrayList;

@Setter @Getter
public class    GameResults {
    ArrayList<String> result;
    BattleReport battleReport;
    APlayer enemyWon;
    boolean heroWon;
    boolean wasBattle;
    boolean isError;

    public GameResults() {
        this.result = new ArrayList<>();
        this.battleReport = new BattleReport();
        this.heroWon = false;
        this.isError = false;
        enemyWon = null;
        wasBattle = false;
    }

    public void clear()
    {
        result.clear();
        heroWon = false;
        isError = false;
        enemyWon = null;
        wasBattle = false;
        battleReport.setHeroIsFirstAttacker(false);
        battleReport.getBattleSimulation().clear();
        battleReport.setLoser(null);
        battleReport.setWinner(null);
    }
}