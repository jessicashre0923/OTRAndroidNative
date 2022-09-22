package carrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSmashLoginRun {
	static AppiumDriver<WebElement> driver;
//	private String carrierNum;	
	private String carrierType;

	@Test
	public void cardControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		
		
//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		int timesToRun = 1;
		int runsPerCarrier = 3;
		int smashLogin = 0;
		int perCarrierLogin = 0;
		String storedCarrier;
		String storedPassword;
		String env;

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smash Login ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "AWS DIT ";

		try {
			androidLogs.setupTest(TestName + build + appName + server);

			while (smashLogin < timesToRun) {
				System.out.println("Times test has run: " + smashLogin);
				androidLogs.setupTest("LOGIN CYCLE TEST");
				// 102698
				perCarrierLogin = 0;
				androidLogs.setupTestYellow("CARRIER_102698");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_102698");
				carrierType = "CARRIER_102698";
				androidLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();
				System.out.println(storedCarrier);
				System.out.println(storedPassword);

				while (perCarrierLogin < runsPerCarrier) {
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedCarrier, storedPassword);
					Biometrics.BiometricsAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				androidLogs.setupTest("LOGIN CYCLE TEST");
				// 100045
				perCarrierLogin = 0;
				androidLogs.setupTestYellow("CARRIER_100045");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_100045");
				carrierType = "CARRIER_100045";
				androidLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();

				while (perCarrierLogin < runsPerCarrier) {
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedCarrier, storedPassword);
					Biometrics.BiometricsAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				androidLogs.setupTest("LOGIN CYCLE TEST");
				// CARRIER_100644
				perCarrierLogin = 0;
				androidLogs.setupTestYellow("CARRIER_100644");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_100644");
				carrierType = "CARRIER_100644";
				androidLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();

				while (perCarrierLogin < runsPerCarrier) {
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.EnvironmentPickerButton();
					welcome.welomeScreen();
					passLogin.PassExpected(env, storedCarrier, storedPassword);
					Biometrics.BiometricsAndroid();
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					androidLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

//TODO ADD MORE ACCOUNT TYPES			

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