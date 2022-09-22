package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreateProfile;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.SecureFuel;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class SecureFuelRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;
	
	
	@Test
	public void cardControlTestAndroid() throws Exception {
//TODO might have a vpn issue running this one. 
		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl Logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		SecureFuel secureFuel = new SecureFuel();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		CreateProfile createProfile = new CreateProfile();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		HelpScreen helpScreen = new HelpScreen();

		String env;
		String appName = "Card Control";
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		
//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
//TODO IDEA FOR ADDING FAKE DATA androidText.getFakeAddress();		

		try {
			androidLogs.setupTestYellow("SECURE FUEL DOES NOT NEEDS UNIT NUMBER");
			
			getAccount.setEnv(env);
			cardType = "SECURE_FUEL_DOES NOT_NEED_UNIT_NUMBER";
			getAccount.CardPassExpected(cardType);
			String storedCardNum = getAccount.getAccountNum();
			String storedPinPasscode = getAccount.getPasswordOrPin();
				
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, storedCardNum,storedPinPasscode, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			helpScreen.HelpScreenContinue(env, storedCardNum,storedPinPasscode, this.cardType);
			secureFuel.secureFuel(getAccount.getUnitID());
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");

			androidLogs.setupTestYellow("SECURE FUEL NEEDS UNIT NUMBER");
			System.out.println(phone.autoPhonePickerCard(appName));
			cardType = "SECURE_FUEL_NEEDS_UNIT_NUMBER";
			androidLogs.CapturedLogs(info, "might have a vpn issue running this one");
			environmentPicker.EnvironmentPickerButton();
			androidLogs.setupTest("SECURE FUEL NEEDS UNIT NUMBER");
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			getAccount.CardPassExpected(cardType);
			Login.CardPassExpected(env, storedCardNum,storedPinPasscode, this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			helpScreen.HelpScreenContinue(env, storedCardNum,storedPinPasscode, this.cardType);
			secureFuel.secureFuel(getAccount.getUnitID());
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");

			androidLogs.CapturedLogs(info, "Secure Fuel functional test completed");

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