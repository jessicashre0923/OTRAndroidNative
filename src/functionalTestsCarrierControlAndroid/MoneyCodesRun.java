package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.MoneyCodesTab;
import androidCarrierClasses.ProgressSpinner;
import androidCarrierClasses.ResetTestAccounts;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.AutoFindLogin;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class MoneyCodesRun{

	static AppiumDriver<WebElement> driver;
	String storedAccount;
	String storedPinOrPassword;
	String env;
	
	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		WelcomeScreen welcome = new WelcomeScreen();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		ProgressSpinner loading = new ProgressSpinner();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		AutoFindLogin autoFindLogin = new AutoFindLogin();
		
		try {
			String appName = "Carrier Control";		
			androidLogs.setupTestYellow("CARRIER_100045");
			autoFindLogin.CardPassExpected("CARRIER_100045");
			storedAccount = autoFindLogin.getAccountNum();
			storedPinOrPassword = autoFindLogin.getPasswordOrPin();
			env = autoFindLogin.getEnv();
			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
			Biometrics.BiometricsCarrierControlAndroid();
			moneyCodesTab.moneyCodesTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			androidLogs.CapturedLogs(androidText.INFO, "Money Codes Functional Testing 100045 completed");
			
			
			//test number two using 102698db
			//102698db
			androidLogs.setupTestYellow("CARRIER_102698db");
			autoFindLogin.CardPassExpected("CARRIER_102698db");
			storedAccount = autoFindLogin.getAccountNum();
			storedPinOrPassword = autoFindLogin.getPasswordOrPin();
			env = autoFindLogin.getEnv();
						
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
			Biometrics.BiometricsCarrierControlAndroid();
			moneyCodesTab.moneyCodesTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			androidLogs.CapturedLogs(androidText.INFO, "Money Codes Functional 102698db Testing completed");
					
			
			
			
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
}