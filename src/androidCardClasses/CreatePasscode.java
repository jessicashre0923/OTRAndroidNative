package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class CreatePasscode {

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements = new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

		
	public CreatePasscode NewPasscode(String enviroment) throws Exception {
		
		Thread.sleep(3000);
		WebElement CreateAPasscodePage = elements.CreateAPasscodePage();
		Thread.sleep(3000);
		if (CreateAPasscodePage != null && CreateAPasscodePage.isEnabled()) {
			androidLogs.CapturedLogs(info, "Create passcode page found and opened");	
			
		
		WebElement NewPasscodeTextbox = elements.NewPasscodeTextbox();
		 Thread.sleep(2000);
		if (NewPasscodeTextbox != null && NewPasscodeTextbox.isEnabled()) {
			NewPasscodeTextbox.click();
			NewPasscodeTextbox.sendKeys(androidText.MANUAL_PASSCODE);
			androidLogs.CapturedLogs(pass, "New passcocde textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "New passcocde textbox not found");
		}
		
		
		WebElement ConfirmPasscodeTextbox = elements.ConfirmPasscodeTextbox();
		 Thread.sleep(2000);
		if (ConfirmPasscodeTextbox != null && ConfirmPasscodeTextbox.isEnabled()) {
			ConfirmPasscodeTextbox.click();
			ConfirmPasscodeTextbox.sendKeys(androidText.MANUAL_PASSCODE);
			androidLogs.CapturedLogs(pass, "Confirm passcocde textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "Confirm passcocde textbox not found");
		}
		
		WebElement NextButton = elements.NextButton();
		 Thread.sleep(2000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			androidLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			androidLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			androidLogs.CapturedLogs(info, "Create passcode page not seen might already be setup");
		}
		
		
		
		

		return this;
	}
}
