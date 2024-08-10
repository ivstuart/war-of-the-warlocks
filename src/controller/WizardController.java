/*
 * Created on Oct 9, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Ivan Stuart
 */

public class WizardController implements KeyListener {

	private UserInput userInput;

	/**
	 * 
	 */
	public WizardController(UserInput aUser) {
		super();
		userInput = aUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		userInput.keyAction(String.valueOf(arg0.getKeyChar()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
