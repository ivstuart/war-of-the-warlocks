/*
 * Created on Oct 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package game;

import graphics.GamePanel;
import graphics.GraphicsManager;
import graphics.StatusPanel;
import sound.AudioCache;
import wizDesigner.DesignerPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Ivan Stuart
 */
public class ScreenManager {

	private final JFrame frame;
	private final Container pane;

	private DesignerPanel designPanel;
	private GamePanel gamePanel;

	public static GraphicsManager gManager;

	private StatusPanel status1;
	private StatusPanel status2;

	public ScreenManager() {

		frame = new JFrame("War Of The Warlocks (WOTW) v4.0 10-08-2024");

		pane = frame.getContentPane();

		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gManager = new GraphicsManager(frame.getGraphicsConfiguration());

        try {
            gManager.loadImages();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.initialise();

		frame.pack();

		frame.setVisible(true);

	}

	/**
	 * @return Returns the frame.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return Returns the gManager.
	 */
	public GraphicsManager getGManager() {
		return gManager;
	}

	public Container getPane() {
		return pane;
	}

	/**
	 * @return Returns the status1.
	 */
	public StatusPanel getStatus1() {
		return status1;
	}

	/**
	 * @return Returns the status2.
	 */
	public StatusPanel getStatus2() {
		return status2;
	}

	/**
	 * 
	 */
	private void initialise() {
		status1 = new StatusPanel();
		status2 = new StatusPanel();

		JPanel playerStatus = new JPanel();

		playerStatus.add(status1);
		playerStatus.add(status2);

		pane.add(playerStatus, BorderLayout.NORTH);

		designPanel = new DesignerPanel();

		gamePanel = new GamePanel(this);

		pane.add(designPanel, BorderLayout.SOUTH);

	}

	public void repaintGame() {
		gamePanel.repaint();
	}

	public void startDesigner() {
		pane.remove(gamePanel);
		AudioCache.stop("music1");
		GameManager.setPaused(true);
		pane.add(designPanel, BorderLayout.SOUTH);
		frame.pack();
		designPanel.requestFocus();
	}

	public void startGame() {
		// IvanSound.loop("music1");
		status1.init(designPanel.getStats1());
		status2.init(designPanel.getStats2());

		gamePanel.initPlayerOneControls();
		if (designPanel.isAIon()) {
			gamePanel.setAIon();
		}
		else {
			gamePanel.initPlayerTwoControls();
		}
		pane.remove(designPanel);
		pane.add(gamePanel, BorderLayout.SOUTH);
		frame.pack();
		gamePanel.requestFocus();
		gamePanel.init();

	}

	public void update(long elapsedTime) {
		status1.update(elapsedTime);
		status2.update(elapsedTime);
	}
}
