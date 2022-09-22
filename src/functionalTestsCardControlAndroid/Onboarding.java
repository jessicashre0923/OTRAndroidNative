package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CardLoginPassSecureFuel;
import androidCardClasses.CardLoginPasscode;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.OnboardingScreens;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class Onboarding {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;

	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		OnboardingScreens onboarding = new OnboardingScreens();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String appName = "Card Control";
		
		try {
			
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("ONBOARDING");

			// COMPANY CARD
			androidLogs.setupTestYellow("COMPANY CARD");
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "COMPANY";
			getAccount.CardPassExpected(cardType);
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(environmentPicker.getEnviroment());
			onboarding.OnboardingScreens(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// SMARTFUNDS CARD
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("SMARTFUNDS CARD");
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "SMARTFUNDS";
			getAccount.CardPassExpected(cardType);
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(environmentPicker.getEnviroment());
			onboarding.OnboardingScreens(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// UNIVERSAL CARD
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("UNIVERSAL CARD");
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "UNIVERSAL";
			getAccount.CardPassExpected(cardType);
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(environmentPicker.getEnviroment());
			onboarding.OnboardingScreens(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			// PASSCODE Card (this comes from turning on dynamic pin)

			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("PASSCODE CARD INCLUDES PROFILE SETUP");
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "PASSCODE";
			getAccount.CardPassExpected(cardType);
			
			ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());

			// Delete passcode in database
			System.out.println(
					"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
			// login with temp passcode
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			createPasscode.NewPasscode(environmentPicker.getEnviroment());

			// Login with newly set card passcode
			// Login.CardPassExpected(environmentPicker.getEnviroment(),
			// getAccount.getAccountNum(), "985477",this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(environmentPicker.getEnviroment());
			onboarding.OnboardingScreens(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
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