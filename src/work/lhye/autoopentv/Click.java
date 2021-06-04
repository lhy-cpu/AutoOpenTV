package work.lhye.autoopentv;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

public class Click {
	public static void clickClose() {
		int x = SettingGetter.getInt("close_chrome_tip_x");
		int y = SettingGetter.getInt("close_chrome_tip_y");
		try {
			Robot robot = new Robot();
			for (int a = 0; a < 30; a++) {
				robot.mouseMove(x, y);
			}
			Delay.delay_ms(100);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Delay.delay_ms(100);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void movecenter() {
		new Thread() {
			public void run() {
				try {
					Robot robot = new Robot();
					for (int a = 0; a < 10; a++) {
						robot.mouseMove(
								(int) Toolkit.getDefaultToolkit().getScreenSize().width / 2
										+ (int) (Math.random() * 100),
								(int) Toolkit.getDefaultToolkit().getScreenSize().height / 2
										+ (int) (Math.random() * 100));
						Delay.delay_ms(500);
					}
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
