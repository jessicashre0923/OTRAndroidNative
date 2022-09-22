package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class LogOutCardControl {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

	
	public LogOutCardControl logoutCardControl() throws Exception {

		androidLogs.setupTest("LOGOUT");
		
		
		Thread.sleep(3000);	
		WebElement openProfileButtonFromHome = elements.ProfileButtonFromHome();
		Thread.sleep(3000);
		if (openProfileButtonFromHome != null && openProfileButtonFromHome.isEnabled()) {
			openProfileButtonFromHome.click();
			androidLogs.CapturedLogs(pass, "Open Profile Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Open Profile Button is not found");
		}
				
		
		Thread.sleep(3000);
		WebElement LogoutHelpScreenContinue = elements.LogoutHelpScreenContinue();
		Thread.sleep(3000);
		if (LogoutHelpScreenContinue != null && LogoutHelpScreenContinue.isEnabled()) {
			LogoutHelpScreenContinue.click();
			androidLogs.CapturedLogs(pass, "Help Screen Continue Button is found and pressed");
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Continue Button is not found");
		}

		Thread.sleep(3000);
		Thread.sleep(3000);
		scroll.ScrollDown();
		scroll.ScrollDown();
		
		
		// find logout cancel modal button click it open the logout modal again and
		Thread.sleep(3000);
		WebElement CardLogoutButton = elements.CardLogoutButton();
		Thread.sleep(3000);
		if (CardLogoutButton  != null && CardLogoutButton.isEnabled()) {
				CardLogoutButton.click();
			androidLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Log out button on profile page was not found");

		}
		
		

// find logout modal no button and click it as logout is in account section
		Thread.sleep(3000);
		WebElement CardLogoutModalCancelButton = elements.CardLogoutModalCancelButton();
		Thread.sleep(3000);
		if (CardLogoutModalCancelButton != null && CardLogoutModalCancelButton.isEnabled()) {
			CardLogoutModalCancelButton.click();
			androidLogs.CapturedLogs(pass, "Logout Modal Cancel Button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Logout Modal Cancel Button is not found");
		}
		
		// find logout cancel modal button click it open the logout modal again and
		Thread.sleep(3000);
		WebElement CardLogoutButtonTwo = elements.CardLogoutButton();
		Thread.sleep(3000);
		if (CardLogoutButtonTwo  != null && CardLogoutButtonTwo.isEnabled()) {
			CardLogoutButtonTwo.click();
			androidLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Log out button on profile page was not found");
		}
		
		
		// find logout modal button and click logout from modal
		Thread.sleep(3000);
		WebElement CardLogoutModalButton = elements.CardLogoutModalButton();
		Thread.sleep(3000);
		if (CardLogoutModalButton != null && CardLogoutModalButton.isEnabled()) {
			CardLogoutModalButton.click();
			androidLogs.CapturedLogs(pass, "Logout Modal Log Out Button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Logout Modal Log Out Button was not found");

		}

		return this;

	}

}
