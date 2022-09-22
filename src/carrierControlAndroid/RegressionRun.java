package carrierControlAndroid;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.OpenAndLoginCarrierControl;
import androidCarrierClasses.OpenCarrierControlDirectLogin;
import androidCarrierClasses.OpenCompanyCC;
import androidCarrierClasses.OpenSubUserCarrierControl;
import androidCarrierClasses.OpenUniversalCC;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Sleep;
import functionalTestsCarrierControlAndroid.QuickLoginLogoutRun;
import io.appium.java_client.AppiumDriver;

public class RegressionRun {
//Working on adding testng...
	// cntrl shft f cleans up the format..
	// sysout + cntrl + space == System.out.println();
	// sout + cntr + space = System.out.println();

	static AppiumDriver<WebElement> driver;

	@Test
	public void functionalAndroidCarrierControl() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		Sleep appSleep = new Sleep();
		AppStringsAndroid androidText = new AppStringsAndroid();
		OpenAndLoginCarrierControl OpenAndLoginCarrierControl = new OpenAndLoginCarrierControl();
		QuickLoginLogoutRun quickLoginLogoutRun = new QuickLoginLogoutRun();
	
		
		String pass = androidText.PASS;
//		String fail = androidText.FAIL;
		String info = androidText.INFO;

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Regression ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "AWS DIT ";

		
		
		try {
			androidLogs.setupTest(TestName + build + appName +server);
			
			
			androidLogs.setupTest("LOCKED SUSPENDED SUCCESS LOGIN");
			OpenAndLoginCarrierControl.openCarrierControl();

			androidLogs.setupTestYellow("*MULTI CARRIER LOGIN LOGOUT TEST*");
			quickLoginLogoutRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTest("Account setup test logs for 100045");
			OpenCarrierControlDirectLogin.openCarrierControl();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(pass, "100045 is now logging out.");
			appSleep.ThreadSleep3000();

			androidLogs.setupTest("Account setup test logs for 102698db");
			OpenSubUserCarrierControl.openCarrierControl();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(pass, "Sub User Testing is now logging out.");
			appSleep.ThreadSleep3000();

//TDOD CHECK MONEY CODE ISSUE			
			androidLogs.setupTest("Account setup test logs for 129698");
			OpenUniversalCC.openCarrierControl();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(pass, "Universal User Testing is now logging out.");

			androidLogs.setupTest("Account setup test logs for 103526");
			OpenCompanyCC.openCarrierControl();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(pass, "Company Testing is now logging out.");
			appSleep.ThreadSleep3000();

			androidLogs.CapturedLogs(pass, "Full Regression testing completed.");

		} catch (Exception exp) {

			String errorMessage = exp.getMessage();

			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);

			} else {
				System.out.println("Error is: " + errorMessage);
			}

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				androidLogs.CapturedLogs(info, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}