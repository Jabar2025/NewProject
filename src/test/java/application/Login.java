package application;

import UIMap.UIMapLogin;
import application.Login.LoginScreen;
import resources.PropertiesFile;

public class Login {
	public UIMapLogin uIMapLogin = new UIMapLogin();
	
	PropertiesFile propertiesFile = new PropertiesFile();
	
	public String UserName = PropertiesFile.readPropertiesFile("UserName");
	public String Password = PropertiesFile.readPropertiesFile("Password");
	
	public LoginScreen loginScreen;
	
	public Login() {
		if (loginScreen == null)
			loginScreen = new LoginScreen();

	}
	public void Reset() {
		uIMapLogin = null;
	}
	public class LoginScreen {
		
		public void Logon() {
			uIMapLogin.loginScreen.emailAddressEdit.sendKeys(UserName);
			uIMapLogin.loginScreen.passwordEdit.sendKeys(Password);
			uIMapLogin.loginScreen.loginButton.click();
			
	}
	}
}
