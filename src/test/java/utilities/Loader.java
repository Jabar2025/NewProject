package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loader {
	
	WebDriver driver = Playback.driver;
	
	public void navigateToModule(String moduleName) {
		try {
			WebElement element = Playback.driver.findElement(By.xpath("//a[contains(@href,'"+ moduleName + "')]"));
//			WebElement element = Playback.driver.findElement(By.xpath(
//					"//div[@class='grid grid-cols-1 gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 2xl:grid-cols-6s']//a[contains(@href, '"+ moduleName + "')]"));
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
