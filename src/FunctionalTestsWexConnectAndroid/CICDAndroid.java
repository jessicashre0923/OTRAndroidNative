package FunctionalTestsWexConnectAndroid;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import cardControlAndroid.RegressionTestRun;
import io.appium.java_client.AppiumDriver;

public class CICDAndroid {
	static AppiumDriver<WebElement> driver;
	RegressionTestRun regression = new RegressionTestRun();
	AndroidLogs androidLogs = new AndroidLogs();
	WexConnectTabTest wCTabTest = new WexConnectTabTest();
	
	@BeforeClass
	void beforeClass()
	{
	System.out.println("CICD Testing Started");
	}
	
	@AfterClass
	void afterClass()
	{
	System.out.println("CICD Testing Started");
	}
	
	
	@BeforeMethod
	void beforeMethod()
	{
	System.out.println("Test Started");
	}
	
	@AfterMethod
	void afterMethod()
	{
	System.out.println("Test ended");
	}
	
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		System.out.println("Test running");
		wCTabTest.wexConnectTabTest();
}
	
	@Test
	public void test1() throws Exception {
		System.out.println("Test 1 running");
		//regression.cardControlTestAndroid();
}	
	
	@Test
	public void test2() throws Exception {
		System.out.println("Test 2 running");
		//regression.cardControlTestAndroid();
}	

}