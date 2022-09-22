package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenCompanyCC {

	static AppiumDriver<WebElement> driver;

	public static void openCarrierControl() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginCompanyCC companyLogin = new LoginCompanyCC();
		AccountTab accountTab = new AccountTab();
		RejectsTab transactionTab = new RejectsTab();
		// BillingTab paymentTab = new BillingTab();
		// MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreen welcome = new WelcomeScreen();
		CardsTabCompany companyCard = new CardsTabCompany();
		CardsOverviewCompany cardsOverviewCompany = new CardsOverviewCompany();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		String appName = "Carrier Control";
		
		
		androidLogs.CapturedLogs(androidText.INFO, "----Testing on 103526 starting----");
		System.out.println(phone.autoPhonePickerCarrier(appName));
		Thread.sleep(3000);
		environmentPicker.EnvironmentPickerButton();	
		
		welcome.welomeScreen();

		// Automation is given good login details and logs in successfully.
		companyLogin.PassExpected();

		// check for biometrics modal
		Biometrics.BiometricsCarrierControlAndroid();

		// Automation begins tab section testing.
		
		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with cards Overview currently 06/08/2021");		

		//companyCard.CardsTabCompamy();
		//cardsOverviewCompany.CardsOverview();
		transactionTab.rejectsTab();
		accountTab.accountTab();

	}
}
