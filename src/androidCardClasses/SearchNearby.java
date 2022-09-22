package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class SearchNearby {

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

	public void SearchNearby(String environment, String accountNumber, String passwordOrPin, String accountType)
			throws Exception {
		androidLogs.setupTestYellow("FIND FUEL NEARBY");

		this.env = environment;
		this.storedAccount = accountNumber;
		this.storedPinOrPassword = passwordOrPin;
		this.accountType = accountType;
		searchNearby();
	}

	public void searchNearby() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		System.out.println("Find Fuel Search Nearby");

//ADD STUFF DONT NEEED HELP SCREENS SHOULD BE DONE ALREADY 
		WebElement SearchNearbyButton = elements.SearchNearbyButton();
		Thread.sleep(3000);
		if (SearchNearbyButton != null && SearchNearbyButton.isEnabled()) {
			SearchNearbyButton.click();
			AndroidLogs.CapturedLogs(pass, "Search Nearby Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Search Nearby Button is not found");
		}

//TODO wait for loading spinner??
		loading.SearchNearByLoadingSpinner();

		Thread.sleep(3000);
		WebElement FiltersButton = elements.FiltersButton();
		Thread.sleep(3000);
		if (FiltersButton != null && FiltersButton.isEnabled()) {
			FiltersButton.click();
			AndroidLogs.CapturedLogs(pass, "Filters button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Filters button is not found");
		}

		Thread.sleep(3000);
		WebElement FiltersCloseButton = elements.FiltersCloseButton();
		Thread.sleep(3000);
		if (FiltersCloseButton != null && FiltersCloseButton.isEnabled()) {
			FiltersCloseButton.click();
			AndroidLogs.CapturedLogs(pass, "Filters Close button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Filters Close button is not found");
		}

		Thread.sleep(3000);
		WebElement OpenUsingImageBrand = elements.OpenUsingImageBrand();
		Thread.sleep(3000);
		if (OpenUsingImageBrand != null && OpenUsingImageBrand.isEnabled()) {
			OpenUsingImageBrand.click();
			AndroidLogs.CapturedLogs(pass, "Stations Image is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Stations Image is not found");
		}

		Thread.sleep(3000);
		WebElement StationBackButton = elements.StationBackButton();
		Thread.sleep(3000);
		if (StationBackButton != null && StationBackButton.isEnabled()) {
			StationBackButton.click();
			AndroidLogs.CapturedLogs(pass, "Stations back button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Stations back button is not found");
		}

		Thread.sleep(3000);
		WebElement FindFuelNearbyBackButton = elements.FindFuelNearbyBackButton();
		Thread.sleep(3000);
		if (FindFuelNearbyBackButton != null && FindFuelNearbyBackButton.isEnabled()) {
			FindFuelNearbyBackButton.click();
			AndroidLogs.CapturedLogs(pass, "Search Nearby Back Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Search Nearby Back Button is not found");
		}

	}
}
