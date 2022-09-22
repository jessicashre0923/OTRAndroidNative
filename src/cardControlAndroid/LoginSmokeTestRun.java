package cardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import functionalTestsCardControlAndroid.MultiCardLogin;
import functionalTestsCardControlAndroid.PasscodeFailFromLoginPage;
import functionalTestsCardControlAndroid.QuickLoginLogoutRun;
import functionalTestsCardControlAndroid.ResetForgotPasscodeRun;
import functionalTestsCardControlAndroid.PinAndPasswordFromProfileRun;
import functionalTestsCardControlAndroid.SetupProfileRun;
import io.appium.java_client.AppiumDriver;

public class LoginSmokeTestRun {
	static AppiumDriver<WebElement> driver;

	//GIVE YOUR TEST THE MANUAL DEFAULT DETAILS IT NEEDS TO RUN ENV IS VITAL TO RUN TEST
		// env IS THE SERVER YOU ARE RUNNING THE TEST ON
		//TestName IS THE NAME OF HTE TEST YOU WANT TO GOVE IT
		// build IS THE BUILD NUMBER ARE USING FROM TESTFLIGHT OR APP TEST
		// appName NAME OF APP BEING TESTED
			
		String env = "PARTNER";
		String TestName = "Smash Login Alt Tests ";
		String build = "Build #:  ";
		String appName = "Card Control ";



		public void cardControlTestAndroid(String testName, String buildNum, String app, String serverEnv) throws Exception {
			TestName = testName;
			 build = buildNum;
			 appName = app;
			 env = serverEnv;
			 
			cardControlTestAndroid();
		}
	
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		MultiCardLogin autoAccountMultiCardLogin = new MultiCardLogin();
		PasscodeFailFromLoginPage autoAccountPasscodeFailFromLoginPage = new PasscodeFailFromLoginPage();
		QuickLoginLogoutRun autoAccountQuickLoginLogoutRun = new QuickLoginLogoutRun();
		ResetForgotPasscodeRun autoAccountResetForgotPasscodeRun = new ResetForgotPasscodeRun();
		PinAndPasswordFromProfileRun autoAccountResetPinAndPasswordFromProfileRun = new PinAndPasswordFromProfileRun();
		SetupProfileRun autoAccountSetupProfileRun = new SetupProfileRun();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		
		try {
			androidLogs.setupTest(TestName + build + appName +env);

			androidLogs.setupTestYellow("*FORGOT PASSCODE TESTS*");
			autoAccountResetForgotPasscodeRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*RESET PIN AND PASSCODE FROM PROFILE TESTS*");
			autoAccountResetPinAndPasswordFromProfileRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*ACCOUNT SETUP TESTS*");
			autoAccountSetupProfileRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*PASSCODE FAIL FROM LOGIN TESTS*");
			autoAccountPasscodeFailFromLoginPage.cardControlTestAndroid();

			androidLogs.setupTestYellow("*MULTI CARD LOGIN TESTS*");
			autoAccountMultiCardLogin.cardControlTestAndroid();

			androidLogs.setupTestYellow("*LOGIN LOGOUT TESTS*");
			autoAccountQuickLoginLogoutRun.cardControlTestAndroid();

			androidLogs.CapturedLogs(info, "CARDCONTROL LOGIN SMOKE TEST COMPLETE");

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