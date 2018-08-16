package views.gui.windows;

import state.GameConstants;
import utils.ImageRepositoryImp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class NewLoadPlayerPanel extends JPanel {
    private final MenuButton btnNewHero = new MenuButton("New Hero");
    private final MenuButton btnLoadHero = new MenuButton("Load Hero");
    private final MenuButton quit = new MenuButton("Quit");

    private final BufferedImage image;
    private JPanel menuPanel = new JPanel();

    private JPanel bottomPanel = new JPanel();

    public NewLoadPlayerPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(GameConstants.Colors.DARKEST);
        image = ImageRepositoryImp.getInstance().getBufferedImage("background");

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
        bottomPanel.setBackground(GameConstants.Colors.TRANSPARENT);
    }

    private void setUpMenuPanel() {
        SpringLayout layout = new SpringLayout();

        menuPanel.setLayout(layout);
        menuPanel.setPreferredSize(new Dimension(950, 70));

        JLabel lblWelcome = new JLabel("Swingy in Wakanda");

        lblWelcome.setFont(new Font("SansSerif", Font.ITALIC, 40));
        lblWelcome.setForeground(Color.WHITE);



        menuPanel.setBackground(GameConstants.Colors.TRANSPARENT);

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
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

    private class MenuButton extends JButton {
        Border border = BorderFactory.createMatteBorder(0,0,10,0, GameConstants.Colors.BRIGHTEST);
        private MenuButton(String text) throws HeadlessException {
            super(text);
            setBorder(null);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setFocusable(false);
            setForeground(GameConstants.Colors.DEFAULT_FONT);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    update(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    update(true);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    update(false);

                }
            });
        }

        void update(boolean isSelected) {
            setBorder(isSelected ? border : null);
            getParent().getParent().getParent().repaint();
            getParent().getParent().repaint();
            getParent().repaint();
            repaint();
        }
    }
}





