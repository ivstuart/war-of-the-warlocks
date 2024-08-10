/*
 * Created on Oct 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package wizDesigner;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Ivan Stuart
 */
public class WizardDesigner extends JPanel {

	protected class ButtonListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = arg0.getActionCommand();
			if (name.equals(healthButton.getActionCommand())) {
				addValue(healthText);
			} else if (name.equals(manaButton.getActionCommand())) {
				addValue(manaText);
			} else if (name.equals(regenButton.getActionCommand())) {
				addValue(regenText);
			} else if (name.equals(attackButton.getActionCommand())) {
				addValue(attackText);
			} else if (name.equals(defenceButton.getActionCommand())) {
				addValue(defenceText);
			}

		}

		private void addValue(TextField field) {
			String number = field.getText();
			int value = Integer.parseInt(number);
			int pool = Integer.parseInt(poolText.getText());
			if (pool < 1) {
				return;
			}
			value++;
			pool--;
			field.setText(String.valueOf(value));
			poolText.setText(String.valueOf(pool));
		}

	}

	private final JLabel pool = new JLabel("Pool");
	private final JLabel health = new JLabel("Health");
	private final JLabel mana = new JLabel("Mana");
	private final JLabel attack = new JLabel("M.Attack");
	private final JLabel defence = new JLabel("M.Defence");

	private final JLabel regen = new JLabel("Regeneration");
	private final TextField poolText = new TextField("25");

	private final JLabel poolButton = new JLabel("");
	private final TextField healthText = new TextField("100");

	private final JButton healthButton = new JButton("Add Hp");
	private final TextField manaText = new TextField("100");

	private final JButton manaButton = new JButton("Add Ma");
	private final TextField attackText = new TextField("100");

	private final JButton attackButton = new JButton("Add Att");
	private final TextField defenceText = new TextField("100");

	private final JButton defenceButton = new JButton("Add Def");
	private final TextField regenText = new TextField("100");

	private final JButton regenButton = new JButton("Add Reg");

	/**
	 * 
	 */
	public WizardDesigner() {
		super();
		setPreferredSize(new Dimension(600, 120));
		setLayout(new GridLayout(6, 3));

		this.add(pool);
		this.add(poolText);
		poolText.setEditable(false);
		poolText.setFocusable(false);

		this.add(poolButton);

		this.add(health);
		this.add(healthText);
		healthText.setEditable(false);
		healthText.setFocusable(false);
		this.add(healthButton);

		this.add(mana);
		this.add(manaText);
		manaText.setEditable(false);
		manaText.setFocusable(false);
		this.add(manaButton);

		this.add(attack);
		this.add(attackText);
		attackText.setEditable(false);
		attackText.setFocusable(false);
		this.add(attackButton);

		this.add(defence);
		this.add(defenceText);
		defenceText.setEditable(false);
		defenceText.setFocusable(false);
		this.add(defenceButton);

		this.add(regen);
		this.add(regenText);
		regenText.setEditable(false);
		regenText.setFocusable(false);
		this.add(regenButton);

		ButtonListener but = new ButtonListener();

		healthButton.addActionListener(but);
		manaButton.addActionListener(but);
		attackButton.addActionListener(but);
		defenceButton.addActionListener(but);
		regenButton.addActionListener(but);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
