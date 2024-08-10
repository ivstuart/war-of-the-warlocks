/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import graphics.WizardInterface;
import sound.AudioCache;

/**
 * @author Ivan Stuart
 */
public class MusicOn extends CanBePressed {

	/**
	 * 
	 */
	public MusicOn(WizardInterface wizard) {
		super(null);
	}

	@Override
	public void pressed() {
		AudioCache.loop("music1");
	}

}
