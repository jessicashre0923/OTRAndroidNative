package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class DynamicPIN {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	public DynamicPIN dynamicPIN() throws Exception {
		Thread.sleep(3000);
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		
		Thread.sleep(3000);
		androidLogs.setupTest("Dynamic PIN Test");
		Thread.sleep(3000);
		WebElement DynamicPINButton = elements.DynamicPINButton();
		Thread.sleep(3000);
		if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
			DynamicPINButton.click();
			androidLogs.CapturedLogs(pass, "Dynamic PIN button clicked");
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN button button not found or unavailable in this card type");
		}
		
		Thread.sleep(3000);
		WebElement DynamicPINNumber = elements.DynamicPINNumber();
		Thread.sleep(3000);
		if (DynamicPINNumber != null && DynamicPINNumber.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Dynamic PIN number displayed as: "+ DynamicPINNumber.getText());
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN number not found or unavailable in this card type");
		}
		
		Thread.sleep(3000);
		WebElement DismissDynamicPINbutton = elements.DismissDynamicPINbutton();
		Thread.sleep(3000);
		if (DismissDynamicPINbutton != null && DismissDynamicPINbutton.isDisplayed()) {
			DismissDynamicPINbutton.click();
			androidLogs.CapturedLogs(pass, "Dismiss Dynamic PIN button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss DYnamic PIN button not found");
		}
		
		
		androidLogs.setupTest("Dynamic PIN Second run");
		Thread.sleep(5000);
		WebElement DynamicPINButton1 = elements.DynamicPINButton();
		Thread.sleep(3000);
		if (DynamicPINButton1 != null && DynamicPINButton1.isEnabled()) {
			DynamicPINButton1.click();
			androidLogs.CapturedLogs(pass, "Dynamic PIN button clicked");
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN button button not found or unavailable in this card type");
		}
		
		Thread.sleep(4000);
		WebElement DynamicPINNumber1 = elements.DynamicPINNumber();
		Thread.sleep(3000);
		if (DynamicPINNumber1 != null && DynamicPINNumber.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Dynamic PIN number displayed as: "+ DynamicPINNumber1.getText());
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN number not found or unavailable in this card type");
		}
		
		Thread.sleep(3000);
		WebElement DismissDynamicPINbutton1 = elements.DismissDynamicPINbutton();
		Thread.sleep(3000);
		if (DismissDynamicPINbutton1 != null && DismissDynamicPINbutton1.isDisplayed()) {
			DismissDynamicPINbutton1.click();
			androidLogs.CapturedLogs(pass, "Dismiss Dynamic PIN button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss DYnamic PIN button not found");
		}
		
		
		return this;
	}
}
