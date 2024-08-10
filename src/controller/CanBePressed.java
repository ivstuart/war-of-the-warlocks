/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import graphics.WizardInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Ivan Stuart
 *
 */
public abstract class CanBePressed extends AbstractAction {

	private final WizardInterface wizard;

	public CanBePressed(WizardInterface aWizard) {
		wizard = aWizard;
	}

	public WizardInterface getWizard() {
		return wizard;
	}

	public abstract void pressed();

	@Override
	public void actionPerformed(ActionEvent e) {
		this.pressed();
	}


}
