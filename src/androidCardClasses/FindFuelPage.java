package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class FindFuelPage {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	RegisterCheckAndroid registerCheck = new RegisterCheckAndroid();
	SecureFuel secureFuel = new SecureFuel();
	SearchAlongARoute routeSearch = new SearchAlongARoute();
	SearchNearby searchNearby = new SearchNearby();

	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	private String env;
	private String storedAccount;
	private String storedPinOrPassword;
	private String accountType;

	
	
//TODO THIS IS A WORK IN PROGRESS FindFuel.mapTesting PAGE IS NOT YET STARTED		

	public void FindFuelPage(String environment, String accountNumber, String passwordOrPin, String accountType)
			throws Exception {
		androidLogs.setupTest("FIND FUEL TESTING");
		this.env = environment;
		this.storedAccount = accountNumber;
		this.storedPinOrPassword = passwordOrPin;
		this.accountType = accountType;
		mapTesting();
	}

	public void mapTesting() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		System.out.println("Find Fuel PAGE");

		Thread.sleep(3000);
		WebElement HelpScreenContinueHomePage = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinueHomePage != null && HelpScreenContinueHomePage.isEnabled()) {
			HelpScreenContinueHomePage.click();
			androidLogs.CapturedLogs(pass, "Help Screen Home Page continue Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Home Page continue Button is not found");
		}

		Thread.sleep(3000);
		WebElement FindFuelTab = elements.FindFuelTab();
		Thread.sleep(3000);
		if (FindFuelTab != null && FindFuelTab.isEnabled()) {
			FindFuelTab.click();
			AndroidLogs.CapturedLogs(pass, "Find Fuel tab is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Find Fuel tab is not found");
		}

		Thread.sleep(3000);
		WebElement AllowModal = elements.AllowModal();
		Thread.sleep(3000);
		if (AllowModal != null && AllowModal.isEnabled()) {
			AllowModal.click();
			AndroidLogs.CapturedLogs(pass, "Allow Location Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Allow Location Button button is not found");
		}

		Thread.sleep(3000);
		WebElement HelpScreenContinueFindFuelPage = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinueFindFuelPage != null && HelpScreenContinueFindFuelPage.isEnabled()) {
			HelpScreenContinueFindFuelPage.click();
			AndroidLogs.CapturedLogs(pass, "Help Screen Find Fuel continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Help Screen Find Fuel continue button is not found");
		}

		
		// Search Nearby
		searchNearby.SearchNearby(env, storedAccount, storedPinOrPassword, accountType);
		// Route Search
		routeSearch.SearchAlongARoute(env, storedAccount, storedPinOrPassword, accountType);

		
		
		WebElement HomeTabButton = elements.HomeTabButton();
		Thread.sleep(3000);
		if (HomeTabButton != null && HomeTabButton.isEnabled()) {
			HomeTabButton.click();
			AndroidLogs.CapturedLogs(pass, "Home Tab button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Home Tab button is not found");
		}

	}
}
