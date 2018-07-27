package views;

import models.world.Arena;

public interface IUserInterface {
    void updateUserInterface(Arena arena);
    void show();
    void showSplashScreen();
}