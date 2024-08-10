/*
 * Created on Nov 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package wizDesigner;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * @author Ivan Stuart
 */
public class JWizardDesigner extends JPanel {

	class WizardSpinnerModel extends SpinnerNumberModel {

		public WizardSpinnerModel(int i, int j, int k, int l) {
			super(i, j, k, l);
		}

		@Override
		public Object getNextValue() {
			if (getPoolPoints() == 0) {
				return super.getValue();
			}
			return super.getNextValue();
		}

		@Override
		public void setValue(Object value) {
			int number;
			try {
				number = Integer.parseInt(value.toString());
			} catch (NumberFormatException e) {
				number = 120;
			}

			int newTotal = getPool() + (Integer) super.getValue()
					- number;

			if (newTotal < 0) {
				super.setValue(super.getValue());
				throw new IllegalArgumentException();
			}
			super.setValue(value);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8424038577916326403L;

	public static final int TOTAL_POINTS = 280;

	private final JLabel poolLabel;
	private final JSpinner healthSpinner;
	private final JSpinner manaSpinner;
	private final JSpinner mAttackSpinner;
	private final JSpinner mDefenceSpinner;
	private final JSpinner healthRegenSpinner;

	private final JSpinner manaRegenSpinner;

	/**
	 * POOL - 20 points? health mana magical attack magical defence health regen
	 * mana regen
	 */
	public JWizardDesigner(String name) {
		super();

		poolLabel = new JLabel("20");

		this.add(new JLabel(name));
		this.add(new JLabel(""));

		this.add(new JLabel("Pool"));
		this.add(poolLabel);

		this.setLayout(new GridLayout(0, 2));

		healthSpinner = new JSpinner(new WizardSpinnerModel(100, 80, 160, 1));
		manaSpinner = new JSpinner(new WizardSpinnerModel(100, 80, 120, 1));
		mAttackSpinner = new JSpinner(new WizardSpinnerModel(20, 10, 40, 1));
		mDefenceSpinner = new JSpinner(new WizardSpinnerModel(40, 30, 80, 1));
		healthRegenSpinner = new JSpinner(new WizardSpinnerModel(0, 0, 20, 1));
		manaRegenSpinner = new JSpinner(new WizardSpinnerModel(0, 0, 20, 1));

		this.addRow("Health", healthSpinner);
		this.addRow("Mana", manaSpinner);
		this.addRow("Magical Attack", mAttackSpinner);
		this.addRow("Magical Defence", mDefenceSpinner);
		this.addRow("Health Regeneration", healthRegenSpinner);
		this.addRow("Mana Regeneration", manaRegenSpinner);

		// TODO Auto-generated constructor stub
	}

	public void addRow(String labelText, final JSpinner spinner) {
		this.add(new JLabel(labelText));
		this.add(spinner);
		spinner.addChangeListener(arg0 -> {
            // Object value = spinner.getValue();
            poolLabel.setText(String.valueOf(getPool()));
        });

	}

	private int getPool() {
		int total = TOTAL_POINTS;
		total -= getSpinnerValue(healthSpinner);
		total -= getSpinnerValue(manaSpinner);
		total -= getSpinnerValue(mAttackSpinner);
		total -= getSpinnerValue(mDefenceSpinner);
		total -= getSpinnerValue(healthRegenSpinner);
		total -= getSpinnerValue(manaRegenSpinner);
		return total;
	}

	private int getPoolPoints() {
		return Integer.parseInt(poolLabel.getText());
	}

	private int getSpinnerValue(JSpinner spinner) {
		try {
			// return (Integer) spinner.getValue(); // Java 5.0
			return (Integer) spinner.getValue();
			// return Integer.parseInt(spinner.getValue().toString());
		} catch (NumberFormatException ignored) {
		}
		return 120;

	}

	public int[] getValues() {
		int[] scores = new int[6];
		scores[0] = getSpinnerValue(healthSpinner);
		scores[1] = getSpinnerValue(manaSpinner);
		scores[2] = getSpinnerValue(mAttackSpinner);
		scores[3] = getSpinnerValue(mDefenceSpinner);
		scores[4] = getSpinnerValue(healthRegenSpinner);
		scores[5] = getSpinnerValue(manaRegenSpinner);
		return scores;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
