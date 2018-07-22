package models.messages;

import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class GameErrorMessage {
    String errorMessage;
    boolean hasError;

    public GameErrorMessage() {
        errorMessage = "";
    }
}
