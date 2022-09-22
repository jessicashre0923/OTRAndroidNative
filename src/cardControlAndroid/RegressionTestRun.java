package cardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import functionalTestsCardControlAndroid.AccountPageRun;
import functionalTestsCardControlAndroid.DynamicPINRun;
import functionalTestsCardControlAndroid.HomePage;
import functionalTestsCardControlAndroid.MultiCardLogin;
import functionalTestsCardControlAndroid.Onboarding;
import functionalTestsCardControlAndroid.PasscodeFailFromLoginPage;
import functionalTestsCardControlAndroid.QuickLoginLogoutRun;
import functionalTestsCardControlAndroid.RegisterCheckRun;
import functionalTestsCardControlAndroid.ResetForgotPasscodeRun;
import functionalTestsCardControlAndroid.PinAndPasswordFromProfileRun;
import functionalTestsCardControlAndroid.SecureFuelRun;
import functionalTestsCardControlAndroid.SetupProfileRun;
import functionalTestsCardControlAndroid.TransferFundsRun;
import io.appium.java_client.AppiumDriver;

public class RegressionTestRun {
	static AppiumDriver<WebElement> driver;
	
	
	//GIVE YOUR TEST THE MANUAL DEFAULT DETAILS IT NEEDS TO RUN ENV IS VITAL TO RUN TEST
	// env IS THE SERVER YOU ARE RUNNING THE TEST ON
	//TestName IS THE NAME OF HTE TEST YOU WANT TO GOVE IT
	// build IS THE BUILD NUMBER ARE USING FROM TESTFLIGHT OR APP TEST
	// appName NAME OF APP BEING TESTED
		
	String TestName = "Regression Test Run ";
	String build = "Build #:  ";
	String appName = "Card Control ";
	String env = "Partner ";



	public void cardControlTestAndroid(String testName, String buildNum, String app, String serverEnv) throws Exception {
		TestName = testName;
		 build = buildNum;
		 appName = app;
		 env = serverEnv;
		 
		cardControlTestAndroid();
	}

	

	@Test
	public void cardControlTestAndroid() throws Exception {

		// String testName = "SMOKE TEST CARD CONTROL";
		AndroidLogs androidLogs = new AndroidLogs();

		AppStringsAndroid androidText = new AppStringsAndroid();
		AccountPageRun autoAccountAccountPage = new AccountPageRun();
		DynamicPINRun autoAccountDynamicPINRun = new DynamicPINRun();
		HomePage autoAccountHomePage = new HomePage();
		MultiCardLogin autoAccountMultiCardLogin = new MultiCardLogin();
		Onboarding onboardingScreens = new Onboarding();
		PasscodeFailFromLoginPage autoAccountPasscodeFailFromLoginPage = new PasscodeFailFromLoginPage();
		QuickLoginLogoutRun autoAccountQuickLoginLogoutRun = new QuickLoginLogoutRun();
		RegisterCheckRun autoAccountRegisterCheckRun = new RegisterCheckRun();
		ResetForgotPasscodeRun autoAccountResetForgotPasscodeRun = new ResetForgotPasscodeRun();
		PinAndPasswordFromProfileRun autoAccountResetPinAndPasswordFromProfileRun = new PinAndPasswordFromProfileRun();
		SecureFuelRun autoAccountSecureFuelRun = new SecureFuelRun();
		SetupProfileRun autoAccountSetupProfileRun = new SetupProfileRun();
		TransferFundsRun autoAccountTransferFunds = new TransferFundsRun();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		try {
			androidLogs.setupTest(TestName + build + appName +env);
			
			androidLogs.setupTest("SMOKE TEST CARD CONTROL");

			androidLogs.setupTestYellow("*ACCOUNT PAGE TESTS*");
			autoAccountAccountPage.cardControlTestAndroid();

			androidLogs.setupTestYellow("*REGISTER CHECK TESTS*");
			autoAccountRegisterCheckRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*FORGOT PASSCODE TESTS*");
			autoAccountResetForgotPasscodeRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*DYNAMIC PIN TEST*");
			autoAccountDynamicPINRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*RESET PIN AND PASSCODE FROM PROFILE TESTS*");
			autoAccountResetPinAndPasswordFromProfileRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*SECURE FUEL TESTS*");
			autoAccountSecureFuelRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*ACCOUNT SETUP TESTS*");
			autoAccountSetupProfileRun.cardControlTestAndroid();

			androidLogs.setupTestYellow("*TRANSFER FUNDS TESTS*");
			autoAccountTransferFunds.cardControlTestAndroid();

			androidLogs.setupTestYellow("*ONBOARDING TESTS*");
			onboardingScreens.cardControlTestAndroid();
			
			androidLogs.setupTestYellow("*PASSCODE FAIL FROM LOGIN TESTS*");
			autoAccountPasscodeFailFromLoginPage.cardControlTestAndroid();

			androidLogs.setupTestYellow("*HOME PAGE TESTS*");
			autoAccountHomePage.cardControlTestAndroid();

			androidLogs.setupTestYellow("*MULTI CARD LOGIN TESTS*");
			autoAccountMultiCardLogin.cardControlTestAndroid();

			androidLogs.setupTestYellow("*LOGIN LOGOUT TESTS*");
			autoAccountQuickLoginLogoutRun.cardControlTestAndroid();

//	androidLogs.setupTestYellow("*ADD DELETE MULTICARD TESTS*");
//	robot.keyPress(KeyEvent.VK_ESCAPE);
//	autoAccountAddDeleteMultiCard.cardControlTestAndroid();

			androidLogs.CapturedLogs(info, "CARDCONTROL SMOKE TESTING COMPLETE");

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