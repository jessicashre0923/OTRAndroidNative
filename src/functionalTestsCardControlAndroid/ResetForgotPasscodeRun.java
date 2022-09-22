package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCardClasses.ForgotPINSeeContactFleetManager;
import androidCardClasses.ForgotPINorPasscode;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.SecurityQuestionsAtempts;
import androidCardClasses.SecurityQuestionsFail;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class ResetForgotPasscodeRun {
	static AppiumDriver<WebElement> driver;
	private String accountType;

	@Test
	public void cardControlTestAndroid() throws Exception {
		// String testType = "Account_Page_test_";
		// String buildNum = "5.0.0";

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		LogOutCardControl Logout = new LogOutCardControl();
		ForgotPINorPasscode forgotPasscode = new ForgotPINorPasscode();
		ForgotPINSeeContactFleetManager forgotPin = new ForgotPINSeeContactFleetManager();
		HomeLandingPage homePage = new HomeLandingPage();

//		String pass = androidText.PASS;
//		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;
		String appName = "Card Control";
		
		String env;
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();

		try {
			getAccount.setEnv(env);
			accountType = "PASSCODE";
			androidLogs.setupTestYellow("LOCATING " + accountType + " account  ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("RESET PASSCODE");
			// PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();

			forgotPasscode.ForgotPINorPasscode(env, storedAccount, "985477");
			Biometrics.BiometricsAndroid();
			homePage.HomeLandingPage(env, storedAccount, storedPinOrPassword, accountType);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.setupTestYellow("RESET PIN");
			System.out.println(phone.autoPhonePickerCard(appName));
			// PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			getAccount.CardPassExpected("SMARTFUNDS");
			accountType = "SMARTFUNDS";
			forgotPin.ForgotPIN(environmentPicker.getEnviroment(), getAccount.getAccountNum());
			androidLogs.CapturedLogs(androidText.INFO, "Contact fleet manager test completed");

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(androidText.INFO, "Forgot PIN or Passcode functional test completed");

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
				androidLogs.CapturedLogs(androidText.FAIL, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}