package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.AccountTab;
import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AccountTabRun{
	static AppiumDriver<WebElement> driver;
	@Test
	public void carrierControlTestAndroidLoginLogout() {
		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		AccountTab accountTab = new AccountTab();
//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String appName = "Carrier Control";
		
		try {
			androidLogs.setupTestYellow("Account Tab Functional Test on 100045");			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			Thread.sleep(3000);
			environmentPicker.EnvironmentPickerButton();	
			welcome.welomeScreen();
			passLogin.PassExpected(environmentPicker.getEnviroment(), "100045", "985477");
			Biometrics.BiometricsCarrierControlAndroid();
			accountTab.accountTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(info, "Logged out");
			
			androidLogs.CapturedLogs(info, "Account tab Functional Test completed");

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
//				androidLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}