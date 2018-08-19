package views.gui.custom;

import models.players.APlayer;
import utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagePanel extends JPanel {
	private BufferedImage bufferedImage;
	private BufferedImage scaledBufferedImage;
	
	public ImagePanel() {
		setOpaque(false);
	}
	
	public ImagePanel(BufferedImage bufferedImage) {
		setOpaque(true);
		this.bufferedImage = bufferedImage;
	}
	
	@Override
	public void invalidate() {
		super.invalidate();
		
		int width = getWidth();
		int height = getHeight();
		if ( bufferedImage != null){
			if (width > 0 && height > 0) {
				try {
					scaledBufferedImage = ImageRepositoryImp.getScaledImage(bufferedImage, width, height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return bufferedImage == null ? new Dimension(100, 100) : new Dimension(
				bufferedImage.getWidth(this), bufferedImage.getHeight(this));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledBufferedImage, 0, 0, null);
	}
	
	public void changeImage(APlayer player) {
		if (player != null)
			bufferedImage = ImageRepositoryImp.getInstance().getBufferedImage(player.getPicture());
		else{
			bufferedImage = null;
			scaledBufferedImage = null;
		}
	}
	
	public void changeImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}
