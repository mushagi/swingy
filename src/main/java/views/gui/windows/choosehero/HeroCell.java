package views.gui.windows.choosehero;

import lombok.Getter;
import models.players.Hero;
import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HeroCell extends JPanel {
    @Getter
    private final int tag ;
    private final JLabel lblImage = new JLabel();

    HeroCell(Hero hero, int tag) {
        JLabel lblType = new JLabel(hero.getName());
        lblType.setForeground(Color.WHITE);
        lblImage.setPreferredSize(new Dimension(140,100));
        swingWorker.execute();
        
        add(lblImage);
        add(lblType);
        
        this.tag = tag;
        this.setBackground(GameConstants.Colors.LIGHTEST__GRAY);
    
        this.setPreferredSize(new Dimension(150,150));
        this.setMaximumSize(new Dimension(150, 150));

    }

    void onHover() {
        this.setBackground(GameConstants.Colors.LIGHTER_BLUE);
    }
    void unSelected() {
        this.setBackground(GameConstants.Colors.LIGHTEST__GRAY);
    }
    
    private final SwingWorker<Integer, ImageIcon> swingWorker = new SwingWorker<Integer, ImageIcon>() {
        @Override
        protected Integer doInBackground() {
            ImageIcon imageIcon = ImageRepositoryImp.getImageIcon(getClass().getResource("/images/blackpanther.jpg").getPath(), lblImage.getPreferredSize());
            
            publish(imageIcon);
            return 0;
        }
    
        @Override
        protected void process(List<ImageIcon> chunks) {
            for (ImageIcon imageIcon: chunks) {
                lblImage.setIcon(imageIcon);
            }
        }
    };
    
}