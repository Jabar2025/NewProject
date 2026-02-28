package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import resources.PropertiesFile;

public class Playback {

	public static ITestContext testContext;
	public static ITestResult testResult;
	public static WebDriver driver;
	public static Actions actionDriver;
	
	public static String BrowserType = PropertiesFile.readPropertiesFile("BrowserType");
	public static String driverPath = PropertiesFile.readPropertiesFile("driverPath");
	public static String Url = PropertiesFile.readPropertiesFile("url");
	public static String nodeUrl;
	final static String IP = PropertiesFile.readPropertiesFile("HubURL");
	final static String PORT = PropertiesFile.readPropertiesFile("HubPort");
	

public static WebDriver StartDriver() {
    switch (BrowserType) {
        case "ChromeIDE":
            System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
            ChromeOptions option = new ChromeOptions();
            option.merge(option);
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--disable-notifications");
            option.addArguments("disable-infobars");
            option.addArguments("--disable-translate");
            option.addArguments("--remote-allow-origins=*");
            option.setExperimentalOption("useAutomationExtension", false);
            option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(option);
            driver.manage().window().maximize();
            break;

        case "ChromeGrid":
            nodeUrl = "http://" + IP + ":" + PORT + "/wd/hub";
            ChromeOptions optionGrid = new ChromeOptions();
            optionGrid.addArguments("--lang=en-US");
            optionGrid.addArguments("--disable-popup-blocking");
            optionGrid.addArguments("--disable-notifications");
            optionGrid.addArguments("--ignore-ssl-errors=yes");
            optionGrid.addArguments("--ignore-certificate-errors");
            optionGrid.addArguments("disable-infobars");
            optionGrid.addArguments("--lang=en-US");
            optionGrid.addArguments("--disable-translate");
            optionGrid.addArguments("--disable-features=InsecureDownloadWarnings");
            optionGrid.addArguments("--allow-running-insecure-content");
            optionGrid.addArguments("--unsafely-treat-insecure-origin-as-secure=" + Url);
            optionGrid.addArguments("--disable-save-password-bubble");
            optionGrid.addArguments("--disable-infobars");
            optionGrid.setExperimentalOption("useAutomationExtension", false);
            optionGrid.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            optionGrid.setAcceptInsecureCerts(true);
            optionGrid.addArguments("--unsafely-treat-insecure-origin-as-secure=" + Url);
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            optionGrid.setExperimentalOption("prefs", prefs);

            DesiredCapabilities chromeOptionGrid = new DesiredCapabilities();
            chromeOptionGrid.setBrowserName("chrome");
            chromeOptionGrid.setPlatform(Platform.WINDOWS);
            chromeOptionGrid.merge(optionGrid);

            try {
                driver = new RemoteWebDriver(new URL(nodeUrl), optionGrid);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            break;

        case "ChromeDocker":
            String nodeUrlDocker = "http://" + IP + ":" + PORT + "/wd/hub";
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            DesiredCapabilities chromeOptionDoc = new DesiredCapabilities();
            chromeOptionDoc.setCapability("resolution", "1920x1080");
            chromeOptionDoc.setCapability("Zal:time", "Asia/Kolkata");
            chromeOptionDoc.setBrowserName("chrome");
            chromeOptionDoc.setPlatform(Platform.LINUX);
            ChromeOptions optionDoc = new ChromeOptions();
            optionDoc.merge(chromeOptionDoc);
            optionDoc.addArguments("--lang=en-US");
            optionDoc.addArguments("--disable-popup-blocking");
            optionDoc.addArguments("--ignore-ssl-errors=yes");
            optionDoc.addArguments("--ignore-certificate-errors");
            optionDoc.addArguments("disable-infobars");
            optionDoc.addArguments("--start-maximized");
            optionDoc.addArguments("--disable-dev-shm-usage");
            optionDoc.addArguments("--disable-popup-blocking");
            optionDoc.addArguments("--disable-notifications");
            optionDoc.addArguments("disable-infobars");
            optionDoc.addArguments("--disable-translate");
            optionDoc.addArguments("--disable-save-password-bubble");
            optionDoc.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            optionDoc.setExperimentalOption("useAutomationExtension", false);
            optionDoc.setAcceptInsecureCerts(true);
            optionDoc.addArguments("--unsafely-treat-insecure-origin-as-secure=" + Url);
            Map<String, Object> prefs1 = new HashMap<>();
            prefs1.put("credentials_enable_service", false);
            prefs1.put("profile.password_manager_enabled", false);
            optionDoc.setExperimentalOption("prefs", prefs1);

            try {
                driver = new RemoteWebDriver(new URL(nodeUrlDocker), optionDoc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            actionDriver = new Actions(driver);
            break;

        default:
            throw new IllegalArgumentException("Unsupported browser type: " + BrowserType);
    }
    return driver;
}

	public static void start() {
		Playback.StartDriver();
	}

	public static void stop() {
		Playback.driver.manage().deleteAllCookies();
		Playback.driver.quit();
		}

	public static void pageLoadWait() {
		Playback.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

	public static void setTestContextAttribute(String name, String value) {
		Playback.testContext.setAttribute(name, value);
		
	}

	public static String getTestContextAttribute(String name) {
		return Playback.testContext.getAttribute(name).toString();
	}
	}
	

