package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.AccountTabManageYourProfile;
import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.RepoCarrierAndroid;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class ManageYourProfileRun{

	static AppiumDriver<WebElement> driver;

	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();
		AccountTabManageYourProfile manageYourProfile = new AccountTabManageYourProfile();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		
		try {
			String appName = "Carrier Control";			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			androidLogs.setupTest("Manage your profile Functional Test on 102698db");
			
			//Select wanted enviroment and set it
			environmentPicker.EnvironmentPickerButton();	
			//Welcome Screen
			welcome.welomeScreen();
			subUserLogin.PassExpected();
			//check for biometrics modal
			Biometrics.BiometricsCarrierControlAndroid();
			androidLogs.setupTest("Manage your profile");
			Thread.sleep(3000);
			WebElement AccountTab = elements.AccountTab();
			if (AccountTab.isEnabled()) {
				AccountTab.click();
				androidLogs.CapturedLogs(androidText.PASS, "Account tab opened");
				Thread.sleep(3000);
				WebElement ManageYourProfile = elements.ManageYourProfile();
				Thread.sleep(3000);
				if (ManageYourProfile != null && ManageYourProfile.isEnabled()) {
					ManageYourProfile.click();
					androidLogs.CapturedLogs(androidText.PASS, "Manage your profile opened");

//This section tests and updated the profile name and details if it fails it puts the wrong info on the account Skipping probably should be done manually... 		
// edit account information
//					manageYourProfile.AccountTabManageYourProfile();

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Manage your profile not found.");
				}
			}
			//log out
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			
			androidLogs.CapturedLogs(androidText.INFO, "Manage your profile Functional Test completed");

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