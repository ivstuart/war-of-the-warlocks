/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 */
public class CastDefence extends CanBePressed {

	/**
	 * 
	 */
	public CastDefence(WizardInterface aWizard) {
		super(aWizard);
	}

	@Override
	public void pressed() {
		super.getWizard().castDefence();
	}

}
