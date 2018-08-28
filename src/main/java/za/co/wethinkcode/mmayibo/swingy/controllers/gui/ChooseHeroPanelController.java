package za.co.wethinkcode.mmayibo.swingy.controllers.gui;

import lombok.AccessLevel;
import lombok.Setter;
import za.co.wethinkcode.mmayibo.swingy.models.players.Hero;
import za.co.wethinkcode.mmayibo.swingy.state.GameState;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero.ChooseHeroPanel;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero.HeroCell;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

class  ChooseHeroPanelController extends APanelController {
    private final ChooseHeroPanel chooseHeroPanel;

    @Setter(AccessLevel.PRIVATE)
    private String playerName = "";
    private int selectedPlayer;
    private ArrayList<Hero> heroes;
    private final boolean isFromDatabase ;

    ChooseHeroPanelController(GUIController guiController,
                              ChooseHeroPanel chooseHeroPanel,
                              Collection<Hero> heroes,
                              boolean isFromDatabase) {
        super(guiController);
        this.isFromDatabase = isFromDatabase;
        this.chooseHeroPanel = chooseHeroPanel;
        this.heroes = (ArrayList<Hero>) heroes;
        addAllListeners();
    }

    private final MouseListener onHeroPanelSelection = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            chooseHeroPanel.setAsChosen(e.getSource());
            updatePanel();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            HeroCell heroCell = (HeroCell) e.getSource();
            selectedPlayer = heroCell.getTag();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            chooseHeroPanel.setSelected(e.getSource());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            chooseHeroPanel.unSelect();
        }
    };

    private final ActionListener onNextActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Hero hero = heroes.get(selectedPlayer);
            guiController.createNewHero(hero);
	        guiController.loadPlayerNameToArena(isFromDatabase ? hero.getName() : playerName);
	        if (guiController.getArena().isPLayerNameLoaded())
	        	guiController.showGamePanel();
	        else
                chooseHeroPanel.invalidName(guiController.getArena());
        }
    };

    private final ActionListener onBtnBackListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.switchToPreviousPanel();
        }
    };

    private final DocumentListener onTxtPlayerNameTextChanged = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
	        try {
      		        setPlayerName(e.getDocument().getText(0, e.getDocument().getLength()));
	        } catch (BadLocationException ignored) {
	        }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
	        try { setPlayerName(e.getDocument().getText(0, e.getLength()));
	        } catch (BadLocationException ignored) {
	        }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
	        try {
		        setPlayerName(e.getDocument().getText(0, e.getLength()));
	        } catch (BadLocationException ignored) {
	        }
        }
    };
    
	private final ActionListener onBtnQuitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.quitGame();
        }
    };




    @Override
    void addAllListeners() {
        chooseHeroPanel.addOnNextActionListener(onNextActionListener);
        chooseHeroPanel.addTextChangedListener(onTxtPlayerNameTextChanged);
        chooseHeroPanel.addOnHeroPanelSelectionListener(onHeroPanelSelection);
        chooseHeroPanel.addOnBtnBackListener(onBtnBackListener);
        chooseHeroPanel.addOnBtnQuitListener(onBtnQuitListener);
    }

    @Override
    void updatePanel() {
        chooseHeroPanel.updatePlayerStatistics();
    }
}