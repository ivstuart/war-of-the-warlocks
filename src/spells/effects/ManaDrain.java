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
public class ManaDrain implements SpellEffect {

	private final int amount;

	/**
	 * 
	 */
	public ManaDrain(int amt) {
		super();
		amount = amt;
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see spells.spellEffect#effect(graphics.WizardInterface)
	 */
	@Override
	public void effect(WizardInterface target) {
		// TODO Auto-generated method stub
		StatusPanel sp = target.getMyStats();
		int mana = sp.getMana();
		int drain = Math.min(mana, amount);
		sp.addMana(-drain);
		GamePanel.getOpponent(target).getMyStats().addMana(drain);
	}

}
