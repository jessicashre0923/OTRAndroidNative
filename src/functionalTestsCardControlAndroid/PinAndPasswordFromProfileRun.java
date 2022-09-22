package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.ResetPinAndPasscodeFromProfilePage;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.MultiCardLoginCheck;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class PinAndPasswordFromProfileRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String accountType;
	String env;

	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		ResetPinAndPasscodeFromProfilePage resetPinAndPasscodeFromProfile = new ResetPinAndPasscodeFromProfilePage();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;
		String appName = "Card Control";
		
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		try {
			androidLogs.setupTest("RESET PIN & PASSCODE FUCNTION TEST");
			getAccount.setEnv(env);
			accountType = "UNIVERSAL";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(env);

			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			resetPinAndPasscodeFromProfile.openProfileButtonFromHome(env, storedAccount, storedPinOrPassword);
			// logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of " +accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// PASSCODE Card (this comes from turning on dynamic pin)
			androidLogs.setupTest("RESET PASSCODE FUNCTION TEST");
			getAccount.setEnv(env);
			accountType = "PASSCODE";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			// Delete passcode in database
			System.out.println(
					"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + storedAccount + "'");
			// login with temp passcode
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, getAccount.getPasswordOrPin(), accountType);
			createPasscode.NewPasscode(env);
			// Login with newly set card passcode
			// Login.CardPassExpected(env, getAccount.getAccountNum(),
			// "985477",accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);

			resetPinAndPasscodeFromProfile.openProfileButtonFromHome(env, storedAccount, "985477");
			// logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of " +accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// Company card Pin
			androidLogs.setupTest("RESET PASSCODE COMPANY CARD");
			getAccount.setEnv(env);
			accountType = "COMPANY";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			resetPinAndPasscodeFromProfile.openProfileButtonFromHome(env, storedAccount, storedPinOrPassword);
			// logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of " +accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(androidText.INFO, "Reset Pin And Password From Profile test completed");
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