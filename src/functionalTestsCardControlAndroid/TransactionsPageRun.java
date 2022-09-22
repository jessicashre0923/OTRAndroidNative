package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.TransactionsPage;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class TransactionsPageRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String accountType;
	private String env;
	String appName = "Card Control";
	
	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		TransactionsPage transactions = new TransactionsPage();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;

		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

//TODO THIS IS A WORK IN PROGRESS TRANSACTIONS.TRANSACTIONS PAGE IS NOT YET STARTED		

		try {
			androidLogs.setupTest("Transactions Page Function test");
			getAccount.setEnv(env);
			accountType = "COMPANY CARD";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected("COMPANY");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			transactions.TransactionsPage(env, storedAccount, storedPinOrPassword, accountType);

			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of COMPANY Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// FLEET ONE CARD
			getAccount.setEnv(env);
			accountType = "FLEET ONE CARD";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected("FLEET_ONE");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			transactions.TransactionsPage(env, storedAccount, storedPinOrPassword, accountType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of FLEET ONE Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// SMARTFUNDS CARD
			getAccount.setEnv(env);
			accountType = "SMARTFUNDS CARD";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected("SMARTFUNDS");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			transactions.TransactionsPage(env, storedAccount, storedPinOrPassword, accountType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of SMARTFUNDS Cards");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// UNIVERSAL CARD
			getAccount.setEnv(env);
			accountType = "UNIVERSAL CARD";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected("UNIVERSAL");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			transactions.TransactionsPage(env, storedAccount, storedPinOrPassword, accountType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of UNIVERSAL Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// PASSCODE Card (this comes from turning on dynamic pin)
			getAccount.setEnv(env);
			accountType = "PASSCODE CARD";
			androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
			getAccount.CardPassExpected("PASSCODE");

			// Delete passcode in database
			System.out.println(
					"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
			// login with temp passcode
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());

			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
			createPasscode.NewPasscode(env);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			transactions.TransactionsPage(env, storedAccount, storedPinOrPassword, accountType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of PASSCODE Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//TODO add a fleet one card also...

			androidLogs.CapturedLogs(info, "Transactions functional test completed");

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