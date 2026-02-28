package script;

import utilities.Browser;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.Loader;
import application.Login;
import application.Maintenance;
import reports.ExtentReport;
import utilities.Playback;

public class RunScript {

	public Login login;
	public Loader loader;
	
	public Maintenance maintenance;
	
	
	@BeforeSuite (groups = "Test")
	public void beforeRunSuite(ITestContext testContext) {
		Playback.testContext = testContext;
//		ExtentReport.getSuiteDetails(testContext.getSuite());
//		String suitePath = testContext.getCurrentXmlTest().getSuite().getFileName();
//		ExtentReport.startReport(suitePath);
//		ExtentReport.TotalTestsInSuite(testContext.getSuite());
	}
	@BeforeMethod (groups = "Test")
	public void beforeTestMethod(ITestContext testContext, ITestResult testResult) {
		Playback.testContext = testContext;
	//	ExtentReport.startReportForMethod(testResult);
		Playback.start();
		login = new Login();
		loader = new Loader();
		maintenance = new Maintenance();
	}
	@Test (groups = "Test")
	public void test1() throws InterruptedException {
		Browser.NavigateToLoginScreen();
		Playback.pageLoadWait();
		login.loginScreen.Logon();
		Playback.pageLoadWait();
		loader.navigateToModule("/audit");
		Playback.pageLoadWait();
	}
	
@Test (groups = "Test")
public void test2() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/projects");
	Playback.pageLoadWait();
}

@Test (groups = "Test")
public void test3() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/users");
	Playback.pageLoadWait();
}

@Test (groups = "Test")
public void test4() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/sop");
	Playback.pageLoadWait();
}
@Test (groups = "Test")
public void test5() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/maintence");
	Playback.pageLoadWait();
}
@Test (groups = "Test")
public void test6() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/pulse");
	Playback.pageLoadWait();
}
@Test (groups = "Test")
public void test7() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/qr");
	Playback.pageLoadWait();
}
@Test (groups = "Test")
public void test8() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/audit");
	Playback.pageLoadWait();
}

@Test (groups = "Test")
public void test9() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/audit");
	Playback.pageLoadWait();
}

@Test (groups = "Test")
public void test10() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/audit");
	Playback.pageLoadWait();
}

@Test (groups = "Test")
public void test11() throws InterruptedException {
	Browser.NavigateToLoginScreen();
	Playback.pageLoadWait();
	login.loginScreen.Logon();
	Playback.pageLoadWait();
	loader.navigateToModule("/audit");
	Playback.pageLoadWait();
}
	
	@AfterMethod (groups = "Test")
	public void afterTestMethod(ITestResult testResult) {
//try {
//			
//			ExtentReport.getResult(testResult);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Playback.stop();
		login.Reset();
	}
	@AfterSuite (groups = "Test")
	public void afterRunSuite() {
//		ExtentReport.GenerateHTML();
//		System.gc();
	}
	
}
