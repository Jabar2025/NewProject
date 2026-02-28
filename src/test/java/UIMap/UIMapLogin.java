package UIMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Playback;

public class UIMapLogin {

	
	public LoginScreen loginScreen;
	
	public UIMapLogin() {
		if (this.loginScreen == null)
			this.loginScreen = new LoginScreen();
	}
	
	public class LoginScreen {
	
	public LoginScreen() {
     PageFactory.initElements(Playback.driver, this);   
    }
	@FindBy(how = How.XPATH, using = "//div[@id=':r0:-form-item']//input[@name='email']")
	public WebElement emailAddressEdit;

	@FindBy(how = How.NAME, using = "password")
	public WebElement passwordEdit;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
	public WebElement loginButton;
}
}