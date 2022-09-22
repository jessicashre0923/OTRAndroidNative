package androidCarrierClasses;



import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;



public class LogoutCarrierControl{
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions Scroll = new ScrollOptions();
	AppStringsAndroid androidText = new AppStringsAndroid();
	static AppiumDriver<WebElement> driver;
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	public LogoutCarrierControl logOutCarrierControll () throws Exception {
		androidLogs.setupTest("LOGOUT");
		
		Thread.sleep(2000);
		WebElement AccountTab = elements.AccountTab();
		if (AccountTab.isDisplayed()) {
			AccountTab.click();
			androidLogs.CapturedLogs(pass, "Account tab was opened.");
		} else {
			androidLogs.CapturedLogs(fail, "Accounts tab not found");
		}

		Scroll.Refresh();
		Scroll.ScrollDown();
		
		Thread.sleep(2000);
		WebElement LogOutButton = elements.LogOutButton();
		if (LogOutButton!=null && LogOutButton.isEnabled()) {
			LogOutButton.click();
			androidLogs.CapturedLogs(pass, "Log Out button clicked");
		}else {
			androidLogs.CapturedLogs(fail, "Log out button not found");
		}
		
		Thread.sleep(2000);
		WebElement LogOutCancelModal = elements.LogOutCancelModal();
		if (LogOutCancelModal.isEnabled()) {
			LogOutCancelModal.click();
			androidLogs.CapturedLogs(pass, "Cancel button clicked");

		} else {
			androidLogs.CapturedLogs(fail, "Cancel button not found");
		}
		
		Thread.sleep(2000);
		WebElement LogOutButton2 = elements.LogOutButton();
		if (LogOutButton2.isEnabled()) {
			LogOutButton2.click();
			androidLogs.CapturedLogs(pass, "Log Out button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Log Out button not found");
		}
		
		Thread.sleep(2000);
		WebElement LogOutButtonModal = elements.LogOutButtonModal();
		if (LogOutButtonModal.isEnabled()) {
			LogOutButtonModal.click();
			androidLogs.CapturedLogs(pass, "Log Out button modal clicked");
			Thread.sleep(2000);
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
		}else {
			androidLogs.CapturedLogs(fail, "Log Out modal button not found");
		}
		
	
		
		return this;
	}
	
}

