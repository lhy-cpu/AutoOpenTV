package work.lhye.autoopentv;

import net.sf.json.JSONObject;

public class SettingGetter {
	public static int getInt(String key) {
		FileGetter fileget = new FileGetter();
		JSONObject json = JSONObject.fromObject(fileget.fileGetString(fileget.filePath() + "\\setting.json"));
		return json.getInt(key);
	}

	public static String getString(String key) {
		FileGetter fileget = new FileGetter();
		JSONObject json = JSONObject.fromObject(fileget.fileGetString(fileget.filePath() + "\\setting.json"));
		return json.getString(key);
	}

}
