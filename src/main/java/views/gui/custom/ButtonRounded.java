package views.gui.custom;

import state.GameConstants;

import javax.swing.*;
import java.awt.*;

public class ButtonRounded extends JButton {
	public ButtonRounded(String text) throws HeadlessException {
		super(text);
		setForeground(GameConstants.Colors.DEFAULT_FONT);
		setBackground(GameConstants.Colors.LIGHTER);
		setOpaque(true);
	}
}
