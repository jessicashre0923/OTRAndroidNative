package functionalTestsCarrierControlAndroid;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCarrierClasses.CardsOverviewCompany;
import androidCarrierClasses.LoginCompanyCC;
import androidCarrierClasses.LoginPassVerificationCarrierControl;
import androidCarrierClasses.LoginSubUserCarrierControl;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.MoneyCodesTab;
import androidCarrierClasses.ProgressSpinner;
import androidCarrierClasses.WelcomeScreen;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.AutoFindLogin;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoCompanyCardOverviewRun{

	static AppiumDriver<WebElement> driver;
	String storedAccount;
	String storedPinOrPassword;
	String env;
	String appName = "Carrier Control";
	
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
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		ProgressSpinner loading = new ProgressSpinner();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		AutoFindLogin autoFindLogin = new AutoFindLogin();
		CardsOverviewCompany cardsOverviewCompany = new CardsOverviewCompany();
		
		try {
						
			androidLogs.setupTestYellow("CARRIER_103526");
			autoFindLogin.CardPassExpected("CARRIER_103526");
			storedAccount = autoFindLogin.getAccountNum();
			storedPinOrPassword = autoFindLogin.getPasswordOrPin();
			env = autoFindLogin.getEnv();
			
			
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.EnvironmentPickerButton();
			welcome.welomeScreen();
			passLogin.PassExpected(env, storedAccount, storedPinOrPassword);
			Biometrics.BiometricsAndroid();
			cardsOverviewCompany.CardsOverview();
			//log out
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			
			androidLogs.CapturedLogs(androidText.INFO, "Company card overview Functional Test completed");

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