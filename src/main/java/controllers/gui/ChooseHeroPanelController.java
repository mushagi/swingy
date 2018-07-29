package controllers.gui;

import controllers.AUIController;
import controllers.ArenaController;
import lombok.AccessLevel;
import lombok.Setter;
import state.GameState;
import views.gui.Panels.ChooseHeroPanel;
import views.gui.Panels.GamePanel;
import views.gui.Panels.HeroCell;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChooseHeroPanelController extends AUIController {

    private final GUIController guiController;
    private final ChooseHeroPanel chooseHeroPanel;
    @Setter(AccessLevel.PRIVATE)
    private String playerName = "";
    private int heroType;

    ChooseHeroPanelController(ArenaController arenaController, GUIController guiController, ChooseHeroPanel chooseHeroPanel) {
        super(arenaController);
        this.chooseHeroPanel = chooseHeroPanel;
        this.guiController = guiController;
        addAllListeners();
    }


    private void addAllListeners() {
        chooseHeroPanel.addOnNextActionListener(onNextActionListener);
        chooseHeroPanel.addTextChangedListener(onTxtPlayerNameTextChanged);
        chooseHeroPanel.addOnHeroPanelSelectionListener(onHeroPanelSelection);
    }

    private final MouseListener onHeroPanelSelection = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

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
            loadPlayerNameToArena(playerName);
            String heroTypeName = GameState.getInstance().getAvailableHeroes().get(heroType).getType();
            createNewHero(heroTypeName);

            GamePanel gamePanel =
                    new GamePanel(arenaController.getArena().getMap().getSize());
            GamePanelController controller =
                    new GamePanelController(arenaController, guiController, gamePanel);
            controller.updateUserInterface();

            guiController.switchMainWindowPanel(gamePanel);
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
    public void switchUI() {
        
    }

    @Override
    protected void updateUserInterface() {
        guiController.updateUserInterface();
    }


    @Override
    public void run() {

    }
}