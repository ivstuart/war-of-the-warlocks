/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package graphics;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author Ivan Stuart
 */
public class GraphicsManager {

	private final Map<String, Image> map = new HashMap<>();

	private final GraphicsConfiguration graphicsConfiguration;

	/**
	 *  
	 */
	public GraphicsManager(GraphicsConfiguration gConfig) {
		super();
		graphicsConfiguration = gConfig;

	}

	public Image getFlippedImage(Image image) {
		return getScaledImage(image, 1, -1);
	}

	public Image getImage(String name) {

		return map.get(name);
	}

	public Image getMirrorImage(Image image) {
		return getScaledImage(image, -1, 1);
	}

	private Image getScaledImage(Image image, float x, float y) {

		// set up the transform
		AffineTransform transform = new AffineTransform();
		transform.scale(x, y);
		transform.translate((x - 1) * image.getWidth(null) / 2,
				(y - 1) * image.getHeight(null) / 2);

		// create a transparent (not translucent) image
		Image newImage = graphicsConfiguration.createCompatibleImage(image.getWidth(null),
				image.getHeight(null), Transparency.BITMASK);

		// draw the transformed image
		Graphics2D g = (Graphics2D) newImage.getGraphics();
		g.drawImage(image, transform, null);
		g.dispose();

		return newImage;
	}

	/**
	 * Gets an image from the images/ directory.
	 */
	public Image loadImage(String name) {

		String filename = "images\\" + name;
		System.out.println("Name= " + filename);
		Image icon = new ImageIcon(filename).getImage();
		System.out.println("Image= " + icon);
		return icon;
	}

	public void loadImages() throws IOException {
		System.out.println("Loading graphics into memory!");

		String imageDirectory = "images/";

		Image image = readImage(imageDirectory+"background.png");
		map.put("background", image);

		image = readImage(imageDirectory+"wiz_left_01.png");
		map.put("wizard1", image);

		image = readImage(imageDirectory+"wiz_right_01.png");
		map.put("wizard2", image);

		image = readImage(imageDirectory+"W1_death.png");
		map.put("death1", image);

		image = readImage(imageDirectory+"W2_death.png");
		map.put("death2", image);

		loadSpells();

	}

	private Image readImage(String path) throws IOException {
		URL url = ClassLoader.getSystemResource(path);
		return ImageIO.read(url);
	}

	private void loadSpellImages(String type) throws IOException {

		for (int level = 1; level < 6; level++) {
			String identifier = level + type;
			String imageName = "images/L" + identifier + ".png";
			//String reverseName = "reverse/L" + identifier + ".png";

			Image image = readImage(imageName);
			map.put(identifier, image);

			// image = readImage(reverseName);
			image = getMirrorImage(image);
			map.put(identifier + "r", image);
		}
	}

	private void loadSpells() throws IOException {
		loadSpellImages("a");
		loadSpellImages("d");
		loadSpellImages("t");
		loadSpellImages("o");
	}

	public BufferedImage imageToBufferedImage(Image image) throws IllegalArgumentException {
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Image dimensions are invalid");
		}
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return bufferedImage;
	}
}