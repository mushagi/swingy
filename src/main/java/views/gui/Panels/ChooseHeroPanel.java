package views.gui.Panels;

import models.players.Hero;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Collection;

public class ChooseHeroPanel extends JPanel {

    private final JButton btnNext = new JButton("Next");
    private final JTextField txtPlayerName = new JTextField();
    private HeroListPanel heroListPanel;
    private HeroCell currentlySelected;
    private JLabel lblPlayerName=  new JLabel("What is your name");
    public ChooseHeroPanel(Collection<Hero> heroes) {
        SpringLayout layout = new SpringLayout();

        this.setLayout(layout);
        JLabel lblChoose = new JLabel("Choose a Wakandian: ");
        lblChoose.setLabelFor(txtPlayerName);
        //add(label, BorderLayout.SOUTH);

        heroListPanel = new HeroListPanel(heroes);
        heroListPanel.setPreferredSize(new Dimension(600, 650));
        add(lblChoose);

        add(lblPlayerName);
        add(txtPlayerName);
        add(heroListPanel);


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblChoose, 5, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.WEST, lblPlayerName, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, lblPlayerName, 10, SpringLayout.NORTH, lblChoose);

        layout.putConstraint(SpringLayout.WEST, txtPlayerName, 5, SpringLayout.EAST, lblPlayerName);
        layout.putConstraint(SpringLayout.NORTH, txtPlayerName, 5, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, heroListPanel, 10, SpringLayout.WEST, lblPlayerName);
        layout.putConstraint(SpringLayout.NORTH, heroListPanel, 35, SpringLayout.NORTH, lblPlayerName);


        this.setBorder(BorderFactory.createEtchedBorder());
     //   add(txtPlayerName);
       // add(btnNext);
    }

    public void addOnNextActionListener(ActionListener nextActionListener) {
        btnNext.addActionListener(nextActionListener);
    }

    public void addTextChangedListener(DocumentListener onChangeListener) {
        txtPlayerName.getDocument().addDocumentListener(onChangeListener);
    }

    public void addOnHeroPanelSelectionListener(MouseListener mouseListener) {
        heroListPanel.addMouseListeners(mouseListener);
    }

    public void setSelected(Object source) {
        HeroCell heroCell = (HeroCell) source;
        heroCell.selected();
        if (currentlySelected != null)
            currentlySelected.unSelected();
        currentlySelected = heroCell;
    }
}

class HeroListPanel extends JPanel {
    HeroListPanel(Collection<Hero> heroes) {
        int tag = 0;

        this.setLayout(new GridLayout(5,5));

        for (Hero hero: heroes){
            HeroCell heroCell = new HeroCell(hero, tag++);
            add(heroCell);
        }
    }

    void addMouseListeners(MouseListener mouseListener) {
        for (Component component : getComponents()) {
            component.addMouseListener(mouseListener);
        }
    }
}


