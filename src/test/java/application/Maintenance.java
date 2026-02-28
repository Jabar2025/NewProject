package application;
import UIMap.UIMapMaintenance;
import UIMap.UIMapMaintenance.Settings;
public class Maintenance {
	public UIMapMaintenance uIMapMaintenance = new UIMapMaintenance();
	
	 public Settings settings;
	
	  public Maintenance() {
	        if (settings == null) {
	        	settings = new Settings();
	        }
	    }
		public class Settings {
			
			public void clickSettingsButton() {
				uIMapMaintenance.settings.uISettingsButton.click();
				        }
			
			public void clickDistrictButton() {
				uIMapMaintenance.settings.uIDistrictButton.click();
			}
			
			public void clickActionButton() {
				uIMapMaintenance.settings.uIActionButton.click();
			}
			
				    }
			}

		
		
		
	
	

