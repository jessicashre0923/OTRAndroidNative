package functionalTestsCardControlAndroid;

import java.io.IOException;
import java.sql.ResultSet;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.CreateProfile;
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

public class SetupProfileRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;
		
	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl Logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CreateProfile SetupProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		HelpScreen helpScreen = new HelpScreen();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String env;
		String appName = "Card Control";
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		
		try {
			androidLogs.setupTestYellow("Setup Profile Functional test");
			androidLogs.setupTestYellow("PROFILE CARD");
				
			getAccount.setEnv(env);
			cardType = "SETUP_PROFILE";
			getAccount.CardPassExpected(cardType);
			String storedCardNum = getAccount.getAccountNum();
			String storedPinPasscode = getAccount.getPasswordOrPin();
						
			// Database interaction
			// Delete found profile so we can make a new one
			androidLogs.CapturedLogs(info, "Starting search for profile and deletion execution");
			ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());
			String profileID = "notFound";
			ResultSet profileIDDB = dbACPTCheck.query("infx",
					String.format("SELECT profile_id FROM ach_profile_card_xref WHERE card_num ='"
							+ storedCardNum + "'"));
			profileIDDB.next();
			profileID = profileIDDB.getString("profile_id");
			androidLogs.CapturedLogs(pass, "Profile ID found as: " + profileID);
			System.out.println(profileID);
			androidLogs.CapturedLogs(pass, "Deleting profile id: " + profileID);
			dbACPTCheck.execute("infx", "DELETE FROM ach_profile_card_xref WHERE profile_id =" + profileID);
			dbACPTCheck.execute("infx", "DELETE FROM ach_driver_profile WHERE profile_id =" + profileID);
			androidLogs.CapturedLogs(pass, " Deleted profile id: " + profileID);
			androidLogs.CapturedLogs(pass, " Setup profile test ready to begin");

			

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			
			
			androidLogs.CapturedLogs(info, "Starting login process");
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Biometrics.BiometricsAndroid();
			SetupProfile.ProfileSetup(environmentPicker.getEnviroment());
			helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");
			Thread.sleep(3000);

			// checking for login after profile creation to make sure it logs in and does
			// not ask to create a profile
			androidLogs.CapturedLogs(info, "Login started with same account and verifying profile is still setup");
			System.out.println(phone.autoPhonePickerCard(appName));
			Thread.sleep(3000);
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			Login.CardPassExpected(environmentPicker.getEnviroment(), storedCardNum, storedPinPasscode, this.cardType);
			Biometrics.BiometricsAndroid();
			SetupProfile.ProfileSetup(environmentPicker.getEnviroment());
			helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(info, "Setup Profile functional test completed");

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