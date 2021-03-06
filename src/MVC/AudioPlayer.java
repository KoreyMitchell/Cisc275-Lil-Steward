package MVC;

import java.io.Serializable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// TODO: Auto-generated Javadoc
/**
 * The Class AudioPlayer.
 */
public class AudioPlayer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The clip. */
	private Clip clip;

	/**
	 * Instantiates a new audio player.
	 *
	 * @param s the s
	 */
	public AudioPlayer(String s) {
		
		try {
			
			AudioInputStream ais =
					AudioSystem.getAudioInputStream(
							getClass().getResourceAsStream(
									s
									)
							);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(),
					false
					);
					AudioInputStream dias =
					AudioSystem.getAudioInputStream(
							decodeFormat, ais);
					clip = AudioSystem.getClip();
					clip.open(dias);
							
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Play.
	 */
	public void play() {
		if(clip == null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
	
	/**
	 * Stop.
	 */
	public void stop() {
		if(clip.isRunning()) clip.stop();
	}

	/**
	 * Close.
	 */
	public void close() {
		stop();
		clip.close();
		

}}
