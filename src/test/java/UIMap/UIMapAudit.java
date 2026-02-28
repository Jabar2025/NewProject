package UIMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.Playback;

public class UIMapAudit {

	
	public AuditScreen auditScreen;
	
	public UIMapAudit() {

		
		if (this.auditScreen == null)
			this.auditScreen = new AuditScreen();
	}
	
	public class AuditScreen {
        
		public WebDriver driver;
        public AuditScreen() {
        	driver = Playback.driver;
			PageFactory.initElements(driver, this);
		}
        
        }
    }

