package za.co.wethinkcode.mmayibo.swingy.views.gui.windows;

import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;
import za.co.wethinkcode.mmayibo.swingy.utils.ImageRepositoryImp;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.GameButton;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewLoadPlayerPanel extends ImagePanel {
    private final GameButton btnNewHero = new GameButton("New Hero");
    private final GameButton btnLoadHero = new GameButton("Load Hero");
    private final GameButton quit = new GameButton("Quit");

    private JPanel menuPanel = new JPanel();

    private JPanel bottomPanel = new JPanel();

    public NewLoadPlayerPanel() {
	    super(ImageRepositoryImp.getInstance().getBufferedImage("background"));
	    
	    this.setLayout(new BorderLayout());
        this.setBackground(SwingyConstants.Colors.DARKEST);
        
        setUpMenuPanel();
        setUpBottonPanel();

        add(menuPanel, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private void setUpBottonPanel() {
        JLabel lblAuthor = new JLabel("mmayibo | WeThinkCode_ | 2018");
        lblAuthor.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblAuthor.setForeground(Color.WHITE);

        bottomPanel.add(lblAuthor);
        bottomPanel.setBackground(SwingyConstants.Colors.TRANSPARENT);
    }

    private void setUpMenuPanel() {
        SpringLayout layout = new SpringLayout();

        menuPanel.setLayout(layout);
        menuPanel.setPreferredSize(new Dimension(950, 70));
        menuPanel.setOpaque(false);
        
	    setFocusable(false);
        JLabel lblWelcome = new JLabel("Swingy in Wakanda");

        lblWelcome.setFont(new Font("SansSerif", Font.ITALIC, 40));
        lblWelcome.setForeground(Color.WHITE);
        
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(lblWelcome.getPreferredSize().width,3));

        layout.putConstraint(SpringLayout.NORTH, lblWelcome, 20, SpringLayout.NORTH, menuPanel);
        layout.putConstraint(SpringLayout.WEST, lblWelcome, 20, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, separator, 5, SpringLayout.SOUTH, lblWelcome);
        layout.putConstraint(SpringLayout.WEST, separator, 20, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, btnNewHero, 50, SpringLayout.SOUTH, separator);
        layout.putConstraint(SpringLayout.WEST, btnNewHero, 20, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, btnLoadHero, 20, SpringLayout.SOUTH, btnNewHero);
        layout.putConstraint(SpringLayout.WEST, btnLoadHero, 20, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, quit, 20, SpringLayout.SOUTH, btnLoadHero);
        layout.putConstraint(SpringLayout.WEST, quit, 20, SpringLayout.WEST, this);

        btnNewHero.setPreferredSize(new Dimension(370,35));
        btnLoadHero.setPreferredSize(new Dimension(370,35));
        quit.setPreferredSize(new Dimension(370,35));

        menuPanel.add(lblWelcome);
        menuPanel.add(separator);
        menuPanel.add(btnNewHero);
        menuPanel.add(btnLoadHero);
        menuPanel.add(quit);
    }
    
    public void addOnBtnNewListener(ActionListener onNewGameClickedActionListener) {
        btnNewHero.addActionListener(onNewGameClickedActionListener);

    }

    public void addOnBtnLoadHeroListener(ActionListener onLoadHeroClickedActionListener) {
        btnLoadHero.addActionListener(onLoadHeroClickedActionListener);
    }


    public void addOnBtnQuitListener(ActionListener onQuitListener) {
        quit.addActionListener(onQuitListener);
    }


}


