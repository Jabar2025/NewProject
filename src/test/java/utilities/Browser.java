package utilities;

import resources.PropertiesFile;

public class Browser {

	public static String url = PropertiesFile.readPropertiesFile("url");
	
	public static String BrowserType = PropertiesFile.readPropertiesFile("BrowserType");
	
	public static void NavigateToLoginScreen() {
		if (Playback.BrowserType.equals("Chrome"))
		Playback.driver.manage().window().maximize();
		Playback.driver.get(url);
	}
	
	
	
	
}
