package androidSharedClasses;


import org.openqa.selenium.WebElement;

import androidCardClasses.ProgressSpinner;
import androidCardClasses.RepoCardAndroid;

import io.appium.java_client.AppiumDriver;

public class BiometricsAndroid {

	static AppiumDriver<WebElement> driver;
	
	public BiometricsAndroid BiometricsAndroid() throws Exception {
	
		AndroidLogs androidLogs = new AndroidLogs();
		RepoCardAndroid elements = new RepoCardAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid();
		ProgressSpinner loading = new ProgressSpinner();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		
		
			androidLogs.setupTest("BIOMETRICS");
			
		
			loading.BiometricsSpinner();
			
			//Thread.sleep(3000);
			WebElement BiometricsPage = elements.BiometricsPage();
			Thread.sleep(3000);
			if (BiometricsPage != null && BiometricsPage.isDisplayed()) {
				androidLogs.CapturedLogs(pass, "Biometrics page found");
		
			//Thread.sleep(3000);
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
			
return this;
		
}
}
