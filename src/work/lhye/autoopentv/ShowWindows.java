package work.lhye.autoopentv;

public class ShowWindows {
	public static void showWindows_open() {
		TimeHandler time = new TimeHandler();
		OpenWindow window = new OpenWindow(SettingGetter.getInt("tip_rampant"), SettingGetter.getInt("tip_vertical"));
		int tip_close = SettingGetter.getInt("tip_disappear_ms");
		int one_line = SettingGetter.getInt("tip_show_only_one_line_rampant");
		int count = time.nowToTime(SettingGetter.getString("start_time"));
		for (int a = 0; a < SettingGetter.getInt("tip_vertical"); a++) {
			if ((a + 1) == SettingGetter.getInt("tip_show_count_time_vertical"))
				window.Opentip_num(count, a, one_line, tip_close);
			else
				window.Opentip_string(SettingGetter.getString("tip_vertical_" + (a + 1)), a, one_line, tip_close);
		}
		int temp = count / 2;
		while (count > temp) {
			count--;
			Delay.delay_sec(1);
		}
		for (int a = 0; a < SettingGetter.getInt("tip_vertical"); a++) {
			if ((a + 1) == SettingGetter.getInt("tip_show_count_time_vertical"))
				window.Opentip_num(count, a, one_line, tip_close);
			else
				window.Opentip_string(SettingGetter.getString("tip_vertical_" + (a + 1)), a, one_line, tip_close);
		}

		while (count > SettingGetter.getInt("tip_before_start_second")) {
			count--;
			Delay.delay_sec(1);
		}

		while (count > -1) {
			for (int y = 0; y < SettingGetter.getInt("tip_rampant") && count > -1; y++) {
				for (int a = 0; a < SettingGetter.getInt("tip_vertical"); a++) {
					if ((a + 1) == SettingGetter.getInt("tip_show_count_time_vertical"))
						window.Opentip_num(count, a, y, tip_close);
					else
						window.Opentip_string(SettingGetter.getString("tip_vertical_" + (a + 1)), a, y, tip_close);

				}
				Delay.delay_sec(1);
				count--;
				if (y == SettingGetter.getInt("tip_rampant"))
					y = 0;
			}
		}
		if (SettingGetter.getString("open_music_wav").compareTo("Default") == 0) {
			PlayAudio.playau("/res/open.wav", true);
		} else if (SettingGetter.getString("open_music_wav").compareTo("None") == 0) {
			PlayAudio.playau("/res/none.wav", true);
		} else {
			PlayAudio.playau(SettingGetter.getString("open_music_wav"), false);
		}
		Delay.delay_sec(1);
	}

	public static void showWindows_close() {
		OpenWindow window = new OpenWindow(1, 3);
		window.Opentip_string(SettingGetter.getString("tip_close"), 0, 1, SettingGetter.getInt("tip_disappear_ms"));
		if (SettingGetter.getString("close_music_wav").compareTo("Default") == 0) {
			PlayAudio.playau("/res/close.wav", true);
		} else if (SettingGetter.getString("close_music_wav").compareTo("None") == 0) {
			PlayAudio.playau("/res/none.wav", true);
		} else {
			PlayAudio.playau(SettingGetter.getString("close_music_wav"), false);
		}
	}

	public static void showWindows_noplay(String thing) {
		OpenWindow window = new OpenWindow(1, 3);
		window.Opentip_string(thing, 0, 1, SettingGetter.getInt("tip_disappear_ms"));
	}

}
