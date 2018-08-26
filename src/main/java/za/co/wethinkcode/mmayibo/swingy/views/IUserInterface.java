package za.co.wethinkcode.mmayibo.swingy.views;

import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;

public interface IUserInterface {
    void updateUserInterface(Arena arena);
    void showSplashScreen();
    void showQuitDialogue();
}