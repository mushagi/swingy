package controllers.gui;

abstract class APanelController {
    final GUIController guiController;

    APanelController(GUIController guiController) {
        this.guiController = guiController;
    }

    abstract void addAllListeners();
    abstract void updatePanel();
}
