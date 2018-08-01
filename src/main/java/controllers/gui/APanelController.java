package controllers.gui;

public abstract class APanelController {
    GUIController guiController;

    APanelController(GUIController guiController) {
        this.guiController = guiController;
        addAllListeners();
    }

    abstract void addAllListeners();
    abstract void updatePanel();
}
