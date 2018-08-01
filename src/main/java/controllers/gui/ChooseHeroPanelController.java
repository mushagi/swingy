package controllers.gui;

import lombok.AccessLevel;
import lombok.Setter;
import state.GameState;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.HeroCell;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class ChooseHeroPanelController extends APanelController {
    private final ChooseHeroPanel chooseHeroPanel;

    @Setter(AccessLevel.PRIVATE)
    private String playerName = "";
    private int heroType;

    ChooseHeroPanelController(GUIController guiController, ChooseHeroPanel chooseHeroPanel) {
        super(guiController);
        this.chooseHeroPanel = chooseHeroPanel;
        addAllListeners();
    }

    private final MouseListener onHeroPanelSelection = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            chooseHeroPanel.updatePlayerStatistics();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            HeroCell heroCell = (HeroCell) e.getSource();
            heroType = heroCell.getTag();
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

        }
    };

    private final ActionListener onNextActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.loadPlayerNameToArena(playerName);

            String heroTypeName = GameState.getInstance().getAvailableHeroes().get(heroType).getType();
            guiController.createNewHero(heroTypeName);

            guiController.showGamePanel();
        }
    };

    private final ActionListener onBtnBackListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.switchToPreviousPanel();
        }
    };

    private DocumentListener onTxtPlayerNameTextChanged = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            setPlayerName(e.getDocument().toString());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setPlayerName(e.getDocument().toString());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            setPlayerName(e.getDocument().toString());
        }
    };

    @Override
    void addAllListeners() {
        chooseHeroPanel.addOnNextActionListener(onNextActionListener);
        chooseHeroPanel.addTextChangedListener(onTxtPlayerNameTextChanged);
        chooseHeroPanel.addOnHeroPanelSelectionListener(onHeroPanelSelection);
        chooseHeroPanel.addOnBtnBackListener(onBtnBackListener);
    }

    @Override
    void updatePanel() {

    }
}