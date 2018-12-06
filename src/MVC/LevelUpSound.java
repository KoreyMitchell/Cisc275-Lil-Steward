package MVC;

import java.util.HashMap;

public class LevelUpSound implements Runnable {
	HashMap<String, MakeSong> t;
	int level;
	
	public LevelUpSound(HashMap<String, MakeSong> n, int level) {
		this.level = level;
		this.t = n;
	}

	@Override
	public void run() {
		if(level>1) {
		//t.get("levelUp").playSound();
		}
	}

	

}
