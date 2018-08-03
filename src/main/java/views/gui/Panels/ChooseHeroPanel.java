package views.gui.Panels;

import models.players.Hero;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

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
    public final HeroListPanel heroListPanel;
    private HeroCell currentlySelected;

    private final Button btnBack = new Button("Back");
    private final Button btnQuit = new Button("Quit");

    public final HeroStatisticsPanel heroStatisticsPanel;
    private final ArrayList<Hero> heroes;

    public ChooseHeroPanel(Collection<Hero> heroes) {
        Font font = new Font("SansSerif", Font.PLAIN, 15);

        BorderLayout layout = new BorderLayout();
        this.heroes = (ArrayList<Hero>) heroes;
        this.setLayout(layout);
        this.setBackground(Color.gray);
        JLabel lblChoose = new JLabel("Choose a Wakandian: ");
        lblChoose.setLabelFor(txtPlayerName);
        lblChoose.setFont(font);
        lblChoose.setForeground(Color.WHITE);

        JPanel centerPanel = new JPanel();
        heroListPanel = new HeroListPanel(heroes);
        heroListPanel.setBackground(Color.gray);
        JLabel lblPlayerName = new JLabel("Your name");
        lblPlayerName.setFont(font);
        lblPlayerName.setForeground(Color.WHITE);
        centerPanel.add(txtPlayerName);
        centerPanel.add(lblChoose);
        centerPanel.add(heroListPanel);
        add(centerPanel, BorderLayout.CENTER);

        heroStatisticsPanel = new HeroStatisticsPanel();
        heroStatisticsPanel.setBackground(new Color(18, 18, 18));
        add(heroStatisticsPanel, BorderLayout.EAST);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(1000, 40));
        optionsPanel.setBackground(new Color(40, 40, 40));
        optionsPanel.add(btnNext);
        optionsPanel.add(btnBack);
        optionsPanel.add(btnQuit);

        add(optionsPanel, BorderLayout.SOUTH);

/*        layout.putConstraint(SpringLayout.SOUTH, btnNext, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, btnNext, 0, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.WEST, btnNext);
        layout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, this);

        layout.putConstraint(SpringLayout.EAST, btnQuit, 0, SpringLayout.WEST, btnBack);
        layout.putConstraint(SpringLayout.SOUTH, btnQuit, 0, SpringLayout.SOUTH, this);*/

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

    public void addOnBackToMainMenuQuitListener(ActionListener onBtnBackToMainMenuListener) {
        btnBack.addActionListener(onBtnBackToMainMenuListener);
    }

}

class HeroListPanel extends JPanel {
    private final ArrayList<HeroCell> components = new ArrayList<>();

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

        JScrollPane scroll = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(null);
        mainPanel.setBackground(new Color(0,0,0, 0));
        scroll.setPreferredSize(new Dimension(600, 300));
        this.add(scroll);
    }

    void addMouseListeners(MouseListener mouseListener) {

        for (Component component : components) {
            component.addMouseListener(mouseListener);
        }
    }
}


