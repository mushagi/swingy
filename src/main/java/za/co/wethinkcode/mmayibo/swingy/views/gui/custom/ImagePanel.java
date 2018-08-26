package za.co.wethinkcode.mmayibo.swingy.views.gui.custom;

import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.utils.ImageRepositoryImp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
	private BufferedImage bufferedImage;
	private BufferedImage scaledBufferedImage;
	
	public ImagePanel() {
		setOpaque(false);
	}
	
	protected ImagePanel(BufferedImage bufferedImage) {
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
				scaledBufferedImage = ImageRepositoryImp.getScaledImage(bufferedImage, width, height);
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
	
	public void changeImage(AbstractPlayer player) {
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
