package views.gui.windows;

import state.GameConstants;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        setBackground(GameConstants.Colors.DARKEST);
        this.setSize(new Dimension(1000, 600));
        this.setMinimumSize(new Dimension(1000, 600));
    }
}
