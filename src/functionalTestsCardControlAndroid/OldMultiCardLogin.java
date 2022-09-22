package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.MultiCardsLogin;
import androidCardClasses.MultiCardsRemoveCard;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OldMultiCardLogin {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;
	String env;

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
		MultiCardsLogin multiCardsLogin = new MultiCardsLogin();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		MultiCardsRemoveCard removeCard = new MultiCardsRemoveCard();
		HomeLandingPage homePage = new HomeLandingPage();

		try {
			String appName = "Card Control";
			androidLogs.setupTest("MultiCard Login Logout Function test");

			// COMPANY
			environmentPicker.SetEnvironment();
			env = environmentPicker.getEnviroment();
			getAccount.setEnv(env);
			cardType = "COMPANY";
			getAccount.CardPassExpected(cardType);
			androidLogs.setupTestYellow("LOCATING " + cardType + " CARD ON: " + env);
			String companyCard = getAccount.getAccountNum();
			String companyCardPin = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, companyCard, companyCardPin, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, companyCard, companyCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// FLEET ONE CARD
			environmentPicker.getEnviroment();
			getAccount.setEnv(env);
			cardType = "FLEET_ONE";
			getAccount.CardPassExpected(cardType);
			androidLogs.setupTestYellow("LOCATING " + cardType + " CARD ON: " + env);
			String fleetOneCard = getAccount.getAccountNum();
			String fleetOneCardPin = getAccount.getPasswordOrPin();

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, fleetOneCard, fleetOneCardPin, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, fleetOneCard, fleetOneCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// SMARTFUNDS
			environmentPicker.SetEnvironment();
			getAccount.setEnv(env);
			cardType = "SMARTFUNDS";
			getAccount.CardPassExpected(cardType);
			androidLogs.setupTestYellow("LOCATING " + cardType + " CARD ON: " + env);
			String smartfundsCard = getAccount.getAccountNum();
			String smartfundsCardPin = getAccount.getPasswordOrPin();

			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, smartfundsCard, smartfundsCardPin, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, smartfundsCard, smartfundsCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// UNIVERSAL
			environmentPicker.SetEnvironment();
			getAccount.setEnv(env);
			cardType = "UNIVERSAL";
			getAccount.CardPassExpected(cardType);
			androidLogs.setupTestYellow("LOCATING " + cardType + " CARD ON: " + env);
			String universalCard = getAccount.getAccountNum();
			String universalCardPin = getAccount.getPasswordOrPin();

			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, universalCard, universalCardPin, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, universalCard, universalCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// COMPANY MultiCard page login
			androidLogs.setupTestYellow("Testing Company login via list");
			environmentPicker.EnvironmentPickerButton();
			getAccount.setEnv(env);
			multiCardsLogin.multiCardPassExpected(env, companyCard, companyCardPin);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, companyCard, companyCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// SMARTFUNDS MultiCard page Login
			androidLogs.setupTestYellow("Testing SmartFunds login via list");
			environmentPicker.EnvironmentPickerButton();
			getAccount.setEnv(env);
			multiCardsLogin.multiCardPassExpected(env, smartfundsCard, smartfundsCardPin);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env, smartfundsCard, smartfundsCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// UNIVERSAL MultiCard page login
			androidLogs.setupTestYellow("Testing Universal login via list");
			environmentPicker.EnvironmentPickerButton();
			getAccount.setEnv(env);
			multiCardsLogin.multiCardPassExpected(env, universalCard, universalCardPin);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(environmentPicker.getEnviroment());
			homePage.HomeLandingPage(env, universalCard, universalCardPin, this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");

			// UNIVERSAL MultiCard page login
			androidLogs.setupTestYellow("Testing Edit and Remove card");
			environmentPicker.EnvironmentPickerButton();
			getAccount.setEnv(env);
			removeCard.multiCardPassExpected(env, universalCard, universalCardPin);

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

//TODO add a fleet one card also...

			androidLogs.CapturedLogs(androidText.INFO, "MultiCard Login Logout functional test completed");

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

	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: " + cardNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + cardNum);
		return cardNum;
	}
}