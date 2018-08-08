package views.gui;

import state.GameColors;

import javax.swing.*;
import java.awt.*;

public class ButtonRounded extends JButton {
	public ButtonRounded(String text) throws HeadlessException {
		super(text);
		setBackground(GameColors.DARKEST_GRAY);
		setForeground(GameColors.DEFAULT_FONT);
		setOpaque(true);
		setFocusPainted(false);
		setFocusable(false);
	}
}
