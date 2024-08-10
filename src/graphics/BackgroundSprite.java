/*
 * Created on Oct 10, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package graphics;

import java.awt.Image;

/**
 * @author Ivan Stuart
 */
public class BackgroundSprite extends Sprite {

	/**
	 * @param aImage
	 */
	public BackgroundSprite(Image aImage) {
		super(aImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCollision(Sprite sp) {
		return false;
	}

}
