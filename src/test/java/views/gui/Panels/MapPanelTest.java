package views.gui.Panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;

class MapPanelTest {
    @Test
    void mapPanel() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        MapPanel mapPanel = new MapPanel();
        mapPanel.setVisible(true);
    }
}