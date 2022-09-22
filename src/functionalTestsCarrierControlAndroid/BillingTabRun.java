package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.BillingTab;
import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class BillingTabRun{

	static AppiumDriver<WebElement> driver;

	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		BillingTab paymentTab = new BillingTab();
		
		try {
			String appName = "Carrier Control";			
			androidLogs.setupTest("Billing Tab Functional Test");
			System.out.println(phone.autoPhonePickerCarrier(appName));
			//Select wanted enviroment and set it
			environmentPicker.EnvironmentPickerButton();	
			//Welcome Screen
			welcome.welomeScreen();
			subUserLogin.PassExpected();
			//check for biometrics modal
			Biometrics.BiometricsCarrierControlAndroid();
			paymentTab.billingTab();
			//log out
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