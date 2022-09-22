package functionalTestsCarrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCarrierClasses.AccountTab;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
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

public class AutoAccountTabRun{
	static AppiumDriver<WebElement> driver;
	private String carrier;	
	private String carrierType;
	String env;
	String appName = "Carrier Control";
	
	@Test
	public void carrierControlTestAndroidLoginLogout() {
		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		WelcomeScreen welcome = new WelcomeScreen();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		AccountTab accountTab = new AccountTab();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		String storedCarrier;
		String storedPassword;
	
		
		try {
			//CARRIER_102698
			androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
			androidLogs.setupTestYellow("CARRIER_102698");
			environmentPicker.SetEnvironment();
			env = environmentPicker.getEnviroment();
			getAccount.setEnv(env);
			getAccount.CardPassExpected("CARRIER_102698");	
			carrierType = "CARRIER_102698";
			androidLogs.setupTestYellow("LOCATING " + carrierType+ " ON: " + env);
			storedCarrier = getAccount.getAccountNum();
			storedPassword = getAccount.getPasswordOrPin();
				
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedCarrier, storedPassword);
			Biometrics.BiometricsAndroid();
			accountTab.accountTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(info, "Logged out");
			androidLogs.CapturedLogs(info, "Account tab Functional Test completed");
		
			//CARRIER_100045
			androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
			androidLogs.setupTestYellow("CARRIER_100045");
			environmentPicker.SetEnvironment();
			env = environmentPicker.getEnviroment();
			getAccount.setEnv(env);
			getAccount.CardPassExpected("CARRIER_100045");	
			carrierType = "CARRIER_100045";
			androidLogs.setupTestYellow("LOCATING " + carrierType+ " ON: " + env);
			storedCarrier = getAccount.getAccountNum();
			storedPassword = getAccount.getPasswordOrPin();
				
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedCarrier, storedPassword);
			Biometrics.BiometricsAndroid();
			accountTab.accountTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(info, "Logged out");
			androidLogs.CapturedLogs(info, "Account tab Functional Test completed");
			
			//CARRIER_100644
			androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
			androidLogs.setupTestYellow("CARRIER_100644");
			environmentPicker.SetEnvironment();
			env = environmentPicker.getEnviroment();
			getAccount.setEnv(env);
			getAccount.CardPassExpected("CARRIER_100644");	
			carrierType = "CARRIER_100644";
			androidLogs.setupTestYellow("LOCATING " + carrierType+ " ON: " + env);
			storedCarrier = getAccount.getAccountNum();
			storedPassword = getAccount.getPasswordOrPin();
				
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedCarrier, storedPassword);
			Biometrics.BiometricsAndroid();
			accountTab.accountTab();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(info, "Logged out");
			androidLogs.CapturedLogs(info, "Account tab Functional Test completed");
			
			
			
//			androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
//			androidLogs.setupTestYellow("CARRIER_102698db");
//			environmentPicker.SetEnvironment();
//			env = environmentPicker.getEnviroment();
//			getAccount.setEnv(env);
//			getAccount.CardPassExpected("CARRIER_102698db");	
//			carrierType = "CARRIER_102698db";
//			androidLogs.setupTestYellow("LOCATING " + carrierType+ " ON: " + env);
//			storedCarrier = getAccount.getAccountNum();
//			storedPassword = getAccount.getPasswordOrPin();
//				
//			System.out.println(phone.autoPhonePickerCarrier(appName));
//			environmentPicker.EnvironmentPickerButton();
//			welcome.welomeScreen();
//			passLogin.PassExpected(env, storedCarrier, "NGFC123");
//			Biometrics.BiometricsAndroid();
//			accountTab.accountTab();
//			logoutApp.logOutCarrierControll();
//			androidLogs.CapturedLogs(info, "Logged out");
//			androidLogs.CapturedLogs(info, "Account tab Functional Test completed");
		
				
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