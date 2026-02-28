package UIMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import application.Maintenance.Settings;
import utilities.Playback;

public class UIMapMaintenance {

	public Settings settings;
	
	public UIMapMaintenance() {
		
		if (this.settings == null)
			this.settings = new Settings();
	}

	public class Settings {

		public WebDriver driver;

		public Settings() {
			driver = Playback.driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(how = How.XPATH, using = "//*[normalize-space(text())='Settings']")
		public WebElement uISettingsButton;
		
		
		@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='District']")
		public WebElement uIDistrictButton;
		
		
			@FindBy(how = How.ID, using = "radix-:r215:")
			public WebElement uIActionButton;
		
	}
	
}
