package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class SecureFuel {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	CardProgressSpinner loadingSpinner = new CardProgressSpinner();
	
	public SecureFuel secureFuel(String unitID) throws Exception {
	
		androidLogs.setupTest("Secure Fuel Test");
		Thread.sleep(3000);
		WebElement FuelCheckInButton = elements.FuelCheckInButton();
		Thread.sleep(3000);
		if (FuelCheckInButton != null && FuelCheckInButton.isEnabled()) {
			FuelCheckInButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Fuel check in button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Fuel check in button not found");
		}
		
		Thread.sleep(2000);
		WebElement UnitNumberTextBox = elements.UnitNumberTextBox();
		Thread.sleep(3000);
		if (UnitNumberTextBox != null && UnitNumberTextBox.isEnabled()) {
			//UnitNumberTextBox.click();
			UnitNumberTextBox.sendKeys(unitID);
			androidLogs.CapturedLogs(androidText.PASS, "Unit number textbox filled");
		} else {
			androidLogs.CapturedLogs(androidText.INFO, "Unit number text box not found or is not supposed to be on this account");
		}
		
		Thread.sleep(3000);
		WebElement CheckInButton = elements.CheckInButton();
		Thread.sleep(3000);
		if (CheckInButton != null && CheckInButton.isEnabled()) {
			CheckInButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Check in button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Check in button not found");
		}
		
		
		
		//TODO add try catch EMULATOR	
		
				Thread.sleep(2000);
				WebElement AllowLocationModal = elements.AllowLocationModal();
				Thread.sleep(3000);
				if (AllowLocationModal != null && AllowLocationModal.isEnabled()) {
					AllowLocationModal.click();
					androidLogs.CapturedLogs(androidText.PASS, "Allow location emulator button clicked");
					
					Thread.sleep(3000);
					WebElement UnableToGetLocationLaterModal = elements.UnableToGetLocationLaterModal();
					Thread.sleep(3000);
					if (UnableToGetLocationLaterModal != null && UnableToGetLocationLaterModal.isEnabled()) {
						UnableToGetLocationLaterModal.click();
						androidLogs.CapturedLogs(androidText.PASS, "Unable to get location later button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.INFO, "Unable to get location later button not found or clicked previously");
					}
					
				} else {
					androidLogs.CapturedLogs(androidText.INFO, "Allow location emulator button not found or clicked previously");
				}
		
		
		
		
		Thread.sleep(2000);
		WebElement AllowLocationModalRealDevice = elements.AllowLocationModalRealDevice();
		Thread.sleep(3000);
		if (AllowLocationModalRealDevice != null && AllowLocationModalRealDevice.isEnabled()) {
			AllowLocationModalRealDevice.click();
			androidLogs.CapturedLogs(androidText.PASS, "Allow location real device button clicked");
			
		} else {
			androidLogs.CapturedLogs(androidText.INFO, "Allow location button on real device not found or clicked previously");
			
		}
		
//TODO loading spinners not working yet	
		//loadingSpinner.checkInSpinnerSecureFuelCardControl();
		
		Thread.sleep(2000);
		WebElement DismissFuelCheckinButton = elements.DismissFuelCheckinButton();
		Thread.sleep(3000);
		if (DismissFuelCheckinButton != null && DismissFuelCheckinButton.isDisplayed()) {
			DismissFuelCheckinButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Dismiss button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.INFO, "Dismiss button not found could be that this is an emulator");
		}
		
		
		return this;
	}
}
