package work.lhye.autoopentv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChrome {
	String path, url;

	public OpenChrome(String path_in, String url_in) {
		path = path_in;
		url = url_in;
	}

	public void OpenWeb(String stop) {
		System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Delay.delay_ms(2000);
		Click.clickClose();
		Delay.delay_ms(1000);
		Click.movecenter();
		while (!Find_element(driver, "play_or_pause_pause_player"))
			Delay.delay_ms(1000);
		Delay.delay_ms(2000);
		while (driver.findElement(By.id("play_or_pause_pause_player")).getCssValue("display").compareTo("block") != 0
				&& driver.findElement(By.id("play_or_pause_pause_mouseover_player")).getCssValue("display")
						.compareTo("block") != 0) {
			while (!Click_element(driver, "play_or_plause_player")) {
				Delay.delay_ms(2500);
			}
			Delay.delay_ms(2500);
		}
		while (!Click_element(driver, "player_fullscreen_player")) {
			Delay.delay_ms(2500);
		}
		Click.movecenter();
		TimeHandler time = new TimeHandler();
		while (time.nowToTime(stop) > 0) {
			Delay.delay_sec(3);
		}
		driver.close();
	}

	public boolean Find_element(WebDriver driver, String id) {
		try {
			driver.findElement(By.id(id));
		} catch (Exception err) {
			err.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean Click_element(WebDriver driver, String id) {
		try {
			driver.findElement(By.id(id)).click();
		} catch (Exception err) {
			err.printStackTrace();
			return false;
		}
		return true;

	}

}
