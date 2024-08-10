package graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Sprite {

	protected Image image;

	// position (pixels)
	protected float x;
	protected float y;

	// velocity (pixels per millisecond)
	protected float dx;
	protected float dy;

	// dimensions of sprite
	protected int height;
	protected int width;

	protected int rotation=0; // angle in degrees

	public Sprite() {

	}

	/**
	 * Creates a new Sprite object with the specified Animation.
	 */
	public Sprite(Image myImage) {
		image = myImage;
		this.setSize();
	}

	public void setRotation(int angle) {
		rotation = angle;
	}

	/**
	 * @param g graphics2D
	 */
	public void draw(Graphics2D g) {

		// TODO try to draw rotation myself using rotation variable

		if (rotation != 0) {
			rotateThenDrawImage(g, image);
			rotation += 5 * Math.signum(rotation);
			return;
		}

		g.drawImage(image, this.getX(), this.getY(), null);
	}

	public void rotateThenDrawImage(Graphics2D g, Image localImage) {
		Graphics2D g2D = (Graphics2D) g.create();
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.rotate(Math.toRadians(rotation), width/2, height/2);
		g2D.translate(this.getX(), this.getY());
		g2D.drawImage(localImage,affineTransform,null);
		g2D.dispose();
	}



	/**
	 * @return Returns the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return Returns the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets this Sprite's current x position.
	 */
	public int getX() {
		return Math.round(x);
	}

	/**
	 * Gets this Sprite's current y position.
	 */
	public int getY() {
		return Math.round(y);
	}

	public boolean isCollision(Sprite sp) {
		int spX = sp.getX();
		int spY = sp.getY();

		// check if the two sprites' boundaries intersect
		return (x + width > spX && y + height > spY && x < spX + sp.getWidth() && y < spY
				+ sp.getHeight());

	}

	public void mirrorVertically() {

	}

	protected void setSize() {
		if (image != null) {
			height = image.getHeight(null);
			width = image.getWidth(null);
		}
	}

	/**
	 * Sets this Sprite's current x position.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets this Sprite's current y position.
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Updates this Sprite's Animation and its position based on the velocity.
	 */
	public void update(long elapsedTime) {
		x += dx * elapsedTime;
		y += dy * elapsedTime;
		// if animation update when need to
	}

}
