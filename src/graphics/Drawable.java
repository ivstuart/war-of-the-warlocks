/*
 * Created on 25-Jun-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package graphics;

import java.awt.Graphics2D;

/**
 * @author default
 * 
 *         To change the template for this generated type comment go to
 *         Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface Drawable {

	public void draw(Graphics2D g);

	public void setPosition(float x, float y);
}
