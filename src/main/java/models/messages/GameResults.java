package models.messages;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter @Getter
public class GameResults {
    ArrayList<String> result;
    boolean heroWon;
    boolean isError;

    public GameResults(ArrayList<String>  result, boolean heroWon, boolean isError) {
        this.result = result;
        this.heroWon = heroWon;
        this.isError = isError;
    }

    public void clear()
    {
        result.clear();
        heroWon = false;
        isError = false;
    }
}