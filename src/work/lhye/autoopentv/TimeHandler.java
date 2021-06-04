package work.lhye.autoopentv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHandler {
	public TimeHandler() {
	}

	public int timeCalculator(String start, String stop) {
		String[] temp_start = start.split(":");
		String[] temp_stop = stop.split(":");
		int starthour = Integer.parseInt(temp_start[0]);
		int startmin = Integer.parseInt(temp_start[1]);
		int startsec = Integer.parseInt(temp_start[2]);
		int stophour = Integer.parseInt(temp_stop[0]);
		int stopmin = Integer.parseInt(temp_stop[1]);
		int stopsec = Integer.parseInt(temp_stop[2]);

		int count;

		int countsec = stopsec - startsec;
		int countmin, counthour;
		if (countsec < 0) {
			countmin = stopmin - startmin - 1;
			countsec = 60 + countsec;
		} else
			countmin = stopmin - startmin;
		if (countmin < 0) {
			counthour = stophour - starthour - 1;
			countmin = 60 + countmin;
		} else
			counthour = stophour - starthour;

		count = counthour * 3600 + countmin * 60 + countsec;
		return count;
	}

	public int nowToTime(String totime) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return timeCalculator(sdf.format(date), totime);
	}

	public String weekPlay() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		if (SettingGetter.getString(sdf.format(date)).compareTo("Default") == 0)
			return "Default";
		else
			return SettingGetter.getString(sdf.format(date));
	}

}
