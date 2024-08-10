/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controller;

import graphics.GamePanel;
import graphics.WizardInterface;

import javax.swing.*;

/**
 * @author Ivan Stuart
 */
public class UserInputFactory {

	public static int NUMBER_OF_KEYS = 7;

	public static void create(GamePanel gamePanel, WizardInterface aWizard, String keys, boolean isPlayerOne)
			throws Exception {

		if (keys.length() != NUMBER_OF_KEYS) {
			throw new Exception("Incorrect number of user input keys defined!");
		}

		setupKeyStroke(gamePanel, new Move(aWizard, -1), keys.substring(0, 1));
		setupKeyStroke(gamePanel, new Move(aWizard, 1), keys.substring(1, 2));

		setupKeyStroke(gamePanel, new ManaBuildUp(aWizard) , keys.substring(2, 3));
		setupKeyStroke(gamePanel, new CastDefence(aWizard), keys.substring(3, 4));
		setupKeyStroke(gamePanel, new CastAttack(aWizard, "a"), keys.substring(4, 5));
		setupKeyStroke(gamePanel, new CastAttack(aWizard, "t"), keys.substring(5, 6));
		setupKeyStroke(gamePanel, new CastAttack(aWizard, "o"), keys.substring(6, 7));

		if (isPlayerOne) {
			setupKeyStroke(gamePanel, new MusicOff(null), "n");
			setupKeyStroke(gamePanel, new MusicOn(null), "m");

			setupKeyStroke(gamePanel, new PauseGame(null), "0");
			setupKeyStroke(gamePanel, new UnPauseGame(null), "1");
		}

	}

	private static void setupKeyStroke(GamePanel gamePanel, Action action, String key) {
		gamePanel.getInputMap().put(KeyStroke.getKeyStroke(key.charAt(0)),key);
		gamePanel.getActionMap().put(key, action);
	}

}
