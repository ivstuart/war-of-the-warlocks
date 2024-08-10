/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells.effects;

import graphics.GamePanel;
import graphics.StatusPanel;
import graphics.WizardInterface;

/**
 * @author Ivan Stuart
 */
public class HealthDrain implements SpellEffect {

	private final int amount;

	/**
	 * 
	 */
	public HealthDrain(int amt) {
		super();
		amount = amt;
	}

	@Override
	public void effect(WizardInterface target) {
		StatusPanel sp = target.getMyStats();
		int health = sp.getHealth() / 2;
		int drain = Math.min(health, amount);
		sp.addPower(-drain);
		GamePanel.getOpponent(target).getMyStats().addPower(drain);
	}

}
