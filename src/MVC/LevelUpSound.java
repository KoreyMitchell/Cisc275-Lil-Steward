package MVC;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class LevelUpSound.
 */
public class LevelUpSound implements Runnable {
	
	/** The t. */
	HashMap<String, MakeSong> t;
	
	/** The level. */
	int level;
	
	/**
	 * Instantiates a new level up sound.
	 *
	 * @param n the n
	 * @param level the level
	 */
	public LevelUpSound(HashMap<String, MakeSong> n, int level) {
		this.level = level;
		this.t = n;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(level>1) {
		//t.get("levelUp").playSound();
		}
	}

	

}
