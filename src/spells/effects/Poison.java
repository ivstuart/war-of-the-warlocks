/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells.effects;

import graphics.StatusPanel;
import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 */
public class Poison implements SpellEffect {

	private final int amount;

	/**
	 * 
	 */
	public Poison(int amt) {
		super();
		amount = amt;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(WizardInterface target) {
		StatusPanel sp = target.getMyStats();
		sp.setPoisonFactor(amount, 0.1F);
	}

}
