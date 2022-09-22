package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;

//import io.appium.java_client.AppiumDriver;

public class MultiCardLoginCheck {
	public MultiCardLoginCheck() {
	}

	public void MultiCardLoginCheck() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		RepoCardAndroid elements = new RepoCardAndroid();
		ScrollOptions scroll = new ScrollOptions();
		
		AndroidLogs.setupTest("MULTI CARD SCREEN CHECK");
		AndroidLogs.CapturedLogs(androidText.INFO, "Multi card Login page check Testing started.");

		Thread.sleep(3000);
		

		WebElement CheckForMuliCardLogin = elements.CheckForMuliCardLogin();
		if (CheckForMuliCardLogin != null && CheckForMuliCardLogin.isDisplayed()) {
			
			AndroidLogs.CapturedLogs(androidText.PASS, "Multi Card Login page found.");
		

		
		scroll.ScrollDown();
		Thread.sleep(3000);
		
		WebElement SignInWithDifferentcardButton = elements.SignInWithDifferentcardButton();
		if (SignInWithDifferentcardButton != null && SignInWithDifferentcardButton.isDisplayed()) {
			SignInWithDifferentcardButton.click();
			AndroidLogs.CapturedLogs(androidText.PASS, "Sign in with different card Button found.");
		} else {
			AndroidLogs.CapturedLogs(androidText.INFO, "Sign in with different card Button Not found");
		}
		
		} else {
			AndroidLogs.CapturedLogs(androidText.INFO, "Multi Card Login page Not found as expected with single card login");
		}

	}

}
