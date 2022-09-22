package androidCarrierClasses;


import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenAndLoginCarrierControl {

	static AppiumDriver<WebElement> driver;


	public void openCarrierControl() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginFailVerificationCarrierControl failLogin = new LoginFailVerificationCarrierControl();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		ResetTestAccounts resetAccounts = new ResetTestAccounts();
		WelcomeScreen welcome = new WelcomeScreen();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		
		String storedAccount;
		String storedPinOrPassword;
		String env;
		String appName = "Carrier Control";
		
		
//TODO	ENV AUTO AND ACCOUNT SETUP 
//		environmentPicker.SetEnvironment();
//		env = environmentPicker.getEnviroment();
//		getAccount.setEnv(env);
//		getAccount.CardPassExpected("ACTIVE_CARRIERCONTROL_ACCOUNT");
//		storedCard = getAccount.getCardNum();
//		storedPin = getAccount.getPasswordOrPin();
		
		
		//FAKE LOGIN
		androidLogs.setupTestYellow("FAKE LOGIN");
		System.out.println(phone.autoPhonePickerCarrier(appName));
		Thread.sleep(3000);
		environmentPicker.EnvironmentPickerButton();
		getAccount.setEnv(environmentPicker.getEnviroment());
		env = environmentPicker.getEnviroment();
		welcome.welomeScreen();
		failLogin.FailExpected(env);
				
		//LOCKED LOGIN
		androidLogs.setupTestYellow("LOCKED LOGIN");
		//System.out.println(phone.autoPhonePickerCarrier());
		Thread.sleep(3000);
		failLogin.LockedLoginExpected(env);
				
		//SUSPENDED LOGIN
		androidLogs.setupTestYellow("SUSPENDED LOGIN");
		Thread.sleep(3000);
		failLogin.SuspendedLoginExpected(env);

		//LOGIN SUCCESS
		androidLogs.setupTestYellow("SUCCESSFULL LOGIN");
		Thread.sleep(3000);
		getAccount.CardPassExpected("CARRIER_100045");
		storedAccount = getAccount.getAccountNum();
		storedPinOrPassword = getAccount.getPasswordOrPin();
		passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
		Biometrics.BiometricsCarrierControlAndroid();
		
		
		
	}
}
