/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import game.GameManager;
import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 *
 */
public class PauseGame extends CanBePressed {

	/**
	 * 
	 */
	public PauseGame(WizardInterface aWizard) {
		super(null);
	}

	@Override
	public void pressed() {
		GameManager.setPaused(true);
	}

}
