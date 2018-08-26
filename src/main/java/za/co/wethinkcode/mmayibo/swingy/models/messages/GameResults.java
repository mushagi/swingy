package za.co.wethinkcode.mmayibo.swingy.models.messages;

import za.co.wethinkcode.mmayibo.swingy.controllers.models.BattleReport;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;

import java.util.ArrayList;

@Setter @Getter
public class    GameResults {
    ArrayList<String> result;
    BattleReport battleReport;
    AbstractPlayer heroBeforeGame;
    AbstractPlayer enemyWon;
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