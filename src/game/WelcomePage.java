/*
 * Created on Nov 5, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author Ivan Stuart
 */
public class WelcomePage {

	public static final int FONT_SIZE = 14;

	private final Font courier = new Font("Courier", Font.BOLD, FONT_SIZE);

	public final String message = "Welcome to War of the Warlocks.\n\n"
			+ "The aim of this game is to defeat your opponent by reducing their\n"
			+ "energy to zero (the green bar). This is achieved by casting spells.\n"
			+ "To create a spell your need mana (the blue bar). Mana is channeled into\n"
			+ "a spell, the amount of mana channeled is shown by the red bar, but be careful\n"
			+ "if you try to control too much magic then you might lose control!\n"
			+ "The more mana used to cast a spell the more power it is. Defensive spells can\n"
			+ "be cast to reflect or reduce the spell coming towards you.\n"
			+ "\nControls are:\n" + "Player One             Player Two\n"
			+ "----------             -----------\n"
			+ "    z <channeling on/off>   l\n"
			+ "    x  <cast defensive>     k\n"
			+ "    c  <cast attacking>     j\n"
			+ "    v   < cast drain>       h\n"
			+ "    b   < cast misc >       g\n\n"
			+ "    a   < move left >       o\n"
			+ "    s   < move right>       p\n\n" + "    n   <music  off>\n"
			+ "    m   <music  on >\n" + "    0   <pause  game>\n"
			+ "    1   <resume game>\n";

	private final JButton ok;

	private final JFrame frame;

	private final Container pane;

	public WelcomePage() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		frame = new JFrame("Welcome Page - Instructions");

		pane = frame.getContentPane();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

		frame.setVisible(true);

		JTextArea ta = new JTextArea();
		ta.setFont(courier);
		ta.setText(message);
		ta.setEditable(false);

		// TODO Auto-generated constructor stub
		ok = new JButton("DONE");

		ok.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            frame.dispose();
        });

		pane.add(ta, BorderLayout.WEST);
		pane.add(ok, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * 
	 */
	public void toFront() {
		// TODO Auto-generated method stub
		frame.toFront();
	}

}
