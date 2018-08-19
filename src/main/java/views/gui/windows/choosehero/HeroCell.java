package views.gui.windows.choosehero;

import lombok.Getter;
import models.players.Hero;
import state.SwingyConstants;
import views.gui.custom.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class HeroCell extends JPanel {
    public static final int HERO_CELL_WIDTH = 150;
    public static final int HERO_CELL_HEIGHT = 150 ;
    private Color chosenColor = SwingyConstants.Colors.REDDISH;
    private Color selectedColor = SwingyConstants.Colors.LIGHT_SHADE;
	private Color normalColor = SwingyConstants.Colors.LIGHTEST;
	private boolean isChosen = false;
	@Getter
    private final int tag ;
	ImagePanel imagePanel = new ImagePanel();
	JLabel lblType = new JLabel();
	
	
	public HeroCell(Hero hero, int tag) {
		this.tag = tag;
		this.setLayout(new BorderLayout());
		this.setBackground(SwingyConstants.Colors.LIGHTEST);
		this.setPreferredSize(new Dimension(HERO_CELL_WIDTH,HERO_CELL_HEIGHT));
		this.setMaximumSize(new Dimension(HERO_CELL_WIDTH, HERO_CELL_HEIGHT));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		imagePanel.changeImage(hero);
		lblType.setFont(SwingyConstants.MONO_FONT_BOLD);
		lblType.setText(hero.getName());
        lblType.setForeground(Color.WHITE);
        lblType.setHorizontalAlignment(JLabel.CENTER);
        lblType.setVerticalAlignment(JLabel.CENTER);
        
        add(imagePanel, BorderLayout.CENTER);
        add(lblType, BorderLayout.SOUTH);
    }

		
	void onHover() {
		this.setBackground(selectedColor);
	}
	
	void toggleNormalColor() {
        this.setBackground(isChosen ? chosenColor : normalColor);
    }
	
	public void unSetAsChosen() {
		isChosen = false;
		toggleNormalColor();
	}
	
	public void setAsChosen() {
		isChosen = true;
		onHover();
	}
}