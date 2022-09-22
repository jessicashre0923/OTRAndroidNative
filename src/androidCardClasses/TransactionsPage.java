package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class TransactionsPage {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	RegisterCheckAndroid registerCheck = new RegisterCheckAndroid();
	SecureFuel secureFuel = new SecureFuel();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	private String env;
	private String accountNumber;
	private String passwordOrPin;
	private String accntType;
	private String recuringCashAmmountCollected;
	private String oneTimeCashCollected;
	private String unitID;
	private String smartFundsBalanceCollected;


//TODO THIS IS A WORK IN PROGRESS TRANSACTIONS.TRANSACTIONS PAGE IS NOT YET STARTED		
	
	
	public void TransactionsPage(String environment, String accountNumber, String passwordOrPin, String accountType) throws Exception {
			this.env = environment;
			this.accountNumber = accountNumber;
			this.passwordOrPin = passwordOrPin;
			this.accntType = accountType;
			transactions();
		}
		
	public void transactions() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

System.out.println("**Please Wait or watch the html documents for updates**");
System.out.println("The Transactions screen test takes a while and seems like it is doing nothing as it checking to see if items exist or not");
//Help screen for Transactions page				
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		
	}
}

