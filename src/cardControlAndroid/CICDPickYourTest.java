package cardControlAndroid;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import functionalTestsCardControlAndroid.RegisterCheckRun;
import io.appium.java_client.AppiumDriver;

public class CICDPickYourTest {
	static AppiumDriver<WebElement> driver;
	CICDSmashLoginAltTests cicdsmashLoginTests = new CICDSmashLoginAltTests();
	AndroidLogs androidLogs = new AndroidLogs();
	RegressionTestRun regression = new RegressionTestRun();
	NewCardLoginUnitTest newUserCardTest = new NewCardLoginUnitTest();
	AutoAccountSmashLoginRun SmashLogin = new AutoAccountSmashLoginRun();
	LoginSmokeTestRun loginTests = new LoginSmokeTestRun();
	UnitTestMultiCard multiCardUnittests = new UnitTestMultiCard();
	RegisterCheckRun registerCheck = new RegisterCheckRun();
	
	//GIVE YOUR TEST THE DETAILS IT NEEDS ENV IS VITAL TO RUN TEST
	String env = "AWSSIT";
	String TestName = "CICD CARD COMTROL ";
	String build = "Build #: 5.0.2_18233 ";
	String appName = "Card Control ";
	
	
	
	
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
		System.out.println("All Tests running");
		registerCheck.cardControlTestAndroid(TestName, build, appName, env);
	//	SmashLogin.cardControlTestAndroid(TestName, build, appName, env);
	//	cicdsmashLoginTests.cardControlTestAndroid(TestName,build,appName,env);
	//	loginTests.cardControlTestAndroid(TestName, build, appName, env);
	//	newUserCardTest.cardControlTestAndroid(TestName, build, appName, env);
	//	regression.cardControlTestAndroid(TestName, build, appName, env);
	//	multiCardUnittests.cardControlTestAndroid(TestName, build, appName, env);
			
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