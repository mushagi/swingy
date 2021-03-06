package za.co.wethinkcode.mmayibo.swingy.views.gui.custom;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorders implements Border {
    
    private final int radius;

    public RoundedBorders(int radius) {
        this.radius = radius;
    }
    
    private int getRadius() {
        return radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, getRadius(), getRadius()));
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int value = getRadius() / 4;
        return new Insets(value, value, value, value);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}