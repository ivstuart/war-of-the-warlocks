/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package graphics;

import game.GameManager;

import java.awt.Font;
import java.awt.Graphics2D;

/**
 * @author Ivan Stuart
 */
public class MessageSprite extends Sprite {

	public static final int FONT_SIZE = 40;

	private static final String[] messages = { "GET READY", "GET READY.",
			"GET READY..", "GET READY...", "  FIGHT!" };

	private int counter = 0;

	private String message = "GET READY";

	private final Font sansBold = new Font("SansSerif", Font.BOLD, FONT_SIZE);

	/**
	 * 
	 */
	public MessageSprite() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(sansBold);
		g.drawString(message, x, y);
	}

	@Override
	public boolean isCollision(Sprite sp) {
		return false;
	}

	public void reset() {
		counter = 0;
		message = messages[counter];
	}

	public void setMessage(String aString) {
		message = aString;
	}

	/**
	 * 
	 */
	public void update() {
		// TODO Auto-generated method stub
		counter++;
		if (counter < messages.length) {
			message = messages[counter];
		}
		if (counter == messages.length) {
			message = "";
			GameManager.setPaused(false);
		}

	}

}
