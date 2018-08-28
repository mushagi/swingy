package za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero;

import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.models.world.Arena;
import za.co.wethinkcode.mmayibo.swingy.state.SwingyConstants;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.GameButton;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.RoundedBorders;
import za.co.wethinkcode.mmayibo.swingy.views.gui.custom.HeroStatisticsTextArea;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

public class
ChooseHeroPanel extends JPanel {

    private HeroCell currentlySelected;
    private HeroCell chosen;
    
    private final ArrayList<Hero> heroes;
    private final CenterPanel centerPanel;
    private final ControlPanel controlPanel;
	private final SidePanel sidePanel ;
	private final boolean isFromDatabase ;

	public ChooseHeroPanel(Collection<Hero> heroes, boolean isFromDatabase) {
        this.heroes = (ArrayList<Hero>) heroes;
        this.isFromDatabase = isFromDatabase;
        BorderLayout layout = new BorderLayout();
        
        this.setLayout(layout);
        this.setBackground(Color.gray);
        
        centerPanel = new CenterPanel(heroes);
        controlPanel = new ControlPanel();
		sidePanel = new SidePanel();
		
		this.add(centerPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);
        this.add(controlPanel, BorderLayout.SOUTH);

        if (isFromDatabase)
		{
			centerPanel.lblError.setVisible(false);
			centerPanel.txtPlayerName.setVisible(false);
			centerPanel.lblPlayerName.setVisible(false);
		}

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, SwingyConstants.Colors.DARKEST, 12, h,SwingyConstants.Colors.BRIGHTER);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        
    }
    
    public void addOnNextActionListener(ActionListener nextActionListener) {
        controlPanel.btnStartGame.addActionListener(nextActionListener);
    }

    public void addTextChangedListener(DocumentListener onChangeListener) {
	    centerPanel.txtPlayerName.getDocument().addDocumentListener(onChangeListener);
    }

    public void addOnHeroPanelSelectionListener(MouseListener mouseListener) {
        centerPanel.heroListPanel.addMouseListeners(mouseListener);
    }
	
	public void invalidName(Arena arena) {
		for (String message : arena.getGameResults().getResult()) {
			centerPanel.lblError.setText(message);
		}
	}

    public void setSelected(Object source) {
        HeroCell heroCell = (HeroCell) source;
        heroCell.onHover();
        if (currentlySelected != heroCell)
        	unSelect();
        currentlySelected = heroCell;
    }
	public void unSelect() {
		if (currentlySelected != null)
			currentlySelected.toggleNormalColor();
	}
    public void updatePlayerStatistics() {
		
		if (heroes != null && currentlySelected != null)
			sidePanel.updateWithHero(heroes.get(currentlySelected.getTag()));
    }

    public void addOnBtnBackListener(ActionListener onBtnBackListener) {
        controlPanel.btnBack.addActionListener(onBtnBackListener);
    }
	
	public void addOnBtnQuitListener(ActionListener onQuitListener) {
		controlPanel.btnQuit.addActionListener(onQuitListener);
	}
	
	public void setAsChosen(Object source) {
		HeroCell currentlyChosen = (HeroCell) source;
		if (currentlyChosen != chosen && chosen != null) {
			chosen.unSetAsChosen();
			currentlyChosen.setAsChosen();
		}
		else if (currentlyChosen != chosen)
			currentlyChosen.setAsChosen();
		chosen = currentlyChosen;
	}
	
	private class CenterPanel extends JPanel  {
        final Font font = new Font("SansSerif", Font.ITALIC, 14);
	    private final JLabel lblChoose = new JLabel("Choose a Wakandian: ");
		private final JLabel lblError = new JLabel();
		private final JLabel lblPlayerName = new JLabel("Your name");
	    private final JTextField txtPlayerName = new JTextField(13);
	    private final HeroListPanel heroListPanel;

        CenterPanel(Collection<Hero> heroes) {
            heroListPanel = new HeroListPanel(heroes);
            this.setOpaque(false);
            this.setUpNameTxtPlayerName();
            this.setUpLayout();
            this.add(lblPlayerName);
            this.add(txtPlayerName);
	        this.add(lblError);
	        this.add(lblChoose);
            this.add(heroListPanel);

            lblChoose.setLabelFor(txtPlayerName);
            lblChoose.setFont(font);
            lblChoose.setForeground(Color.WHITE);
	        lblError.setForeground(Color.RED);
	        lblError.setFont(font);
	        lblPlayerName.setFont(font);
            lblPlayerName.setForeground(Color.WHITE);
        }
        
        private void setUpNameTxtPlayerName() {
            txtPlayerName.setBorder(new RoundedBorders(20));
            txtPlayerName.setOpaque(false);
            txtPlayerName.setFont(font);
            txtPlayerName.setBackground(new Color(0, 0,0,0));
            txtPlayerName.setForeground(Color.WHITE);
            txtPlayerName.setCaretColor(Color.WHITE);
            txtPlayerName.addAncestorListener(new AncestorListener() {
	            @Override
	            public void ancestorAdded(AncestorEvent event) {
	            	SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
				            txtPlayerName.requestFocus();
				            txtPlayerName.requestFocusInWindow();
			            }
		            });
	            }
	
	            @Override
	            public void ancestorRemoved(AncestorEvent event) {
		
	            }
	
	            @Override
	            public void ancestorMoved(AncestorEvent event) {
		
	            }
            });
        }
        
        private void setUpLayout() {
            SpringLayout layout = new SpringLayout();
            this.setLayout(layout);
            layout.putConstraint(SpringLayout.WEST, lblPlayerName, 10, SpringLayout.WEST, this);
            layout.putConstraint(SpringLayout.NORTH, lblPlayerName, 15, SpringLayout.NORTH, this);
            layout.putConstraint(SpringLayout.WEST, txtPlayerName, 10, SpringLayout.EAST, lblPlayerName);
            layout.putConstraint(SpringLayout.NORTH, txtPlayerName, 10, SpringLayout.NORTH, this);
	        layout.putConstraint(SpringLayout.WEST, lblError, 10, SpringLayout.EAST, txtPlayerName);
	        layout.putConstraint(SpringLayout.NORTH, lblError, 10, SpringLayout.NORTH, this);
            layout.putConstraint(SpringLayout.NORTH, lblChoose, 30, SpringLayout.SOUTH, lblPlayerName);
            layout.putConstraint(SpringLayout.WEST, lblChoose, 0, SpringLayout.WEST, lblPlayerName);
            layout.putConstraint(SpringLayout.NORTH, heroListPanel, 2, SpringLayout.SOUTH, lblChoose);
			layout.putConstraint(SpringLayout.WEST, heroListPanel, 2, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.EAST, heroListPanel, -2, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.SOUTH, heroListPanel, -2, SpringLayout.SOUTH, this);

		}
    }
	
	private  class  ControlPanel extends JPanel {
		private final GameButton btnStartGame = new GameButton("Start Game");
		private final GameButton btnBack = new GameButton("Back");
		private final GameButton btnQuit = new GameButton("Quit");
		
		private final Dimension dimension = new Dimension(200,35);
		final SpringLayout layout = new SpringLayout();
		
		ControlPanel() {
			setUpLayout();
			
			btnBack.setPreferredSize(dimension);
			btnStartGame.setPreferredSize(dimension);
			btnQuit.setPreferredSize(dimension);
			
			this.setPreferredSize(new Dimension(1000, 60));
			this.setBackground(SwingyConstants.Colors.LIGHTEST);
			this.add(btnStartGame);
			this.add(btnBack);
			this.add(btnQuit);
		}
		void setUpLayout(){
			this.setLayout(layout);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnStartGame, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnStartGame, 0, SpringLayout.VERTICAL_CENTER, this);
			
			layout.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnStartGame);
			layout.putConstraint(SpringLayout.EAST, btnBack, -20, SpringLayout.WEST, btnStartGame);
			
			layout.putConstraint(SpringLayout.NORTH, btnQuit, 0, SpringLayout.NORTH, btnStartGame);
			layout.putConstraint(SpringLayout.WEST, btnQuit, 20, SpringLayout.EAST, btnStartGame);

		}
	}
	
	private class SidePanel extends HeroStatisticsTextArea {
		SidePanel() {
			this.setBackground(SwingyConstants.Colors.DARKEST);
			this.setPreferredSize(new Dimension(320,400));
		}
	}
}


