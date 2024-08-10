/*
 * Created on Oct 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells;

import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 */
public interface SpellInterface {

	void effect(WizardInterface target);

	int getLevel();
}
