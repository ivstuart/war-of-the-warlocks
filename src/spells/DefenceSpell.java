/*
 * Created on Oct 10, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells;

import game.ScreenManager;
import graphics.Sprite;
import graphics.WizardInterface;
import spells.effects.EffectFactory;
import spells.effects.SpellEffect;

/**
 * @author Ivan Stuart
 *         Rules for defence effect on attack spells.
 *         1 absorb 1
 *         2 absorb 1 reflect 1
 *         3 absorb 2 reflect 1
 *         4 absorb 2 reflect 2
 *         5 absorb 3 reflect 2
 */
public class DefenceSpell extends Sprite implements SpellInterface {

	private final Sprite myWizard;
	private final int myDirection;
	private final int level;
	// private int power;

	private final SpellEffect effect;

	public DefenceSpell(Sprite wizard, int direction, int pwr) {
		myWizard = wizard;
		// power = pwr;
		myDirection = direction;
		level = pwr / 80;
		String spellString = level + "d";
		effect = EffectFactory.getEffect(spellString);
		if (direction == -1) {
			spellString = spellString + "r";
		}
		this.image = ScreenManager.gManager.getImage(spellString);
		this.setSize();
		this.x = myWizard.getX()
				+ ((this.width + myWizard.getWidth()) * direction);
		if (direction < 0) {
			this.x += myWizard.getWidth();
		}
		this.y = myWizard.getY() + 90 - ((float) this.height / 2);
		this.dx = 0.2F * direction;

	}

	/*
	 * This has been refactored
	 */
	@Override
	public void effect(WizardInterface target) {
		effect.effect(target);
	}

	public int getAbsorb() {
		return (level + 1) / 2;
	}

	public int getDirection() {
		// TODO Auto-generated method stub
		return myDirection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see spells.SpellInterface#getLevel()
	 */
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	public int getReflect() {
		return level / 2;
	}

	public Sprite getWizard() {
		// TODO Auto-generated method stub
		return myWizard;
	}

	@Override
	public boolean isCollision(Sprite sp) {
		// This next line does not work.
		if (sp == myWizard) {
			return false;
		}
		return super.isCollision(sp);
	}

}
