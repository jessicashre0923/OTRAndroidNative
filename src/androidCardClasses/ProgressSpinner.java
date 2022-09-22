package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidCarrierClasses.RepoCarrierAndroid;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

public class ProgressSpinner {

	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	RepoCardAndroid elementsCard = new RepoCardAndroid();
	RepoCarrierAndroid elementsCarrier = new RepoCarrierAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

	public ProgressSpinner LoginSpinnerCardControl() throws Exception {

		try {
			// check progress spinner
			Thread.sleep(2000);
			WebElement CardControlloginSpinner = elementsCard.CardLoginButtonSpinner();
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
			while (CardControlloginSpinner != null && CardControlloginSpinner.isDisplayed()) {
				Thread.sleep(3000);
				androidLogs.CapturedLogs(androidText.INFO, "Loading spinner Thread.sleep(3000) initiated");
			}
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");

		} catch (Exception e) {
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner completed");
		}
		return this;

	}

//public ProgressSpinner SearchNearByLoadingSpinner() throws Exception {
//	// check progress spinner
//	Thread.sleep(5000);
//	WebElement SearchNearByLoadingSpinner = elements.SearchNearByLoadingSpinner();
//	Thread.sleep(5000);
//	androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
//	
//	while (SearchNearByLoadingSpinner != null && SearchNearByLoadingSpinner.isDisplayed()) {
//		Thread.sleep(3000);
//		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner Thread.sleep(3000) initiated");
//	}
//	androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
//	return this;
//}

	public ProgressSpinner SearchNearByLoadingSpinner() throws Exception {
		try {
		// check progress spinner
		Thread.sleep(5000);
		WebElement SearchNearByLoadingSpinner = elementsCard.SearchNearByLoadingSpinner();
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");

		do {
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner Thread.sleep(3000) initiated");
		} while (SearchNearByLoadingSpinner != null && SearchNearByLoadingSpinner.isDisplayed());

		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		
		} catch (Exception e) {
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner completed");
		}
		
		return this;
	}

	public ProgressSpinner SearchAlongARouteLoadingSpinner() throws Exception {
		try {
		// check progress spinner
		Thread.sleep(2000);
		WebElement SearchAlongARouteLoadingSpinner = elementsCard.SearchAlongARouteLoadingSpinner();
		Thread.sleep(3000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (SearchAlongARouteLoadingSpinner != null && SearchAlongARouteLoadingSpinner.isDisplayed()) {
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading spinner Thread.sleep(3000) initiated");
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		
	} catch (Exception e) {
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner completed");
	}
	
		return this;
	}
	
	
	
//	public ProgressSpinner MapDirectionsButtonSpinner() throws Exception {
//		try {
//		// check progress spinner
//		Thread.sleep(2000);
//		WebElement MapDirectionsButton = elements.MapDirectionsButton();
//		Thread.sleep(3000);
//		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
//		while (MapDirectionsButton != null && MapDirectionsButton.isDisplayed()) {
//			Thread.sleep(3000);
//			androidLogs.CapturedLogs(androidText.INFO, "Loading mapview directions Button Thread.sleep(3000) initiated");
//		}
//		androidLogs.CapturedLogs(androidText.INFO, "Loading mapview directions Button completed");
//		
//	} catch (Exception e) {
//		androidLogs.CapturedLogs(androidText.INFO, "Wait for map completed");
//	}
//	
//		return this;
//	}
	
	
	public ProgressSpinner MapDirectionsLikeButton() throws Exception {
		try {
		// check progress spinner
		Thread.sleep(2000);
		WebElement MapDirectionsLikeButton = elementsCard.MapDirectionsLikeButton();
		Thread.sleep(3000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (MapDirectionsLikeButton != null && MapDirectionsLikeButton.isDisplayed()) {
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading mapview directions Button Thread.sleep(3000) initiated");
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading mapview directions Button completed");
		
	} catch (Exception e) {
		androidLogs.CapturedLogs(androidText.INFO, "Wait for map completed");
	}
	
		return this;
	}
	
//CARRIER CONTROL/////		
	
	public ProgressSpinner BiometricsSpinner() throws Exception {
		try {
		// check progress spinner
		Thread.sleep(2000);
		WebElement BiometricsSpinner = elementsCarrier.BiometricsPageCarrierControl();
		Thread.sleep(3000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics spinner checker started");
		while (BiometricsSpinner != null && BiometricsSpinner.isDisplayed()) {
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics spinner Thread.sleep(3000) initiated");
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics on page checker completed");
		
	} catch (Exception e) {
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics completed");
	}
	
		return this;
	}
	
	
//	public ProgressSpinner BiometricsSpinnerCarrierControl() throws Exception {
//		try {
//		// check progress spinner
//		Thread.sleep(3000);
//		WebElement BiometricsPageCarrierControl = elementsCarrier.BiometricsPageCarrierControl();
//		Thread.sleep(3000);
//		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics spinner checker started");
//		while (BiometricsPageCarrierControl != null && BiometricsPageCarrierControl.isDisplayed()) {
//			Thread.sleep(3000);
//			androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics spinner Thread.sleep(3000) initiated");
//		}
//		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics on page checker completed");
//		
//	} catch (Exception e) {
//		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics completed");
//	}
//	
//		return this;
//	}
	
	public ProgressSpinner BiometricsSpinnerCarrierControl() throws Exception {
		try {
		// check progress spinner
		Thread.sleep(2000);
		WebElement BiometricsPageCarrierControl = elementsCarrier.BiometricsPageCarrierControl();
		Thread.sleep(3000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics checker started");
		while (BiometricsPageCarrierControl != null && BiometricsPageCarrierControl.isDisplayed()) {
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics Thread.sleep(3000) initiated");
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics on page checker completed");
		
	} catch (Exception e) {
		androidLogs.CapturedLogs(androidText.INFO, "Loading Biometrics completed");
	}
	
		return this;
	}
	

	// TODO use this style if unable to use a text to find xpath.
//		Thread.sleep(2000);
//		while (elements.progressSpinnerSubmitPaymentInvoice()!= null && elements.progressSpinnerSubmitPaymentInvoice().isDisplayed()) {
//			androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment on invoice seen waiting 3000");
//			Thread.sleep(3000);
//		}
//		return this;
//	}

}
