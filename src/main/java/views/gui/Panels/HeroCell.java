package views.gui.Panels;

import lombok.Getter;
import models.players.Hero;
import state.GameColors;
import utils.ImageRender;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HeroCell extends JPanel {
    @Getter
    private final int tag ;
    JLabel lblImage =new JLabel();

    HeroCell(Hero hero, int tag) {
        JLabel lblType = new JLabel(hero.getHeroClass());
        lblType.setForeground(Color.WHITE);
        lblImage.setPreferredSize(new Dimension(140,100));
        swingWorker.execute();
        add(lblImage);
        add(lblType);
        this.tag = tag;
        this.setBackground(GameColors.LIGHTERST__GRAY);
    
        this.setPreferredSize(new Dimension(150,150));
        this.setMaximumSize(new Dimension(150, 150));

    }

    void onHover() {
        this.setBackground(GameColors.LIGHTER_BLUE);
    }
    void unSelected() {
        this.setBackground(GameColors.LIGHTERST__GRAY);
    }
    
    SwingWorker<Integer, ImageIcon> swingWorker = new SwingWorker<Integer, ImageIcon>() {
        @Override
        protected Integer doInBackground() throws Exception {
            ImageIcon imageIcon = ImageRender.getImageIcon(getClass().getResource("/images/blackpanther.jpg").getPath(), lblImage);
            
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
	
	public void setValues(String hero) {
	
	}
}