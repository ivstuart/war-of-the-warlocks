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
public class CastAttack extends CanBePressed {

	private final String type;

	/**
	 * 
	 */
	public CastAttack(WizardInterface aWizard, String aType) {
		super(aWizard);
		type = aType;
	}

	@Override
	public void pressed() {
		super.getWizard().castAttack(type);
	}

}
