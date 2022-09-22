package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class QuickLoginLogoutRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;

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
		HomeLandingPage homePage = new HomeLandingPage();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		String storedAccount;
		String storedPinOrPassword;
		String env;
		String appName = "Card Control";
		
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		try {
			androidLogs.setupTestYellow("Quick Login Logout Function test");

			// COMPANY CARD
			androidLogs.setupTestYellow("COMPANY CARD");
			getAccount.setEnv(env);
			cardType = "COMPANY";
			getAccount.CardPassExpected(cardType);
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// SMARTFUNDS CARD
			androidLogs.setupTestYellow("SMARTFUNDS CARD");
			getAccount.setEnv(env);
			cardType = "SMARTFUNDS";
			getAccount.CardPassExpected(cardType);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// FLEET ONE CARD
			androidLogs.setupTestYellow("FLEET ONE CARD");
			getAccount.setEnv(env);
			cardType = "FLEET_ONE";
			getAccount.CardPassExpected(cardType);
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// UNIVERSAL CARD
			androidLogs.setupTestYellow("UNIVERSAL CARD");
			getAccount.setEnv(env);
			cardType = "UNIVERSAL";
			getAccount.CardPassExpected(cardType);
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// PASSCODE Card (this comes from turning on dynamic pin)
			androidLogs.setupTestYellow("PASSCODE CARD");
			getAccount.setEnv(env);
			cardType = "PASSCODE";
			getAccount.CardPassExpected(cardType);
		

			// Delete passcode in database
			System.out.println(
					"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
			// login with temp passcode
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			createPasscode.NewPasscode(env);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();

			androidLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//TODO add a fleet one card also...

			androidLogs.CapturedLogs(info, "Quick Login Logout functional test completed");

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