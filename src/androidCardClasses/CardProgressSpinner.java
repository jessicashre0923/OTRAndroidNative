package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class CardProgressSpinner {

	AppiumDriver<WebElement> driver;

	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid xpath = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	RepoCardAndroid elements = new RepoCardAndroid();
	
	
//TODO add all profile options.	
	
	
	public CardProgressSpinner checkInSpinnerSecureFuelCardControl() throws Exception {
		Thread.sleep(2000);
		WebElement checkInSpinnerSecureFuelCardControl = elements.checkInSpinnerSecureFuelCardControl();
		if (checkInSpinnerSecureFuelCardControl != null && checkInSpinnerSecureFuelCardControl.isDisplayed()) {
		// check progress spinner
		Thread.sleep(2000);
		androidLogs.CapturedLogs(androidText.INFO, "Secure fuel loading spinner checker started");
		
		while (checkInSpinnerSecureFuelCardControl != null
				&& checkInSpinnerSecureFuelCardControl.isDisplayed()) {
			Thread.sleep(3000);
			checkInSpinnerSecureFuelCardControl = elements.checkInSpinnerSecureFuelCardControl();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Secure fuel loading spinner on page checker completed");
		return this;
	} else {
		androidLogs.CapturedLogs(androidText.INFO, "Secure fuel loading spinner not found");
		return this;
	}
	}
		
	
	
	public CardProgressSpinner loginButtonSpinner() throws Exception {
		Thread.sleep(2000);
		WebElement loginButtonSpinner = elements.loginButtonSpinner();
		if (loginButtonSpinner != null && loginButtonSpinner.isDisplayed()) {
		// check progress spinner
		Thread.sleep(2000);
		androidLogs.CapturedLogs(androidText.INFO, "Login Button loading spinner checker started");
		
		while (loginButtonSpinner != null
				&& loginButtonSpinner.isDisplayed()) {
			Thread.sleep(3000);
			loginButtonSpinner = elements.checkInSpinnerSecureFuelCardControl();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Login Button loading spinner on page checker completed");
		return this;
	

	} else {
		androidLogs.CapturedLogs(androidText.INFO, "Login Button loading spinner not found");
		return this;
	}
}
}


