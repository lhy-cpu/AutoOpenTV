package work.lhye.autoopentv;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class PlayAudio extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static void playau(String path, boolean isInJar) {
		try {
			URL fileUrl;
			if (isInJar) {
				JarResGetter resGet = new JarResGetter();
				fileUrl = resGet.getResAsURL(path);
			} else {
				File f = new File(path);
				fileUrl = f.toURL();
			}
			AudioClip aau;
			aau = Applet.newAudioClip(fileUrl);
			aau.play();
			@SuppressWarnings("unused")
			PlayAudio frame = new PlayAudio();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
