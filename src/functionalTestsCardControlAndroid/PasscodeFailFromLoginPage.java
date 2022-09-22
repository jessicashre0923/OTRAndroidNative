package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
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
import androidSharedClasses.HelpScreen;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class PasscodeFailFromLoginPage {
	static AppiumDriver<WebElement> driver;
	private String cardType;

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
		SecurityQuestionsFail securityQuestionsFail = new SecurityQuestionsFail();
		SecurityQuestionsAtempts securityQuestionAttempts = new SecurityQuestionsAtempts();
		HelpScreen helpScreen = new HelpScreen();

//				String pass = androidText.PASS;
//				String fail = androidText.FAIL;
		String info = androidText.INFO;
		String appName = "Card Control";
		
		try {
//Change Security questions fail first question...					
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("SECURITY QUESTION FAIL ONE SEURITY QUESTIONS");
			// PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "PASSCODE";
			getAccount.CardPassExpected(cardType);
			
			securityQuestionAttempts.FailSecQuetionsOne(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					"985477");
			Biometrics.BiometricsAndroid();
			helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), "985477",
					this.cardType);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//Change Security questions fail first and second question...
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("SECURITY QUESTION FAIL TWO SEURITY QUESTIONS");
			// PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "PASSCODE";
			getAccount.CardPassExpected(cardType);
			securityQuestionAttempts.FailSecQuetionsOneAndTwo(environmentPicker.getEnviroment(),
					getAccount.getAccountNum(), "985477");
			Biometrics.BiometricsAndroid();
			helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), "985477",
					this.cardType);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//Change Security questions Fail all security questions and reset card status...
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("SECURITY QUESTION FAIL ALL");
			// PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "PASSCODE";
			getAccount.CardPassExpected(cardType);
			securityQuestionsFail.ForgotPINorPasscode(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					"985477");
			androidLogs.CapturedLogs(info, "PASSCODE FAILED TO BE RESET AS EXPECTED");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

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