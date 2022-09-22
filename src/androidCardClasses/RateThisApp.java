package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class RateThisApp {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
	
	public void rateThisApp(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
				
			oneboarding();
		}
		
	public void oneboarding() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		
//Help screen for home page
		androidLogs.setupTest("HOME PAGE HELP SCREEN");
		Thread.sleep(3000);
		WebElement HomehelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HomehelpScreenContinue != null && HomehelpScreenContinue.isEnabled()) {
			HomehelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Home Page help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Home Page help Screen continue Button is not found");
		}
		
//Help screen for Transaction tab		
		androidLogs.setupTest("TRANSACTION TAB HELP SCREEN");

		Thread.sleep(3000);	
		WebElement OpenTransactionsTab = elements.OpenTransactionsTab();
		Thread.sleep(3000);
		if (OpenTransactionsTab != null && OpenTransactionsTab.isEnabled()) {
			OpenTransactionsTab.click();
			androidLogs.CapturedLogs(pass, "Transactions tab is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Transactions tab is not found");
		}
		
		
		Thread.sleep(3000);
		WebElement TransactionHelpScreenContinue = elements.TransactionHelpScreenContinue();
		Thread.sleep(3000);
		if (TransactionHelpScreenContinue != null && TransactionHelpScreenContinue.isEnabled()) {
			TransactionHelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Transaction help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Transaction help Screen continue Button is not found");
		}
		androidLogs.setupTestYellow("If this test does not fail then no rate this app modal was seen");
		
	}
}

