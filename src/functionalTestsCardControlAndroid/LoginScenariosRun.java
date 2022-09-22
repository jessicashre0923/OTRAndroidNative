package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import io.appium.java_client.AppiumDriver;
import androidCardClasses.OpenAndLoginCardControl;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.PhonePicker;

public class LoginScenariosRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;

	@Test
	public void cardControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		OpenAndLoginCardControl OpenAndLoginCardControl = new OpenAndLoginCardControl();
		LogOutCardControl logout = new LogOutCardControl();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		HelpScreen helpScreen = new HelpScreen();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String appName = "Carrier Control";
//		
		try {
			// Login logout testing
			androidLogs.setupTestYellow("LOCK SUSPENED AND LOGIN TESTS");
			OpenAndLoginCardControl.openCardControl();

			// COMPANY CARD
			androidLogs.setupTestYellow("SUCESSFUL LOGIN TEST");
			System.out.println(phone.autoPhonePickerCard(appName));
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
			helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
					getAccount.getPasswordOrPin(), this.cardType);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of " +cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(androidText.PASS, "Login scenarios functional test completed.");

		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
			} else {
				errorMessage = errorMessage + " " + exp.getCause();
				System.out.println("Error is: " + errorMessage);
			}
			System.out.println("gets cause: " + exp.getCause());
			System.out.println("get message" + exp.getMessage());
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