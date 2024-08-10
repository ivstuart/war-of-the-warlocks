/*
 * Created on Nov 4, 2004
 *
 */
package controller;

import java.util.HashMap;

/**
 * @author Ivan Stuart
 * 
 */
public class UserInput {

	private final HashMap<String, CanBePressed> keys;

	public UserInput() {
		super();
		keys = new HashMap<>();
	}

	/**
	 * 
	 * @param keyString action key to press
	 */
	public void keyAction(String keyString) {

		CanBePressed key = keys.get(keyString);

		if (key != null) {
			key.pressed();
		}
	}
}
