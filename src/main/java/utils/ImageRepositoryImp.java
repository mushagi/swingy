package utils;

import repository.IImageRepository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageRepositoryImp implements IImageRepository {
	public static HashMap<String, Object> images = new HashMap<>();
	
	public static Image getScaledImage(String imageUrl, Dimension dimension) {

		Image image = null;
		String imageStringHash = "scaled" + imageUrl + dimension.width + dimension.height;
		try {
			if (images.get(imageStringHash) != null)
				return (Image) images.get(imageStringHash);
			BufferedImage bufferedImage  = ImageIO.read(new File(imageUrl));
			image =  bufferedImage.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
			images.put(imageStringHash, image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static BufferedImage getScaledBufferedImage(String imageUrl) {
		BufferedImage image = null;
		String imageStringHash = imageUrl + "bufferedImage";
		
		try {
			if (images.get(imageStringHash) != null)
				return (BufferedImage) images.get(imageUrl);
			image = ImageIO.read(new File(imageUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static ImageIcon getImageIcon(String imageUrl, Dimension dimension) {
		String imageStringHash = "icon" + imageUrl + dimension.width + dimension.height;
		if (images.get(imageStringHash) != null)
			return (ImageIcon) images.get(imageStringHash);
		
		ImageIcon imageIcon = new ImageIcon(getScaledImage(imageUrl, dimension));
		return imageIcon;
	}
	
	public static void loadCache() {
		Dimension  dimension = new Dimension();
		
		//ImageRepositoryImp.getImageIcon(getClass().getResource("/images/blackpanther.jpg").getPath(), new D);
	}
}
