package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class InformationIcon {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	
	public InformationIcon InformationIcon() throws Exception {
		
		androidLogs.setupTest("Information Icon and Show Hide Passode test");
		Thread.sleep(5000);
		//Click information icon
		WebElement InformationIcon = elements.InformationIcon();
		if (InformationIcon != null && InformationIcon.isEnabled()) {
			InformationIcon.click();
			androidLogs.CapturedLogs(androidText.PASS, "Information Icon clicked and opened");
			
			//close Find your card number
			Thread.sleep(5000);
			WebElement InformationIconClose = elements.InformationIconClose();
			if (InformationIconClose != null && InformationIconClose.isEnabled()) {
				InformationIconClose.click();
				androidLogs.CapturedLogs(androidText.PASS, "Information Icon close button found and clicked");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Information Icon close button not found");
			}
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Information Icon not found");
		}
		
		Thread.sleep(2000);
		WebElement PinPassTextBox = elements.PinPassTextBox();
		if (PinPassTextBox != null && PinPassTextBox.isEnabled()) {
			PinPassTextBox.click();
			PinPassTextBox.sendKeys("1234");
			androidLogs.CapturedLogs(androidText.PASS, "Test PIN entered");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "PIN passcode textbox not found");
		}
		
		WebElement ShowHidePINPasscodeIcon = elements.ShowHidePINPasscodeIcon();
		if (ShowHidePINPasscodeIcon != null && ShowHidePINPasscodeIcon.isEnabled()) {
			ShowHidePINPasscodeIcon.click();
			androidLogs.CapturedLogs(androidText.PASS, "Show/Hide PIN passcode clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Show/Hide PIN passcode not found");
		}
		Thread.sleep(2000);
		return this;
	}
	
}
