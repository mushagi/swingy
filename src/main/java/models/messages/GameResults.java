package models.messages;

import lombok.Getter;
import lombok.Setter;
import models.players.APlayer;
import models.players.Enemy;

import java.util.ArrayList;

@Setter @Getter
public class GameResults {
    ArrayList<String> result;
    APlayer enemyWon;
    boolean heroWon;
    boolean isError;

    public GameResults() {
        this.result = new ArrayList<>();
        this.heroWon = false;
        this.isError = false;
        enemyWon = null;
    }

    public void clear()
    {
        result.clear();
        heroWon = false;
        isError = false;
        enemyWon = null;
    }
}