package carrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.OpenAndLoginCarrierControl;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import functionalTestsCarrierControlAndroid.QuickLoginLogoutRun;
import io.appium.java_client.AppiumDriver;

public class LoginSmokeTestRun {
//Working on adding testng...
	// cntrl shft f cleans up the format..
	// sysout + cntrl + space == System.out.println();
	// sout + cntr + space = System.out.println();

	static AppiumDriver<WebElement> driver;

	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		QuickLoginLogoutRun quickLoginLogoutRun = new QuickLoginLogoutRun();
		OpenAndLoginCarrierControl OpenAndLoginCarrierControl = new OpenAndLoginCarrierControl();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
//		String info = androidText.INFO;

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Login Smoke Test ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "AWS DIT ";

		try {
			androidLogs.setupTest(TestName + build + appName +server);
			
			androidLogs.setupTest("CARRIER CONTROL LOGIN SMOKE TEST");
			androidLogs.setupTestYellow("*LOCKED SUSPENDED LOGIN*");
			OpenAndLoginCarrierControl.openCarrierControl();
			logoutApp.logOutCarrierControll();

			androidLogs.setupTestYellow("*MULTI CARRIER LOGIN LOGOUT TEST*");
			quickLoginLogoutRun.carrierControlTestAndroidLoginLogout();

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
				androidLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}