package views.gui.Panels;

import models.players.Hero;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

public class
ChooseHeroPanel extends JPanel {

    private final JButton btnNext = new JButton("Next");
    private final JTextField txtPlayerName = new JTextField(13);
    private HeroListPanel heroListPanel;
    private HeroCell currentlySelected;
    private JLabel lblPlayerName =  new JLabel("Your name");

    Button btnBack = new Button("Back");
    Button btnQuit = new Button("Quit");

    HeroStatisticsPanel heroStatisticsPanel = new HeroStatisticsPanel();
    private ArrayList<Hero> heroes;

    public ChooseHeroPanel(Collection<Hero> heroes) {
        SpringLayout layout = new SpringLayout();
        this.heroes = (ArrayList<Hero>) heroes;
        this.setLayout(layout);
        JLabel lblChoose = new JLabel("Choose a Wakandian: ");
        lblChoose.setLabelFor(txtPlayerName);
        //add(label, BorderLayout.SOUTH);

        heroListPanel = new HeroListPanel(heroes);


        add(lblPlayerName);
        add(lblChoose);
        add(txtPlayerName);
        add(heroListPanel);

        add(heroStatisticsPanel);
        add(btnNext);
        add(btnBack);
        add(btnQuit);

        layout.putConstraint(SpringLayout.NORTH, lblPlayerName, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblPlayerName, 0, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtPlayerName, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, txtPlayerName, 0, SpringLayout.SOUTH, lblPlayerName);

        layout.putConstraint(SpringLayout.NORTH, lblChoose, 50, SpringLayout.NORTH, txtPlayerName);
        layout.putConstraint(SpringLayout.WEST, lblChoose, 10, SpringLayout.WEST, this);


        layout.putConstraint(SpringLayout.NORTH, heroListPanel, 30, SpringLayout.NORTH, lblChoose);

        layout.putConstraint(SpringLayout.NORTH, heroStatisticsPanel, 0, SpringLayout.NORTH, heroListPanel);
        layout.putConstraint(SpringLayout.WEST, heroStatisticsPanel, 100, SpringLayout.EAST, heroListPanel);

        layout.putConstraint(SpringLayout.SOUTH, btnNext, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, btnNext, 0, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.WEST, btnNext);
        layout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, this);

        layout.putConstraint(SpringLayout.EAST, btnQuit, 0, SpringLayout.WEST, btnBack);
        layout.putConstraint(SpringLayout.SOUTH, btnQuit, 0, SpringLayout.SOUTH, this);

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
        if (currentlySelected != null && currentlySelected != heroCell)
            currentlySelected.unSelected();
        currentlySelected = heroCell;
    }

    public void updatePlayerStatistics() {
        heroStatisticsPanel.updateWithHero(heroes.get(currentlySelected.getTag()));
    }

    public void addOnBtnBackListener(ActionListener onBtnBackListener) {
        btnBack.addActionListener(onBtnBackListener);
    }
}

class HeroListPanel extends JPanel {
    JScrollPane scroll;
    ArrayList<HeroCell> components = new ArrayList<>();

    HeroListPanel(Collection<Hero> heroes) {
        int tag = 0;

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(500,heroes.size() * 53));
        mainPanel.setLayout(new FlowLayout());


        for (Hero hero: heroes){
            HeroCell heroCell = new HeroCell(hero, tag++);
            mainPanel.add(heroCell);
            components.add(heroCell);
        }

        scroll = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(null);
       // scroll.setMinimumSize(new Dimension(160, 500));
        scroll.setPreferredSize(new Dimension(600, 500));
        this.add(scroll);
    }

    void addMouseListeners(MouseListener mouseListener) {

        for (Component component : components) {
            component.addMouseListener(mouseListener);
        }
    }
}


