package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.BillingTab;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.AutoFindLogin;
import androidSharedClasses.AutoFindLogin;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class TryAutoFindLoginRun{

	static AppiumDriver<WebElement> driver;
	private String carrier;	
	private String carrierOrCard;
	String env;
	
	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		BillingTab paymentTab = new BillingTab();
		
		AutoFindLogin autoFindLogin = new AutoFindLogin();
		
		try {
			String appName = "Carrier Control";			
			String storedAccount;
			String storedPassword;
			String env;
			
			
			autoFindLogin.CardPassExpected("CARRIER_102698db");
			storedAccount = autoFindLogin.getAccountNum();
			storedPassword = autoFindLogin.getPasswordOrPin();
			env = autoFindLogin.getEnv();		
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();	
			welcome.welomeScreen();
			subUserLogin.PassExpected(env, storedAccount, storedPassword);
			Biometrics.BiometricsAndroid();
			paymentTab.billingTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			androidLogs.CapturedLogs(androidText.INFO, "Billing tab Functional Test completed");

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