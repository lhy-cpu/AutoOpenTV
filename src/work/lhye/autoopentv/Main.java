package work.lhye.autoopentv;

public class Main {
	public static void main(String[] args) {
		System.out.println("OpenTV server starts!");
		while (true) {
			TimeHandler time = new TimeHandler();
			if (time.nowToTime(SettingGetter.getString("start_tip_time")) < 0
					&& time.nowToTime(SettingGetter.getString("start_tip_time")) > -20) {
				String temp;
				if ((temp = time.weekPlay()).compareTo("Default") == 0) {
					ShowWindows.showWindows_open();
					OpenChrome open = new OpenChrome(SettingGetter.getString("chrome_Application_path"),
							SettingGetter.getString("website"));
					open.OpenWeb(SettingGetter.getString("close_time"));
					ShowWindows.showWindows_close();
					break;
				} else {
					ShowWindows.showWindows_noplay(temp);
					break;
				}
			}
			Delay.delay_sec(2);
		}
	}
}
