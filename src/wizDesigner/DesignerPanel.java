/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package wizDesigner;

import game.GameManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Ivan Stuart
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class DesignerPanel extends JPanel {

	private final JWizardDesigner wd1;
	private final JWizardDesigner wd2;

	private final JButton okButton;

	private final ButtonGroup aiGroup;
	private final JPanel aJPanel = new JPanel();

	/**
	 * 
	 */
	public DesignerPanel() {
		super();
		// this.setLayout(new FlowLayout());
		GridLayout layout = new GridLayout(0, 2);
		layout.setVgap(20);
		this.setLayout(layout);
		wd1 = new JWizardDesigner("Wizard 1");
		wd2 = new JWizardDesigner("Wizard 2");

		this.add(wd1);
		this.add(wd2);

		okButton = new JButton("Done");
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(okButton, BorderLayout.NORTH);
		this.add(p);

		okButton.addActionListener(arg0 -> GameManager.doneDesigning());
		aiGroup = new ButtonGroup();

		this.add(aJPanel);

		addRadioButton("1 player vs CPU", "1p");
		addRadioButton("2 player", "2p");
	}

	private void addRadioButton(String string, String commandName) {
		// TODO Auto-generated method stub
		JRadioButton jrb = new JRadioButton(string, true);
		jrb.setActionCommand(commandName);
		aiGroup.add(jrb);
		aJPanel.add(jrb);
	}

	public int[] getStats1() {
		return wd1.getValues();
	}

	public int[] getStats2() {
		return wd2.getValues();
	}

	public boolean isAIon() {
		return aiGroup.getSelection().getActionCommand().equals("1p");
	}

}
