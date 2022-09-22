package androidCarrierClasses;


import org.openqa.selenium.WebElement;

import androidCardClasses.ProgressSpinner;
import androidCardClasses.RepoCardAndroid;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class BiometricsCarrierControlAndroid {

	static AppiumDriver<WebElement> driver;
	
	public BiometricsCarrierControlAndroid BiometricsCarrierControlAndroid() throws Exception {
	
		AndroidLogs androidLogs = new AndroidLogs();
	//	RepoCardAndroid elements = new RepoCardAndroid();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid();
		ProgressSpinner loading = new ProgressSpinner();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		
		try {
			androidLogs.setupTest("BIOMETRICS");
			
			//Thread.sleep(3000);
			//Still working on an auto biometrics checker for Carrier Control
			//loading.BiometricsSpinnerCarrierControl();
			
			Thread.sleep(5000);
			WebElement BiometricsPageCarrierControl = elements.BiometricsPageCarrierControl();
			Thread.sleep(5000);
			if (BiometricsPageCarrierControl != null && BiometricsPageCarrierControl.isDisplayed()) {
				androidLogs.CapturedLogs(pass, "Biometrics page found");
		
			Thread.sleep(3000);
			WebElement BiometricsDenyButton = elements.BiometricsDenyButton();
			Thread.sleep(3000);
			if (BiometricsDenyButton != null && BiometricsDenyButton.isDisplayed()) {
				BiometricsDenyButton.click();
				androidLogs.CapturedLogs(pass, "Biometrics Deny Button selected");

				
			} else {
				androidLogs.CapturedLogs(info, "Biometrics Deny Button not found may be selected on prior run");
			}
			
			
			Thread.sleep(3000);
			WebElement BiometricsCancelButton = elements.BiometricsCancelButton();
			Thread.sleep(3000);
		if (BiometricsCancelButton != null && BiometricsCancelButton.isDisplayed()) {
			BiometricsCancelButton.click();
			androidLogs.CapturedLogs(pass, "Biometrics Cancel Button selected");
		} else {
			androidLogs.CapturedLogs(info, "Biometrics Cancel Button not found may be selected on prior run");
		}
		
	} else {
	androidLogs.CapturedLogs(info, "Biometrics page not found");
	}
			
	} catch (Exception e) {
		androidLogs.CapturedLogs(androidText.INFO, "Biometrics Page not found");
	}
			
return this;
		
}
		
		
}
