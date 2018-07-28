package views;

import models.world.Arena;

public interface IUserInterface {
    void updateUserInterface(Arena arena);
    void show(Arena arena);
    void showSplashScreen();

    void showQuitDialogue();

    void newGameDialogue();
}