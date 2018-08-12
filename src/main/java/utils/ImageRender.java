package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRender {
	private static Image getScaledImage(String imageUrl, JLabel component) {
		Image image = null;
		try {
			BufferedImage bufferedImage  = ImageIO.read(new File(imageUrl));
			image =  bufferedImage.getScaledInstance(component.getPreferredSize().width, component.getPreferredSize().height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static ImageIcon getImageIcon(String imageUrl, JLabel component) {
		ImageIcon imageIcon = new ImageIcon(getScaledImage(imageUrl, component));
		return imageIcon;
	}
}
