package work.lhye.autoopentv;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpenWindow {
	public OpenWindow(int numx, int numy) {
		int screenWidth = ((int) Toolkit.getDefaultToolkit().getScreenSize().width);
		int screenHeight = ((int) Toolkit.getDefaultToolkit().getScreenSize().height);
		windowWide = screenWidth / numx;
		windowHeight = screenHeight / numy;
		draw_wide = windowWide - 15;
		draw_height = windowHeight - 38;
	}

	int windowWide, windowHeight, draw_height, draw_wide;

	public void Opentip_string(String Show_1, int lx, int ly, int close) {
		new Thread() {
			public void run() {
				JPanel jp = new JPanel() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void paint(Graphics gra) {
						super.paint(gra);
						// gra.drawLine(draw_wide/2,0, draw_wide/2, draw_height);
						// gra.drawLine(0,draw_height/2, draw_wide, draw_height/2);
						int font_px = Font_px(Show_1.length());
						gra.setFont(new Font("¿¬Ìå", Font.BOLD, font_px * 95 / 100));
						gra.drawString(Show_1, draw_wide / 2 - font_px * Show_1.length() * 48 / 100,
								draw_height / 2 + font_px * 33 / 100);
					}
				};
				draw_jp(jp, lx, ly, close);
			}
		}.start();
	}

	public void Opentip_num(int num, int lx, int ly, int close) {
		new Thread() {
			public void run() {
				JPanel jp = new JPanel() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void paint(Graphics gra) {
						super.paint(gra);
						// gra.drawLine(draw_wide/2,0, draw_wide/2, draw_height);
						// gra.drawLine(0,draw_height/2, draw_wide, draw_height/2);
						String number = num + "";
						int font_px = Font_px(number.length());
						gra.setFont(new Font("¿¬Ìå", Font.BOLD, font_px * 115 / 100));
						gra.drawString(number, draw_wide / 2 - font_px * number.length() * 30 / 100,
								draw_height / 2 + font_px * 44 / 100);
					}
				};
				draw_jp(jp, lx, ly, close);
			}
		}.start();
	}

	public void draw_jp(JPanel jp, int Loc_x, int Loc_y, int close) {
		JarResGetter resGet = new JarResGetter();
		JFrame jf = new JFrame();
		jf.setTitle("Tip");
		Image image = resGet.getResAsImage("/res/Something_Delicious.png");
		jf.setIconImage(image);
		jf.setSize(windowWide, windowHeight);
		jf.setLocation(Loc_x * windowWide, Loc_y * windowHeight);
		jf.setVisible(true);
		jf.add(jp);
		
		Delay.delay_ms(close);
		jf.dispose();
	}

	public int Font_px(int len) {
		int temp = draw_wide / len;
		if (temp < draw_height)
			return temp;
		else
			return draw_height;
	}

}
