package views.gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewLoadPlayerPanel extends JPanel {
    private final JButton btnNewHero = new JButton("New Hero");
    private final JButton btnLoadHero = new JButton("Load Hero");

    public NewLoadPlayerPanel() {

        this.setLayout(new GridLayout(3, 1));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel headerPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        headerPanel.setSize(this.getSize().width, 10);
        SpringLayout springLayout = new SpringLayout();
        headerPanel.setLayout(springLayout);
        JLabel lblWelcome = new JLabel("Swingy in Wakanda");
        lblWelcome.setFont(new Font("SansSerif", Font.ITALIC, 30));
        lblWelcome.setForeground(Color.WHITE);

        headerPanel.add(lblWelcome);
        headerPanel.setBorder(BorderFactory.createEtchedBorder());
        headerPanel.setBackground(Color.gray);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblWelcome, 0, SpringLayout.HORIZONTAL_CENTER, headerPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblWelcome, 0, SpringLayout.VERTICAL_CENTER, headerPanel);

        optionsPanel.setLayout(layout);
        optionsPanel.add(btnNewHero);
        optionsPanel.add(btnLoadHero);
        optionsPanel.setBackground(new Color(40, 48, 72));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        optionsPanel.add(btnNewHero, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10);
        optionsPanel.add(btnLoadHero, gbc);

        JLabel lblAuthor = new JLabel("mmayibo | WeThinkCode_ | 2018");
        lblAuthor.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblAuthor.setForeground(Color.WHITE);

        bottomPanel.add(lblAuthor);
        bottomPanel.setBackground(Color.gray);
        bottomPanel.setBorder(BorderFactory.createEtchedBorder());

        add(headerPanel);
        add(optionsPanel);
        add(bottomPanel);

    }

    public void addOnBtnNewListener(ActionListener onNewGameClickedActionListener) {
        btnNewHero.addActionListener(onNewGameClickedActionListener);

    }

    public void addOnBtnLoadHeroListener(ActionListener onLoadHeroClickedActionListener) {
        btnLoadHero.addActionListener(onLoadHeroClickedActionListener);
    }
}





