package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Randamized {

	public static String getCurrentDate(String dateFormat) {
		Date date = new Date();
		SimpleDateFormat dateStrCurrent = new SimpleDateFormat(dateFormat);
		return dateStrCurrent.format(date);

	}
}
