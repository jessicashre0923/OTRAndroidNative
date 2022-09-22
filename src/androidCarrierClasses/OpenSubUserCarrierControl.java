package androidCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenSubUserCarrierControl {

	static AppiumDriver<WebElement> driver;

	@Test
	public static void openCarrierControl() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginSubUserCarrierControl subUserLogin = new LoginSubUserCarrierControl();
		AccountTab accountTab = new AccountTab();
		// CardsTab cardsTab = new CardsTab();
		// TransactionsTab transactionTab = new TransactionsTab();
		BillingTab paymentTab = new BillingTab();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreen welcome = new WelcomeScreen();
		AccountTransferToYourBankAddAccount addBankAccount = new AccountTransferToYourBankAddAccount();
		CardsOverviewSmartfunds cardsOverviewSubuser = new CardsOverviewSmartfunds();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsCarrierControlAndroid Biometrics = new BiometricsCarrierControlAndroid();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		String appName = "Carrier Control";

		androidLogs.CapturedLogs(androidText.INFO, "----Testing on 102698db starting----");	
		System.out.println(phone.autoPhonePickerCarrier(appName));
		Thread.sleep(3000);

		// Make sure all account are ready for testing prior to staring
		// ResetTestAccounts.ResetAllAccounts();
		//Select wanted enviroment and set it
		environmentPicker.EnvironmentPickerButton();	
				
				
		welcome.welomeScreen();

		// Automation is given good login details and logs in successfully.
		subUserLogin.PassExpected();

		// check for biometrics modal
		Biometrics.BiometricsCarrierControlAndroid();

		// Automation begins tab section testing.
		//moneyCodesTab.moneyCodesTab();
		androidLogs.CapturedLogs(androidText.INFO, "This account is unable to test Cards tab search error seen");

		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with cards Overview currently 06/08/2021");		
		// cardsTab.CardsTab();
		// Sub user cards overview tab tests on Smartfunds card
		
		androidLogs.CapturedLogs(androidText.INFO, "ACPT SERVER not working with transactions currently 06/08/2021");		
		//cardsOverviewSubuser.CardsOverviewSubuser();
	
		androidLogs.CapturedLogs(androidText.INFO, "This account is unable to test transactions due to enviromenmt");
		paymentTab.billingTab();
		addBankAccount.accountTransferToYourBankAddAccount(environmentPicker.getEnviroment());
		accountTab.accountTab();

	}
}
