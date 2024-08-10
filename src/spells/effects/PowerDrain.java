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
public class PowerDrain implements SpellEffect {

	private final int amount;

	/**
	 * 
	 */
	public PowerDrain(int amt) {
		super();
		amount = amt;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(WizardInterface target) {
		StatusPanel sp = target.getMyStats();
		int power = sp.getPower();
		int drain = Math.min(power, amount);
		sp.addPower(-drain);
		// Small hack
		if (drain < 0) {
			drain = -drain;
		}
		GamePanel.getOpponent(target).getMyStats().addPower(drain);
	}

}
