/*
 * Created on Oct 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package game;

import graphics.GamePanel;
import graphics.Sprite;
import sound.AudioCache;
import spells.effects.EffectFactory;

import javax.swing.*;
import java.util.List;

/**
 * @author Ivan Stuart
 */
public class GameManager {

	private static ScreenManager screen;

	private static WelcomePage wp;

	private final boolean running = true;

	//private long storedTime;

	private long elapsedTime;

	private boolean sleepOn = true;

	private static boolean paused = false;

	/**
	 * 
	 */
	public static void doneDesigning() {
		// TODO Auto-generated method stub
		System.out.println("ok");
		screen.startGame();
	}

	public static void setPaused(boolean flag) {
		paused = flag;
	}

	public GameManager() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		wp = new WelcomePage();

	}

	private void run() {

		//storedTime = System.currentTimeMillis();

		while (running) {

			if (sleepOn) {
				try {
					// Thread.sleep(20);
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (!paused) {
				updateSprites();
			}

			screen.repaintGame();

		}
	}

	public void startGame() {

		// wp.close();

		screen = new ScreenManager();

		wp.toFront();

		new AudioCache();

		new EffectFactory();

		this.run();
	}

	/**
	 *  
	 */
	private void updateSprites() {
		List<Sprite> spriteList = GamePanel.getSprites();

		if (null == spriteList) {
			return;
		}

		elapsedTime = 30; // 8; // 16

		screen.update(elapsedTime);

        for (Sprite sprite : spriteList) {
            sprite.update(elapsedTime);
        }

	}
}