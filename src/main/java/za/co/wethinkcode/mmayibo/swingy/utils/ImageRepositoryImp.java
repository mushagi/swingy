package za.co.wethinkcode.mmayibo.swingy.utils;

import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;
import za.co.wethinkcode.mmayibo.swingy.repository.IImageRepository;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.arena.MapCell;
import za.co.wethinkcode.mmayibo.swingy.views.gui.windows.choosehero.HeroCell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageRepositoryImp implements IImageRepository {
	private static ImageRepositoryImp imageRepositoryImp;
	private final String imageUrl = "/images/";
	private final String imageExtension = ".jpg";
	Dimension dimension = new Dimension();
	private HashMap<String, Object> images = new HashMap<>();
	
	public static ImageRepositoryImp getInstance(){
		if (imageRepositoryImp == null)
			imageRepositoryImp = new ImageRepositoryImp();
		return imageRepositoryImp;
	}
	
	
	public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
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
	public BufferedImage getBufferedImageNoCache(String imageName) {
		String imagePath;
		try {
			String url = imageUrl + imageName + imageExtension;
			imagePath =  getClass().getResource(url).getPath();
			BufferedImage bufferedImage  = ImageIO.read(new File(imagePath));
			return bufferedImage;
		} catch (IOException e) {
			return null;
		}
	}
 
	
	public Image getScaledImage(String imageName, Dimension dimension) {

		Image image = null;
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
	
	public  ImageIcon getImageIcon(String imageUrl, Dimension dimension) {
		
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
	
	public  void loadCache(AbstractPlayer player) {
		getImageIcon(player.getPicture());
		getImageIcon(player.getPicture());
		getImageIcon(player.getPicture());
	}
    public  void loadCache(String picture) {
	    getBufferedImage(picture);
    }
	
	public ImageIcon getImageIcon(String imagePath, int width, int height) {
		dimension.width = width;
		dimension.height = height;
		
		return  getImageIcon(imagePath, dimension);
	}

    public void getImageIcon(String lightgrass) {
        getImageIcon(lightgrass, MapCell.MAP_CELL_MIN_WIDTH, MapCell.MAP_CELL_MIN_HEIGHT);
        getImageIcon(lightgrass, MapCell.MAP_CELL_MAX_WIDTH, MapCell.MAP_CELL_MAX_HEIGHT);
        getImageIcon(lightgrass, HeroCell.HERO_CELL_WIDTH, HeroCell.HERO_CELL_HEIGHT);
    }
}