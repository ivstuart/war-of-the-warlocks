/*
 * Created on Oct 9, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package graphics;

import sound.AudioCache;
import spells.AttackSpell;
import spells.DefenceSpell;

import java.awt.*;

/**
 * @author Ivan Stuart
 */
public class Wizard extends Sprite implements WizardInterface {

	public static final float MOVE_SPEED = 0.1F;
	public static final int MIN_CAST_MANA = 80;

	private final StatusPanel myStats;
	private final int direction;

	private boolean isDead = false;

	private int lowerBound;
	private int upperBound;

	private String winMessage;

	/**
	 * 
	 */
	public Wizard(StatusPanel sp, Image image, int location, int facing) {
		super(image);
		myStats = sp;
		this.y = 500;
		this.x = location;
		this.width -= 12;
		direction = facing;

		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphics.WizardInterface#castAttack(java.lang.String)
	 */
	@Override
	public void castAttack(String type) {
		int power = myStats.cast();
		if (power < MIN_CAST_MANA) {
			return;
		}
		castAttack(type, power);
	}

	/**
	 * Damage attacking spells
	 * 
	 * @param power power
	 */
	private void castAttack(String type, int power) {

		AttackSpell spell = new AttackSpell(type, this, direction, power);

		// TODO refactor this
		if (type.equals("o")) {
			AudioCache.play("zap1");
		} else {
			AudioCache.play("zap4");
		}

		GamePanel.getSprites().add(spell);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphics.WizardInterface#castDefence()
	 */
	@Override
	public void castDefence() {
		// TODO Auto-generated method stub
		int power = myStats.cast();
		if (power < MIN_CAST_MANA) {
			return;
		}
		castDefence(power);
	}

	/**
	 * @param power power
	 */
	private void castDefence(int power) {

		DefenceSpell spell = new DefenceSpell(this, direction, power);

		AudioCache.play("zap3");

		GamePanel.getSprites().add(spell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphics.WizardInterface#getDirection()
	 */
	@Override
	public int getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}

	/**
	 * @return Returns the myStats.
	 */
	@Override
	public StatusPanel getMyStats() {
		return myStats;
	}

	/**
	 * @return Returns the winMessage.
	 */
	@Override
	public String getWinMessage() {
		return winMessage;
	}

	/**
	 * @return Returns the isDead.
	 */
	@Override
	public boolean isDead() {
		return isDead;
	}

	/**
	 * @param keyChar key character
	 */
	@Override
	public void keyAction(char keyChar) {
		if (isDead) {
			return;
		}

		if (keyChar == '1') {
			GamePanel.restart();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphics.WizardInterface#manaBuildUp()
	 */
	@Override
	public void manaBuildUp() {
		myStats.channelMana();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphics.WizardInterface#move(int)
	 */
	@Override
	public void move(int direction) {
		this.dx += MOVE_SPEED * direction;
	}

	@Override
	public void setBounds(int lower, int upper) {
		lowerBound = lower;
		upperBound = upper;
	}

	/**
	 * @param isDead
	 *            The isDead to set.
	 */
	@Override
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/**
	 * @param winMessage
	 *            The winMessage to set.
	 */
	@Override
	public void setWinMessage(String winMessage) {
		this.winMessage = winMessage;
	}

	@Override
	public void update(long elapsedTime) {
		super.update(elapsedTime);

		// TODO move into Sprite class?
		if (x < lowerBound) {
			dx = 0; // stops movement
			x = lowerBound;
			return;
		}

		if (x > upperBound) {
			dx = 0;// stops movement
			x = upperBound;
		}
	}
}
