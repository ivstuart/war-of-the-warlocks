/*
 * Created on Nov 5, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package spells.effects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Stuart
 */
public class EffectFactory {

	private static final Map<String, SpellEffect> effectMap = new HashMap<>();

	public static SpellEffect getEffect(String code) {
		return effectMap.get(code);
	}

	/**
	 * 
	 */
	public EffectFactory() {
		super();

		this.init();
	}

	private void init() {

		// Attack spells
		effectMap.put("1a", new Damage(5));
		effectMap.put("2a", new Damage(10));
		effectMap.put("3a", new Damage(20));
		effectMap.put("4a", new Damage(35));
		effectMap.put("5a", new Damage(50));

		// Defence spells
		effectMap.put("1d", new Damage(3));
		effectMap.put("2d", new Damage(4));
		effectMap.put("3d", new Damage(5));
		effectMap.put("4d", new Damage(6));
		effectMap.put("5d", new Damage(7));

		// Drain spells
		effectMap.put("1t", new PowerDrain(200));
		effectMap.put("2t", new PowerDrain(500));
		effectMap.put("3t", new ManaDrain(300));
		effectMap.put("4t", new ManaDrain(800));
		effectMap.put("5t", new HealthDrain(500));

		// Posion Spells and boost opponent mana
		effectMap.put("1o", new CurePoison(0));
		effectMap.put("2o", new Poison(500));
		effectMap.put("3o", new Poison(300));
		effectMap.put("4o", new PowerDrain(-350));
		effectMap.put("5o", new PowerDrain(-479));

	}

}
