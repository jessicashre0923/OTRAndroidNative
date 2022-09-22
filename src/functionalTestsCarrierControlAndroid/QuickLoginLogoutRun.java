package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.AutoAccountLoginPass;
import androidCarrierClasses.BiometricsCarrierControlAndroid;
import androidCarrierClasses.LoginCompanyCC;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LoginUniversalCC;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class QuickLoginLogoutRun {

	static AppiumDriver<WebElement> driver;

	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		LoginUniversalCC loginUniversal = new LoginUniversalCC();
		LoginCompanyCC companyLogin = new LoginCompanyCC();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		AutoAccountLoginPass autoAccountLogin = new AutoAccountLoginPass();
		
		String env;
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		
		try {
			getAccount.setEnv(env);
					
			String appName = "Carrier Control";
			String storedAccount;
			String storedPinOrPassword;
			
			
			//100045			
			androidLogs.setupTest("Quick Login Logout Function test");
			androidLogs.setupTestYellow("LOGIN LOGOUT 100045");
			
			getAccount.CardPassExpected("CARRIER_100045");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			Thread.sleep(3000);
			environmentPicker.EnvironmentPickerButton();	
			welcome.welomeScreen();
			passLogin.PassExpected(environmentPicker.getEnviroment(), storedAccount, storedPinOrPassword);
			Biometrics.BiometricsCarrierControlAndroid();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out of "+storedAccount);
//				
//			
//			//102698db
//			System.out.println("Set manual login for this account for now should be this login on most servers");
//			androidLogs.setupTestYellow("LOGIN LOGOUT 102698db");
//			getAccount.CardPassExpected("CARRIER_102698db");
//			storedAccount = getAccount.getAccountNum();
//			storedPinOrPassword = getAccount.getPasswordOrPin();
//			
//			System.out.println(phone.autoPhonePickerCarrier(appName));
//			//Select wanted enviroment and set it
//			Thread.sleep(3000);
//			environmentPicker.EnvironmentPickerButton();	
//			welcome.welomeScreen();
//			subUserLogin.PassExpected(environmentPicker.getEnviroment(), storedAccount, storedPinOrPassword);
//			Biometrics.BiometricsCarrierControlAndroid();
//			logoutApp.logOutCarrierControll();
//			androidLogs.CapturedLogs(androidText.INFO, "Logged out of "+storedAccount);
//			
//			
			//129698
			androidLogs.setupTestYellow("LOGIN LOGOUT 129698");
			
			getAccount.CardPassExpected("CARRIER_129698");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			//Select wanted enviroment and set it
			Thread.sleep(3000);
			environmentPicker.EnvironmentPickerButton();	
			welcome.welomeScreen();
			loginUniversal.LoginUniversalCC(environmentPicker.getEnviroment(), storedAccount, storedPinOrPassword);
			Biometrics.BiometricsCarrierControlAndroid();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out of "+storedAccount);
		
			
			//103526
			androidLogs.setupTestYellow("LOGIN LOGOUT 103526");
			
			getAccount.CardPassExpected("CARRIER_103526");
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			//Select wanted enviroment and set it
			Thread.sleep(3000);
			environmentPicker.EnvironmentPickerButton();	
			welcome.welomeScreen();
			companyLogin.LoginCompanyCC(environmentPicker.getEnviroment(), storedAccount, storedPinOrPassword);
			Biometrics.BiometricsCarrierControlAndroid();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out of "+storedAccount);
					
			androidLogs.CapturedLogs(androidText.INFO, "Quick login logout Functional Test completed");
			
			
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