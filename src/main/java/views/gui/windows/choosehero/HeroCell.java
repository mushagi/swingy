package views.gui.windows.choosehero;

import lombok.Getter;
import models.players.Hero;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;

public class HeroCell extends JPanel {
    public static final int HERO_CELL_WIDTH = 150;
    public static final int HERO_CELL_HEIGHT = 150 ;
    @Getter
    private final int tag ;
    private final JLabel lblImage = new JLabel();

    HeroCell(Hero hero, int tag) {
        JLabel lblType = new JLabel(hero.getName());
        lblType.setForeground(Color.WHITE);
        lblImage.setPreferredSize(new Dimension(HERO_CELL_WIDTH,HERO_CELL_HEIGHT));
    
        ImageIcon imageIcon =
                ImageRepositoryImp.getInstance().getImageIcon(
                        hero.getPicture(),
                        HERO_CELL_WIDTH, HERO_CELL_HEIGHT
                );
        lblImage.setIcon(imageIcon);
        
        add(lblImage);
        add(lblType);
        
        this.tag = tag;
        this.setBackground(GameConstants.Colors.LIGHTEST);
    
        this.setPreferredSize(new Dimension(HERO_CELL_WIDTH,HERO_CELL_HEIGHT));
        this.setMaximumSize(new Dimension(HERO_CELL_WIDTH, HERO_CELL_HEIGHT));

    }

    void onHover() {
        this.setBackground(GameConstants.Colors.LIGHT_SHADE);
    }
    void unSelected() {
        this.setBackground(GameConstants.Colors.LIGHTEST);
    }
    
    
}