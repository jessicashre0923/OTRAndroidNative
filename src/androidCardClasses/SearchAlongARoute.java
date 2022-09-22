package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class SearchAlongARoute {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	RegisterCheckAndroid registerCheck = new RegisterCheckAndroid();
	SecureFuel secureFuel = new SecureFuel();
	ProgressSpinner loading = new ProgressSpinner();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	private String env;
	private String storedAccount;
	private String storedPinOrPassword;
	private String accountType;

//TODO THIS IS A WORK IN PROGRESS FindFuel.mapTesting PAGE IS NOT YET STARTED		

	public void SearchAlongARoute(String environment, String accountNumber, String passwordOrPin, String accountType)
			throws Exception {
		androidLogs.setupTestYellow("FIND FUEL SEARCH ALONG A ROUTE");
		this.env = environment;
		this.storedAccount = accountNumber;
		this.storedPinOrPassword = passwordOrPin;
		this.accountType = accountType;
		searchAlongARoute();
	}

	public void searchAlongARoute() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		System.out.println("Find Fuel Route search");

//ADD STUFF DONT NEEED HELP SCREENS SHOULD BE DONE ALREADY 
		Thread.sleep(3000);
		WebElement SearchAlongARouteButton = elements.SearchAlongARouteButton();
		Thread.sleep(3000);
		if (SearchAlongARouteButton != null && SearchAlongARouteButton.isEnabled()) {
			SearchAlongARouteButton.click();
			AndroidLogs.CapturedLogs(pass, "Search along a Route Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Search along a Route  is not found");
		}

		Thread.sleep(3000);
		WebElement DestinationTextBox = elements.DestinationTextBox();
		Thread.sleep(3000);
		if (DestinationTextBox != null && DestinationTextBox.isEnabled()) {
			DestinationTextBox.click();
			AndroidLogs.CapturedLogs(pass, "Eneter destination textbox found");

			DestinationTextBox.sendKeys(androidText.DESTINATION);
			androidLogs.CapturedLogs(pass, "Destination entered");

			Thread.sleep(3000);
			WebElement DestinationPicker = elements.DestinationPicker();
			Thread.sleep(3000);

			if (DestinationPicker != null && DestinationPicker.isEnabled()) {
				DestinationPicker.click();
				AndroidLogs.CapturedLogs(pass, "Destination picker selected");

				Thread.sleep(3000);
				WebElement DestinationSearchButton = elements.DestinationSearchButton();
				Thread.sleep(3000);

				if (DestinationSearchButton != null && DestinationSearchButton.isEnabled()) {
					DestinationSearchButton.click();
					AndroidLogs.CapturedLogs(pass, "Destination search buttonselected");

//TODO figgure out the load time. 					
					loading.SearchAlongARouteLoadingSpinner();

				} else {
					AndroidLogs.CapturedLogs(pass, "Destination Search Button not found");
				}

			} else {
				AndroidLogs.CapturedLogs(pass, "Destination picker not found");
			}

		} else {
			AndroidLogs.CapturedLogs(info, "Search along a Route  is not found");
		}

		Thread.sleep(3000);
		WebElement SearchAlongARouteBackButton = elements.SearchAlongARouteBackButton();
		Thread.sleep(3000);
		if (SearchAlongARouteBackButton != null && SearchAlongARouteBackButton.isEnabled()) {
			SearchAlongARouteBackButton.click();
			AndroidLogs.CapturedLogs(pass, "Search Along a Route Back Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Search Along a Route Back Button is not found");
		}

	}
}
