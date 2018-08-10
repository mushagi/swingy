package views.gui;

import javafx.scene.layout.Border;
import state.GameColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonRounded extends JButton {
	public ButtonRounded(String text) throws HeadlessException {
		super(text);
		setForeground(GameColors.DEFAULT_FONT);
		setBackground(GameColors.LIGHTER_GRAY);
		setOpaque(true);
	}
}
