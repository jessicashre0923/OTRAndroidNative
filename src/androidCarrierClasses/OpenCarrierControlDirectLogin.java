package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

	
public class OpenCarrierControlDirectLogin {

	static AppiumDriver<WebElement> driver;

public static void openCarrierControl() throws Exception {
		

		AndroidLogs androidLogs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginPassVerificationCarrierControl passLogin = new LoginPassVerificationCarrierControl();
		AccountTab accountTab = new AccountTab();
		CardsTab cardsTab = new CardsTab();
		RejectsTab transactionTab = new RejectsTab();
		//BillingTab paymentTab = new BillingTab();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreen welcome = new WelcomeScreen();
		CardsOverviewUniversal cardsOverview = new CardsOverviewUniversal();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		String appName = "Carrier Control";
		
		
		androidLogs.setupTest("Account setup test logs for 100045");
		System.out.println(phone.autoPhonePickerCarrier(appName));
		androidLogs.CapturedLogs(androidText.PASS, "Test starting on 100045");
		Thread.sleep(3000);
			
		//Make sure all account are ready for testing prior to staring 
		//ResetTestAccounts.ResetAllAccounts(); 
				
		//Select wanted enviroment and set it
		environmentPicker.EnvironmentPickerButton();	
		
		//closes welcome screen needs some work.... Figgure our swipe.
		welcome.welomeScreen();
		
		//Automation is given good login details and logs in successfully. 
		passLogin.PassExpected(environmentPicker.getEnviroment(), "100045", "985477");
		
		//check for biometrics modal 
		Biometrics.BiometricsCarrierControlAndroid();
		
		//Automation begins tab section testing.
		
//		moneyCodesTab.moneyCodesTab();
		
//		cardsTab.CardsTab();
		//Cards overview tests on universal card

		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with cards Overview currently 06/08/2021");		
//		cardsOverview.CardsOverview();
		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with transactions currently 06/08/2021");		

//will not load consistently enough to test it on ACPT
		transactionTab.rejectsTab();

		//billing not on this account
		androidLogs.setupTest("billing not on this account");
		accountTab.accountTab();
		
	}
}
