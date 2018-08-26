package za.co.wethinkcode.mmayibo.swingy.utils;

import za.co.wethinkcode.mmayibo.swingy.repository.IImageRepository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class ImageRepositoryImp implements IImageRepository {
	private static ImageRepositoryImp imageRepositoryImp;
	private final Dimension dimension = new Dimension();
	private final HashMap<String, Object> images = new HashMap<>();
	
	public static ImageRepositoryImp getInstance(){
		if (imageRepositoryImp == null)
			imageRepositoryImp = new ImageRepositoryImp();
		return imageRepositoryImp;
	}
	
	
	public static BufferedImage getScaledImage(BufferedImage image, int width, int height) {
		int imageWidth  = image.getWidth();
		int imageHeight = image.getHeight();
		
		double scaleX = (double)width/imageWidth;
		double scaleY = (double)height/imageHeight;
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
		AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);
		
		return bilinearScaleOp.filter(
				image,
				new BufferedImage(width, height, image.getType()));
	}

	public BufferedImage getBufferedImage(String imageName) {
        String imageStringHash = "buffered" + imageName;
		String imageExtension = ".jpg";
		String imageUrl = "/images/";
		String url = imageUrl + imageName + imageExtension;

        if (images.get(imageStringHash) != null)
            return (BufferedImage) images.get(imageStringHash);
        try {


            BufferedImage bufferedImage  =  ImageIO.read(getClass().getResourceAsStream(url));
            images.put(imageStringHash, bufferedImage);
            return bufferedImage;
        } catch (IOException e) {
            return null;
        }
    }
	
	private Image getScaledImage(String imageName, Dimension dimension) {

		Image image;
		String imageStringHash = "scaled" + imageName;
		try {
			image  =  (Image) images.get(imageStringHash);
			if (image == null) {
				BufferedImage bufferedImage  = getBufferedImage(imageName);
				image =  bufferedImage.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
				images.put(imageStringHash, image);
			}
			else
				image = image.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			return null;
		}
		return image;
	}
	
	private ImageIcon getImageIcon(String imageUrl, Dimension dimension) {
		
		String imageStringHash = "imageicon" + imageUrl + dimension.width + dimension.height;
		if (images.get(imageStringHash) != null){
			return (ImageIcon) images.get(imageStringHash);
		}
		Image image = getScaledImage(imageUrl, dimension);
		ImageIcon imageIcon = null;
		
		if (image != null) {
			imageIcon = new ImageIcon(image);
			images.put(imageStringHash, imageIcon);
		}
		return imageIcon;
	}
	
    public  void loadCache(String picture) {
	    getBufferedImage(picture);
    }
}