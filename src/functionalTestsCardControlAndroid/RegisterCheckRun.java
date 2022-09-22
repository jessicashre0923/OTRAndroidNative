package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardLoginPasscode;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.RegisterCheckAndroid;
import androidCardClasses.RegisterCheckSmartFundsSide;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class RegisterCheckRun {
	static AppiumDriver<WebElement> driver;

	// GIVE YOUR TEST THE MANUAL DEFAULT DETAILS IT NEEDS TO RUN ENV IS VITAL TO RUN
	// TEST
	// env IS THE SERVER YOU ARE RUNNING THE TEST ON
	// TestName IS THE NAME OF HTE TEST YOU WANT TO GOVE IT
	// build IS THE BUILD NUMBER ARE USING FROM TESTFLIGHT OR APP TEST
	// appName NAME OF APP BEING TESTED

	String env = "TEST";
	String TestName = "Register Check ";
	String build = "Build #:  ";
	String appName = "Card Control ";

	public void cardControlTestAndroid(String testName, String buildNum, String app, String serverEnv)
			throws Exception {
		TestName = testName;
		build = buildNum;
		appName = app;
		env = serverEnv;

		cardControlTestAndroid();
	}

	private String cardNum;
	private String passwordOrPin;
	private String accountType;

	@Test
	public void cardControlTestAndroid() throws Exception {

		// SQL Select reg_check_flag, * from cont_misc where reg_check_flag = "Y";

		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl Logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CardLoginPasscode CardLogin = new CardLoginPasscode();
		RegisterCheckAndroid registerCheck = new RegisterCheckAndroid();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		RegisterCheckSmartFundsSide registerCheckSmartFundsSide = new RegisterCheckSmartFundsSide();
		HelpScreen helpScreen = new HelpScreen();
		
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;

		AutoAccountSelector getAccount = new AutoAccountSelector();
		HomeLandingPage homePage = new HomeLandingPage();
		environmentPicker.SetEnvironmentSelect(env);

		try {

			androidLogs.setupTestYellow("REGISTER CHECK Smart Funds Side Card");
			getAccount.setEnv(env);
			accountType = "Register_Check_UNIVERSAL";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButtonSelect(env);
			multiCard.MultiCardLoginCheck();
			CardLogin.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, accountType);
			registerCheckSmartFundsSide.registerCheckAndroid(env, storedAccount, storedPinOrPassword);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//			androidLogs.setupTestYellow("REGISTER CHECK UNIVERSAL COMPANY SIDE");
//			getAccount.setEnv(env);
//			accountType = "Register_Check_UNIVERSAL";
//			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
//			getAccount.CardPassExpected(accountType);
//			storedAccount = getAccount.getAccountNum();
//			storedPinOrPassword = getAccount.getPasswordOrPin();
//
//			System.out.println(phone.autoPhonePickerCard(appName));
//			environmentPicker.EnvironmentPickerButtonSelect(env);
//			multiCard.MultiCardLoginCheck();
//			CardLogin.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
//			Biometrics.BiometricsAndroid();
//			helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, accountType);
//			registerCheck.registerCheckAndroid(env, storedAccount, storedPinOrPassword);
//			Logout.logoutCardControl();
//			androidLogs.CapturedLogs(info, "Logged out of " + accountType + "Card");
//
//			Capabilities.driver.closeApp();
//			Capabilities.driver.quit();

//			androidLogs.setupTestYellow("REGISTER CHECK COMPANY TEST");
//			cardType = "Register_Check_Company";
//			getAccount.CardPassExpected(accountType);

//			System.out.println(phone.autoPhonePickerCard(appName));
//			environmentPicker.EnvironmentPickerButtonSelect(env);
//			multiCard.MultiCardLoginCheck();
//			CardLogin.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.accountType);
//			Biometrics.BiometricsAndroid();
//			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.accountType);
//			registerCheck.registerCheckAndroid(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
//			Logout.logoutCardControl();
//			androidLogs.CapturedLogs(info, "Logged out");
//			
//			Capabilities.driver.closeApp();
//			Capabilities.driver.quit();

			androidLogs.CapturedLogs(info, "Register Check functional test completed");

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

	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: " + cardNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + cardNum);
		return cardNum;
	}
}