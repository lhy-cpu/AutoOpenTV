package work.lhye.autoopentv;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class JarResGetter {
	public JarResGetter() {

	}

	public URL getResAsURL(String path) {
		return this.getClass().getResource(path);
	}

	public Image getResAsImage(String path) {
		try {
			return ImageIO.read(this.getClass().getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
