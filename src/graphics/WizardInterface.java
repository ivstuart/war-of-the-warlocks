/*
 * Created on Oct 11, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package graphics;

/**
 * @author Ivan Stuart
 */
public interface WizardInterface {

	void castAttack(String type);

	void castDefence();

	int getDirection();

	StatusPanel getMyStats();

	String getWinMessage();

	boolean isDead();

	void keyAction(char keyChar);

	void manaBuildUp();

	void move(int direction);

	void setBounds(int i, int j);

	void setDead(boolean death);

	void setWinMessage(String string);

	void update(long elapsedTime);
}
