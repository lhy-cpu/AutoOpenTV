package work.lhye.autoopentv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileGetter {
	public FileGetter() {
	}

	public String filePath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public String[] fileGetArray(String filePath) {
		int lines = 0;
		BufferedReader brr_temp;

		try {
			brr_temp = new BufferedReader(new FileReader(filePath));
			while (brr_temp.readLine() != null)
				lines++;
			brr_temp.close();

			String[] re = new String[lines];
			BufferedReader buread = new BufferedReader(new FileReader(filePath));
			String temp;
			int times = 0;
			while (((temp = buread.readLine()) != null) && (times != lines)) {
				re[times] = temp;
				times++;
			}
			buread.close();
			return re;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void fileWriteString(String filePath, String Writedat) {
		try {
			BufferedWriter wir = new BufferedWriter(new FileWriter(filePath));
			wir.write(Writedat);
			wir.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

	public String fileGetString(String filePath) {
		String[] temp = fileGetArray(filePath);
		String result = "";
		for (int a = 0; a < temp.length; a++) {
			result += temp[a];
		}
		return result;
	}

}
