package carrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.MultiCardLoginCheck;
import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.AutoFindLogin;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountCardAndCarrierSmashRun2 {
	static AppiumDriver<WebElement> driver;
	private String cardType;

	@Test
	public void cardControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		AutoFindLogin autoFindLogin = new AutoFindLogin();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		HelpScreen helpScreen = new HelpScreen();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		int timesToRun = 1;
		int runsPerAccount = 3;
		int smashLogin = 0;
		int perAccountLogin = 0;
		String storedAccount;
		String storedPinOrPassword;
		String env;
		String appNameCard = "Carrier Control";
		String appNameCarrier = "Carrier Control";

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smash run 2 ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "AWS DIT ";

		try {
			androidLogs.setupTest(TestName + build + appName + server);

			while (smashLogin < timesToRun) {
				System.out.println("Times test has run: " + smashLogin);
				androidLogs.setupTest("LOGIN CYCLE TEST");

				// 102698
				perAccountLogin = 0;

				androidLogs.setupTestYellow("CARRIER_102698");
				autoFindLogin.CardPassExpected("CARRIER_102698");

				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();

				while (perAccountLogin < runsPerAccount) {
					System.out.println(phone.autoPhonePickerCarrier(appNameCarrier));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsCarrierControlAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedAccount + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// 102698db
				perAccountLogin = 0;
				androidLogs.setupTestYellow("CARRIER_102698db");
				autoFindLogin.CardPassExpected("CARRIER_102698db");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();

				while (perAccountLogin < runsPerAccount) {
					System.out.println(phone.autoPhonePickerCarrier(appNameCarrier));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsCarrierControlAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedAccount + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				androidLogs.setupTest("LOGIN CYCLE TEST");
				// 100045
				perAccountLogin = 0;
				androidLogs.setupTestYellow("CARRIER_100045");
				autoFindLogin.CardPassExpected("CARRIER_100045");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();

				while (perAccountLogin < runsPerAccount) {
					System.out.println(phone.autoPhonePickerCarrier(appNameCarrier));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsCarrierControlAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedAccount + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				androidLogs.setupTest("LOGIN CYCLE TEST");
				// CARRIER_100644
				perAccountLogin = 0;
				androidLogs.setupTestYellow("CARRIER_100644");
				autoFindLogin.CardPassExpected("CARRIER_100644");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();

				while (perAccountLogin < runsPerAccount) {
					System.out.println(phone.autoPhonePickerCarrier(appNameCarrier));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsCarrierControlAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedAccount + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

//TODO CAN ADD MORE ACCOUNT TYPES			

				// FLEET ONE
				perAccountLogin = 0;
				androidLogs.setupTestYellow("FLEET_ONE");
				autoFindLogin.CardPassExpected("FLEET_ONE");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();
				cardType = "FLEET ONE CARD";

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(storedAccount + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appNameCard));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsCarrierControlAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// COMPANY CARD
				perAccountLogin = 0;
				androidLogs.setupTestYellow("COMPANY");
				autoFindLogin.CardPassExpected("COMPANY");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();
				cardType = "COMPANY CARD";

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appNameCard));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsCarrierControlAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// SMARTFUNDS CARD
				perAccountLogin = 0;
				androidLogs.setupTestYellow("SMARTFUNDS");
				autoFindLogin.CardPassExpected("SMARTFUNDS");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();
				cardType = "SMARTFUNDS";

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appNameCard));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsCarrierControlAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// UNIVERSAL CARD
				perAccountLogin = 0;
				androidLogs.setupTestYellow("UNIVERSAL");
				autoFindLogin.CardPassExpected("UNIVERSAL");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();
				cardType = "UNIVERSAL";

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appNameCard));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsCarrierControlAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// PASSCODE Card (this comes from turning on dynamic pin)
				perAccountLogin = 0;
				androidLogs.setupTestYellow("UNIVERSAL");
				autoFindLogin.CardPassExpected("UNIVERSAL");
				storedAccount = autoFindLogin.getAccountNum();
				storedPinOrPassword = autoFindLogin.getPasswordOrPin();
				env = autoFindLogin.getEnv();
				cardType = "UNIVERSAL";

				ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());

				// Delete passcode in database
				System.out.println(
						"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
				dbACPTCheck.execute("infx",
						"Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
				System.out.println(phone.autoPhonePickerCard(appNameCard));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
				createPasscode.NewPasscode(environmentPicker.getEnviroment());
				Biometrics.BiometricsCarrierControlAndroid();
				helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
				storedPinOrPassword = androidText.MANUAL_PASSCODE;
				Capabilities.driver.closeApp();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(cardType + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appNameCard));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.cardType);
					Biometrics.BiometricsCarrierControlAndroid();
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.cardType);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + cardType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				smashLogin++;
				androidLogs.setupTestYellow("ALL CARRIER LOGIN COUNT #: " + smashLogin);
				// androidLogs.setupTestYellow("LOGIN TESTS COMPLETED #: " + smashLogin);
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
}