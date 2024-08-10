/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells.effects;

import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 */
public class Damage implements SpellEffect {

	private final int amount;

	/**
	 * 
	 */
	public Damage(int amt) {
		super();
		amount = amt;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(WizardInterface target) {
		target.getMyStats().burn(amount);
	}

}
