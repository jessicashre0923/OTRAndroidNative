package cardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.RateThisApp;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class CICDSmashLoginAltTests {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;
	
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
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		HelpScreen helpScreen = new HelpScreen();
		RateThisApp rateThisApp = new RateThisApp();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		int timesToRun = 1;
		int runsPerAccount = 11;
		int smashLogin = 0;
		int perAccountLogin = 0;
		String storedAccount;
		String storedPinOrPassword;

	
	
		



		//environmentPicker.SetEnvironment();
		//env = environmentPicker.getEnviroment();
		
		environmentPicker.SetEnvironmentSelect(env);
		//environmentPicker.EnvironmentPickerButtonSelect(env);
		
		
		try {
			androidLogs.setupTestYellow(TestName + build + appName +env);
			
			while (smashLogin < timesToRun) {
				System.out.println("Times test has run: " + smashLogin);

				androidLogs.setupTest("LOGIN VERIFICATION TEST");
				// FLEET ONE
				perAccountLogin = 0;

				getAccount.setEnv(env);
				getAccount.CardPassExpected("FLEET_ONE");
				cardType = "FLEET ONE CARD";
				androidLogs.setupTestYellow("LOCATING " + cardType + " ON: " + env);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {

					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButtonSelect(env);
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					rateThisApp.rateThisApp(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// COMPANY CARD
				perAccountLogin = 0;
				environmentPicker.SetEnvironment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("COMPANY");
				cardType = "COMPANY CARD";
				androidLogs.setupTestYellow("LOCATING " + cardType + " ON: " + env);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButtonSelect(env);
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					rateThisApp.rateThisApp(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				smashLogin++;
				androidLogs.setupTestYellow("ALL CARRIER LOGIN COUNT #: " + smashLogin);
				// androidLogs.CapturedLogs(info, "LOGIN TESTS COMPLETED CYCLE #: " +
				// smashLogin);
			}
			// androidLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin +"
			// CYCLES");
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