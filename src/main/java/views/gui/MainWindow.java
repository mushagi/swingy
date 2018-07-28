package views.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        this.setBackground(new java.awt.Color(30,30,100));
        this.setSize(new Dimension(1000, 600));
        this.setMaximumSize(new Dimension(1000, 600));
        this.setMinimumSize(new Dimension(1000, 600));
        this.setResizable(false);
    }
}
