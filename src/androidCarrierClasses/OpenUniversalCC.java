package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenUniversalCC {

	static AppiumDriver<WebElement> driver;

	public static void openCarrierControl() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginUniversalCC loginUniversal = new LoginUniversalCC();
		AccountTab accountTab = new AccountTab();
		CardsTabUniversal cardsTabUniversal = new CardsTabUniversal();
		RejectsTab transactionTab = new RejectsTab();
		// BillingTab paymentTab = new BillingTab();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreen welcome = new WelcomeScreen();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		String appName = "Carrier Control";
		
		androidLogs.CapturedLogs(androidText.INFO, "----testing on 129698 starting----");
		System.out.println(phone.autoPhonePickerCarrier(appName));
		Thread.sleep(3000);
		environmentPicker.EnvironmentPickerButton();	
		
		welcome.welomeScreen();

		// Automation is given good login details and logs in successfully.
		loginUniversal.PassExpected();

		// check for biometrics modal
		Biometrics.BiometricsCarrierControlAndroid();

		// Automation begins tab section testing.
		moneyCodesTab.moneyCodesTab();

		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with cards Overview currently 06/08/2021");		
		//cardsTabUniversal.CardsTabUniversal();

		transactionTab.rejectsTab();
		accountTab.accountTab();

	}
}
