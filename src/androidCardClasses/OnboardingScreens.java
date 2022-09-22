package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class OnboardingScreens {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
	
	
	public void OnboardingScreens(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
			oneboarding();
		}
		
	public void oneboarding() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		
//Help screen for home page
		androidLogs.setupTest("HOME PAGE HELP SCREEN");
		Thread.sleep(3000);
		WebElement HomehelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HomehelpScreenContinue != null && HomehelpScreenContinue.isEnabled()) {
			HomehelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Home Page help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Home Page help Screen continue Button is not found");
		}
		
//Help screen for Transaction tab		
		androidLogs.setupTest("TRANSACTION TAB HELP SCREEN");

		Thread.sleep(3000);	
		WebElement OpenTransactionsTab = elements.OpenTransactionsTab();
		Thread.sleep(3000);
		if (OpenTransactionsTab != null && OpenTransactionsTab.isEnabled()) {
			OpenTransactionsTab.click();
			androidLogs.CapturedLogs(pass, "Transactions tab is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Transactions tab is not found");
		}
		
		
		Thread.sleep(3000);
		WebElement TransactionHelpScreenContinue = elements.TransactionHelpScreenContinue();
		Thread.sleep(3000);
		if (TransactionHelpScreenContinue != null && TransactionHelpScreenContinue.isEnabled()) {
			TransactionHelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Transaction help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Transaction help Screen continue Button is not found");
		}
		
		
//Help screen for plan a trip profile 
		androidLogs.setupTest("PLAN A TRIP HELP SCREEN");
		
		Thread.sleep(3000);	
		WebElement OpenFindFuelTab = elements.OpenFindFuelTab();
		Thread.sleep(3000);
		if (OpenFindFuelTab != null && OpenFindFuelTab.isEnabled()) {
			OpenFindFuelTab.click();
			androidLogs.CapturedLogs(pass, "Find Fuel tab is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Find Fuel tab is not found");
		
		}
		
		
		Thread.sleep(3000);	
		WebElement AllowModal = elements.AllowModal();
		Thread.sleep(3000);
		if (AllowModal != null && AllowModal.isEnabled()) {
			AllowModal.click();
			androidLogs.CapturedLogs(pass, "Allow Modal is found and pressed.");
		} else {
			androidLogs.CapturedLogs(info, "Allow Modal is not found");
		
		}

		Thread.sleep(3000);	
			
		
		Thread.sleep(3000);
		WebElement  PlanATripScreenContinue = elements.PlanATripScreenContinue();
		Thread.sleep(3000);
		if (PlanATripScreenContinue != null && PlanATripScreenContinue.isEnabled()) {
			PlanATripScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Plan a trip help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Plan a trip help Screen continue Button is not found");
		}	
		
		
			

//Help screen for account profile tab and logout
		androidLogs.setupTest("ACCOUNT PAGE HELP SCREEN");
				
		Thread.sleep(3000);	
		WebElement HomeTabButton = elements.HomeTabButton();
		Thread.sleep(3000);
		if (HomeTabButton != null && HomeTabButton.isEnabled()) {
			HomeTabButton.click();
			androidLogs.CapturedLogs(pass, "Home tab is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Home tab is not found");
		}

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
			androidLogs.CapturedLogs(pass, "Home help Screen Continue Button is found and pressed");
		} else {
			androidLogs.CapturedLogs(info, "Home help Screen Continue Button is not found");
		}

		
		Thread.sleep(3000);
		scroll.ScrollDown();
		scroll.ScrollDown();
				
		//Help Screens from Account page
		// Find and open helps screens
		androidLogs.setupTest("HELP SCREENS FROM ACCOUNT PAGE");
		Thread.sleep(3000);
		WebElement HelpScreenOpenButton = elements.HelpScreenOpenButton();
		Thread.sleep(3000);
		if (HelpScreenOpenButton  != null && HelpScreenOpenButton.isEnabled()) {
			HelpScreenOpenButton.click();
			androidLogs.CapturedLogs(pass, "Help Screens button from home page is found and pressed");

		
		Thread.sleep(3000);
		androidLogs.CapturedLogs(info,"HELP SCREEN HOME FROM ACCOUNT PAGE");
		WebElement HelpScreensHome = elements.HelpScreensHome();
		Thread.sleep(3000);
		if (HelpScreensHome  != null && HelpScreensHome.isEnabled()) {
			HelpScreensHome.click();
			androidLogs.CapturedLogs(pass, "Help Screens home button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help Screens home button was not found");
		}

		Thread.sleep(3000);
		WebElement HelpScreensHomeCloseButton = elements.HelpScreensCloseButton();
		Thread.sleep(3000);
		if (HelpScreensHomeCloseButton  != null && HelpScreensHomeCloseButton.isEnabled()) {
			HelpScreensHomeCloseButton.click();
			androidLogs.CapturedLogs(pass, "Help Home close button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help Home close button was not found");
		}
		
		
		Thread.sleep(3000);
		androidLogs.CapturedLogs(info,"HELP SCREEN ACCOUNT FROM ACCOUNT PAGE");
		WebElement HelpScreensAccount = elements.HelpScreensAccount();
		Thread.sleep(3000);
		if (HelpScreensAccount  != null && HelpScreensAccount.isEnabled()) {
			HelpScreensAccount.click();
			androidLogs.CapturedLogs(pass, "Account button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Account button was not found");
		}
		
		
		Thread.sleep(3000);
		WebElement HelpScreensCloseButtonAccount = elements.HelpScreensCloseButton();
		Thread.sleep(3000);
		if (HelpScreensCloseButtonAccount  != null && HelpScreensCloseButtonAccount.isEnabled()) {
			HelpScreensCloseButtonAccount.click();
			androidLogs.CapturedLogs(pass, "Help Account close button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help Account close button was not found");
		}

		Thread.sleep(3000);
		androidLogs.CapturedLogs(info,"HELP SCREEN TRANSACTIONS FROM ACCOUNT PAGE");
		WebElement HelpScreensTransactions = elements.HelpScreensTransactions();
		Thread.sleep(3000);
		if (HelpScreensTransactions  != null && HelpScreensTransactions.isEnabled()) {
			HelpScreensTransactions.click();
			androidLogs.CapturedLogs(pass, "Transactions button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Transactions button was not found");
		}
		
		Thread.sleep(3000);
		WebElement HelpScreensCloseButtonTransactions = elements.HelpScreensCloseButton();
		Thread.sleep(3000);
		if (HelpScreensCloseButtonTransactions  != null && HelpScreensCloseButtonTransactions.isEnabled()) {
			HelpScreensCloseButtonTransactions.click();
			androidLogs.CapturedLogs(pass, "Help Transactions close button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help Transactions close button was not found");
		}				

		Thread.sleep(3000);
		androidLogs.CapturedLogs(info,"HELP SCREEN FIND FUEL FROM ACCOUNT PAGE");
		WebElement HelpScreensFindFuelNearby = elements.HelpScreensFindFuelNearby();
		Thread.sleep(3000);
		if (HelpScreensFindFuelNearby  != null && HelpScreensFindFuelNearby.isEnabled()) {
			HelpScreensFindFuelNearby.click();
			androidLogs.CapturedLogs(pass, "Find Fuel button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Find Fuel button button was not found");
		}
		
		Thread.sleep(3000);
		WebElement HelpScreensCloseButtonFindFuel = elements.HelpScreensCloseButton();
		Thread.sleep(3000);
		if (HelpScreensCloseButtonFindFuel  != null && HelpScreensCloseButtonFindFuel.isEnabled()) {
			HelpScreensCloseButtonFindFuel.click();
			androidLogs.CapturedLogs(pass, "Help Find Fuel nearby close button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help Find Fuel nearby close button was not found");
		}		

				
		Thread.sleep(3000);
		WebElement CloseHelpScreens = elements.HelpScreensCloseButton();
		Thread.sleep(3000);
		if (CloseHelpScreens  != null && CloseHelpScreens.isEnabled()) {
			CloseHelpScreens.click();
			androidLogs.CapturedLogs(pass, "Help screens close button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Help screensclose button was not found");
		}		
		
	} else {
	  androidLogs.CapturedLogs(fail, "Help Screens button from home page was not found");
}
		
		
		
		androidLogs.setupTest("LOGGING OUT");		
		
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
		
	}
}