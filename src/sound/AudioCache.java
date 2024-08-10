/*
 * Created on Oct 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Stuart
 */
public class AudioCache {

	private static final Map<String, AudioClip> soundMap = new HashMap<>();

	private static AudioClip getClip(String name) {
		return soundMap.get(name);
	}

	public static void loop(String name) {
		getClip(name).loop();
	}

	public static void play(String name) {
		getClip(name).play();
	}

	public static void stop(String name) {
		getClip(name).stop();
	}

	/**
	 * 
	 */
	public AudioCache() {
		super();
		init();
	}

	private void init() {
		loadSound("absorb", "absorb.wav");
		loadSound("zap1", "zap1.wav");
		loadSound("zap2", "zap2.wav");
		loadSound("zap3", "zap3.wav");
		loadSound("zap4", "zap4.wav");
		loadSound("zap5", "zap5.wav");
		loadSound("zap6", "zap6.wav");
		loadSound("zap7", "zap7.wav");
		loadSound("dead", "dead.wav");
		loadSound("music1", "music.wav");

		// Just for fun

		loadSound("1", "laff1.wav");
		loadSound("2", "laff2.wav");
		loadSound("3", "laff3.wav");
		loadSound("4", "laff4.wav");
		loadSound("5", "Ouch.wav");
		loadSound("6", "loser.wav");
		loadSound("7", "Illgetu.wav");

	}

	private void loadSound(String key, String filename) {
		URL url;
		try {
			url = ClassLoader.getSystemResource("sounds/" + filename);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		AudioClip clip = Applet.newAudioClip(url);

		soundMap.put(key, clip);
	}

}
