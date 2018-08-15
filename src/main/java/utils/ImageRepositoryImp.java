package utils;

import enums.HeroType;
import factory.HeroFactory;
import models.players.APlayer;
import models.players.Hero;
import repository.IImageRepository;
import views.gui.windows.arena.MapCell;
import views.gui.windows.choosehero.HeroCell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageRepositoryImp implements IImageRepository {
	public static ImageRepositoryImp imageRepositoryImp;
	public final String imageUrl = "/images/";
	public final String imageExtension = ".jpg";
	Dimension dimension = new Dimension();
	
	private HashMap<String, Object> images = new HashMap<>();
	
	public static ImageRepositoryImp getInstance(){
		if (imageRepositoryImp == null)
			imageRepositoryImp = new ImageRepositoryImp();
		return imageRepositoryImp;
	}
	
	private Image getScaledImage(String imageName, Dimension dimension) {
		String imagePath;
		
		String url = imageUrl + imageName + imageExtension;
		try {
			imagePath =  getClass().getResource(url).getPath();
		} catch (Exception e) {
			return null;
		}
		
		Image image = null;
		String imageStringHash = "scaled" + imagePath + dimension.width + dimension.height;
		try {
			if (images.get(imageStringHash) != null)
				return (Image) images.get(imageStringHash);
			BufferedImage bufferedImage  = ImageIO.read(new File(imagePath));
			image =  bufferedImage.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
			images.put(imageStringHash, image);
		} catch (Exception e) {
			e.printStackTrace();
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
			images.put(imageStringHash, image);
		}
		return imageIcon;
	}
	
	public  void loadCache(APlayer player) {
		getImageIcon(player.getPicture(), MapCell.MAP_CELL_MIN_WIDTH, MapCell.MAP_CELL_MIN_HEIGHT);
		
		getImageIcon(player.getPicture(), MapCell.MAP_CELL_MAX_WIDTH, MapCell.MAP_CELL_MAX_HEIGHT);
		
		getImageIcon(player.getPicture(), HeroCell.HERO_CELL_WIDTH, HeroCell.HERO_CELL_HEIGHT);
	}
	
	public ImageIcon getImageIcon(String imagePath, int width, int height) {
		dimension.width = width;
		dimension.height = height;
		
		return  getImageIcon(imagePath, dimension);
	}
}
