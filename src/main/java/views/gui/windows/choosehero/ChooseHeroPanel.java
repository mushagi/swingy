package views.gui.windows.choosehero;

import models.players.Hero;
import views.gui.custom.ButtonRounded;
import views.gui.custom.RoundedBorders;
import views.gui.custom.HeroStatisticsTextArea;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

public class
ChooseHeroPanel extends JPanel {

    private final ButtonRounded btnNext = new ButtonRounded("Next");
    private final JTextField txtPlayerName = new JTextField(13);
    private final JLabel lblChoose = new JLabel("Choose a Wakandian: ");
    private HeroCell currentlySelected;
    private final JLabel lblPlayerName = new JLabel("Your name");
    private final HeroStatisticsTextArea heroStatisticsTextArea = new HeroStatisticsTextArea();

    private final ButtonRounded btnBack = new ButtonRounded("Back");
    private final ButtonRounded btnQuit = new ButtonRounded("Quit");
    private HeroListPanel heroListPanel;
    private final ArrayList<Hero> heroes;
    
    private final JLabel lblImage = new JLabel();
    
    
    public ChooseHeroPanel(Collection<Hero> heroes) {
        BorderLayout layout = new BorderLayout();

        this.heroes = (ArrayList<Hero>) heroes;

        this.setLayout(layout);
        this.setBackground(Color.gray);

        JPanel centerPanel = getCenterPanel();
        JComponent sidePanel = getSidePanel();
        JPanel optionsPanel = getOptionsPanel();

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);
        this.add(optionsPanel, BorderLayout.SOUTH);

    }

    private JPanel getOptionsPanel() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(1000, 40));
        optionsPanel.setBackground(new Color(40, 40, 40));
        optionsPanel.add(btnNext);
        optionsPanel.add(btnBack);
        optionsPanel.add(btnQuit);
        
        return optionsPanel;
    }

    private JComponent getSidePanel() {
        heroStatisticsTextArea.setBackground(new Color(18, 18, 18));
        heroStatisticsTextArea.setPreferredSize(new Dimension(320,400));
        return heroStatisticsTextArea;
    }

    private JPanel getCenterPanel() {
        SpringLayout layout = new SpringLayout();
	    JPanel centerPanel = new JPanel();
	    
	    Font font = new Font("SansSerif", Font.ITALIC, 10);

        lblChoose.setLabelFor(txtPlayerName);
        lblChoose.setFont(font);
        lblChoose.setForeground(Color.WHITE);

        centerPanel.setLayout(layout);
        Color grayish = new Color(29, 29, 29);
        centerPanel.setBackground(grayish);

        lblPlayerName.setFont(font);
        lblPlayerName.setForeground(Color.WHITE);

        txtPlayerName.setBorder(new RoundedBorders(20));
        txtPlayerName.setOpaque(false);
        txtPlayerName.setFont(font);
        txtPlayerName.setBackground(new Color(0, 0,0,0));
        txtPlayerName.setForeground(Color.WHITE);
	    txtPlayerName.requestFocusInWindow();
	    txtPlayerName.requestFocus();
	    txtPlayerName.getCaret().setVisible(true);
	    txtPlayerName.setCaretColor(Color.WHITE);
	
	    heroListPanel = new HeroListPanel(heroes);
	
	    centerPanel.add(lblPlayerName);
        centerPanel.add(txtPlayerName);
        centerPanel.add(lblChoose);
        centerPanel.add(heroListPanel);
        
        layout.putConstraint(SpringLayout.WEST, lblPlayerName, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, lblPlayerName, 15, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, txtPlayerName, 10, SpringLayout.EAST, lblPlayerName);
        layout.putConstraint(SpringLayout.NORTH, txtPlayerName, 10, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.NORTH, lblChoose, 30, SpringLayout.SOUTH, lblPlayerName);
        layout.putConstraint(SpringLayout.WEST, lblChoose, 0, SpringLayout.WEST, lblPlayerName);

        layout.putConstraint(SpringLayout.NORTH, heroListPanel, 2, SpringLayout.SOUTH, lblChoose);

        return centerPanel;
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
        heroCell.onHover();
        if (currentlySelected != null && currentlySelected != heroCell)
            currentlySelected.unSelected();
        currentlySelected = heroCell;
    }

    public void updatePlayerStatistics() {
        heroStatisticsTextArea.updateWithHero(heroes.get(currentlySelected.getTag()));
    }

    public void addOnBtnBackListener(ActionListener onBtnBackListener) {
        btnBack.addActionListener(onBtnBackListener);
    }
	
	public void addOnBtnQuitListener(ActionListener onQuitListener) {
		btnQuit.addActionListener(onQuitListener);
	}
	
	
}


