package za.co.wethinkcode.mmayibo.swingy.views.gui.windows;

import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        setBackground(SwingyConstants.Colors.DARKEST);
        this.setSize(new Dimension(1000, 600));
        this.setMinimumSize(new Dimension(1000, 600));
    }
}
