package cardControlAndroid;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.MultiCardLoginCheck;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSmashLoginRun {
	static AppiumDriver<WebElement> driver;
	private String accountNum;
	private String accountType;
	
	

	//GIVE YOUR TEST THE MANUAL DEFAULT DETAILS IT NEEDS TO RUN ENV IS VITAL TO RUN TEST
	// env IS THE SERVER YOU ARE RUNNING THE TEST ON
	//TestName IS THE NAME OF HTE TEST YOU WANT TO GOVE IT
	// build IS THE BUILD NUMBER ARE USING FROM TESTFLIGHT OR APP TEST
	// appName NAME OF APP BEING TESTED
		
	String TestName = "Unit Test Multi Card ";
	String build = "Build #:  ";
	String appName = "Card Control ";
	String env = "PARTNER ";


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
		CreatePasscode createPasscode = new CreatePasscode();
		HelpScreen helpScreen = new HelpScreen();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		int timesToRun = 1;
		int runsPerAccount = 1;
		int smashLogin = 0;
		int perAccountLogin = 0;
		String storedAccount;
		String storedPinOrPassword;
		String env;
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		String cardID;

		try {
			androidLogs.setupTest(TestName + build + appName +env);
			
			while (smashLogin < timesToRun) {
				System.out.println("Times test has run: " + smashLogin);

				androidLogs.setupTest("LOGIN VERIFICATION TEST");

				// MasterCard
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "MasterCard";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// FLEET ONE
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "FLEET_ONE";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// COMPANY CARD
				perAccountLogin = 0;

				getAccount.setEnv(env);
				accountType = "COMPANY";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// SMARTFUNDS CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "SMARTFUNDS";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// UNIVERSAL CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "UNIVERSAL";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// PASSCODE Card (this comes from turning on dynamic pin)
				perAccountLogin = 0;
				Thread.sleep(3000);
				androidLogs.setupTestYellow("PASSCODE CARD");
				getAccount.setEnv(env);
				accountType = "PASSCODE";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected(accountType);
				storedAccount = getAccount.getAccountNum();
				storedPinOrPassword = getAccount.getPasswordOrPin();

				ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

				// Delete passcode in database
				System.out.println(
						"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
				dbACPTCheck.execute("infx",
						"Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
				createPasscode.NewPasscode(env);
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
				storedPinOrPassword = androidText.MANUAL_PASSCODE;
				Capabilities.driver.closeApp();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");

				while (perAccountLogin < runsPerAccount) {
					cardID = getAccount.getCardID(storedAccount, env);
					androidLogs
							.setupTestYellow(accountType + "CardID: " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
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
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: " + accountNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + accountNum);
		return accountNum;
	}
}