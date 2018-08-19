package views;

import controllers.models.ArenaController;
import enums.HeroType;
import factory.ArenaControllerFactory;
import factory.ArenaFactory;
import factory.HeroFactory;
import models.world.Arena;
import views.gui.GUI;
import views.gui.windows.GameEndedPanel;
import views.gui.windows.arena.GamePanel;
import views.gui.windows.arena.MapPanel;
import views.gui.windows.choosehero.HeroCell;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GUIMAIN extends JPanel {
	

	
	public static void main(String[] args) {
		ArenaController arena = ArenaControllerFactory.newArenaControllerFromGameData();
		GameEndedPanel heroCell = new GameEndedPanel(ArenaFactory.newArena());
		GUI gui = new GUI();
		gui.addMainWindowContentPane(heroCell);
	}
}