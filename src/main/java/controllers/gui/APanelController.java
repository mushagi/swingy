package controllers.gui;

abstract class APanelController {
    final GUIController guiController;

    APanelController(GUIController guiController) {
        this.guiController = guiController;
        addAllListeners();
    }

    abstract void addAllListeners();
    abstract void updatePanel();
}
