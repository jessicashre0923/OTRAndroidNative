package androidCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AccountTab {
	AndroidLogs androidLogs = new AndroidLogs();
	static AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions scroll = new ScrollOptions();
	AppStringsAndroid androidText = new AppStringsAndroid();
	AccountTabManageYourProfile manageYourProfile = new AccountTabManageYourProfile();
	public String appVersionNumber = "";
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

	
	@Test(description = "Accounts Tab")
	public AccountTab accountTab() throws Exception {
		androidLogs.setupTest("Tests for Account Tab");

		// Find and click the account tab and tap it to open account tab.
		Thread.sleep(3000);
		WebElement AccountTab = elements.AccountTab();
		Thread.sleep(3000);
		if (AccountTab.isEnabled()) {
			AccountTab.click();
			androidLogs.CapturedLogs(pass, "Account tab opened");

System.out.println("WE ARE GOING TO SKIP CHANGING ACCOUNT DETAILS IN AUTOMATION IT CAN CAUSE ISSUES IF IT FAILS. PLEASE TEST MANUALLY.");
//WE ARE GOING TO SKIP CHANGING ACCOUNT DETAILS IN AUTOMATION IT CAN CAUSE ISSUES IF IT FAILS.. TEST MANUALLY.
//Test Manage profile 			
//			Thread.sleep(3000);
//			WebElement ManageYourProfile = elements.ManageYourProfile();
//			Thread.sleep(3000);
//			if (ManageYourProfile != null && ManageYourProfile.isEnabled()) {
//				ManageYourProfile.click();
//				androidLogs.CapturedLogs(pass, "Manage your profile opened");
// edit account information
//				Thread.sleep(3000);
//				manageYourProfile.AccountTabManageYourProfile();
//			} else {
//				androidLogs.CapturedLogs(fail, "Manage your profile not found.");
//			}

			// moved ACH transfer into AccountTransferToYourBankAddAccount
			Thread.sleep(2000);
			WebElement BioSwitchToOn = elements.BioSwitchToOn();
			Thread.sleep(3000);
			if (BioSwitchToOn.isEnabled()) {
				BioSwitchToOn.click();
				androidLogs.CapturedLogs(pass, "Biometric Switch on toggle to on");
				elements.BioSwitchToOff().click();
				androidLogs.CapturedLogs(pass, "Biometric Switch on toggle to off");
			} else {
				androidLogs.CapturedLogs(fail, "Biometric Switch not found.");
			}
			
			Thread.sleep(2000);
			WebElement ChangePassword = elements.ChangePassword();
			Thread.sleep(3000);
			if (ChangePassword != null && ChangePassword.isEnabled()) {
				ChangePassword.click();
				androidLogs.CapturedLogs(pass, "Change password opened");

				Thread.sleep(2000);
				Capabilities.driver.navigate().back();
				Thread.sleep(3000);
				Capabilities.driver.navigate().back();
				Thread.sleep(3000);
			} else {
				androidLogs.CapturedLogs(info, "Change password not found or not available in this account");
			}

			Thread.sleep(2000);
			WebElement CallCustomerService = elements.CallCustomerService();
			Thread.sleep(3000);
			if (CallCustomerService != null && CallCustomerService.isEnabled()) {
				CallCustomerService.click();
				androidLogs.CapturedLogs(pass, "Call customer service opened");

				Thread.sleep(2000);
				Capabilities.driver.navigate().back();
				Thread.sleep(3000);
				androidLogs.CapturedLogs(pass, "Back used to navigate.");
				Thread.sleep(2000);
				Capabilities.driver.navigate().back();
				Thread.sleep(3000);
				androidLogs.CapturedLogs(pass, "Back used to navigate.");
				Thread.sleep(2000);
				Capabilities.driver.navigate().back();
				Thread.sleep(3000);
				androidLogs.CapturedLogs(pass, "Back used to navigate.");
				Thread.sleep(2000);
			} else {
				androidLogs.CapturedLogs(fail, "Call Customer service not found.");
			}
			
			Thread.sleep(2000);
			WebElement WelcomeTutorial = elements.WelcomeTutorial();
			Thread.sleep(3000);
			if (WelcomeTutorial != null && WelcomeTutorial.isEnabled()) {
				WelcomeTutorial.click();
				androidLogs.CapturedLogs(pass, "Welcome tutorial opened");
				Thread.sleep(3000);

				int welcomeScreen = 0;
				while (welcomeScreen < 3) {
					new TouchAction<>(Capabilities.driver).longPress(PointOption.point(1000, 1390))
							.moveTo(PointOption.point(60, 1390)).release().perform();
					Thread.sleep(1000);
					welcomeScreen++;
					androidLogs.CapturedLogs(pass,
							"View Welcome tutorial pages gave been scrolled through.");
				}
				
				Thread.sleep(2000);
				WebElement WelcomeTutorialXButton = elements.WelcomeTutorialXButton();
				Thread.sleep(3000);
				if (WelcomeTutorialXButton != null && WelcomeTutorialXButton.isEnabled()) {
					WelcomeTutorialXButton.click();
					androidLogs.CapturedLogs(pass, "Welcome tutorial X button clicked.");

				}
			} else {
				androidLogs.CapturedLogs(fail, "View Welcome tutorial not found.");
			}
			
			scroll.ScrollDown();
			Thread.sleep(2000);
			WebElement TermsOfUse = elements.TermsOfUse();
			Thread.sleep(3000);
			if (TermsOfUse != null && TermsOfUse.isEnabled()) {
				TermsOfUse.click();
				androidLogs.CapturedLogs(pass, "Terms of use opened");
				Thread.sleep(5000);
				Capabilities.driver.navigate().back();
				androidLogs.CapturedLogs(pass, "Back used to navigate.");

			} else {
				androidLogs.CapturedLogs(fail, "terms of use not found.");
			}

			scroll.ScrollDown();
			Thread.sleep(2000);
			WebElement PrivacyPolicy = elements.PrivacyPolicy();
			Thread.sleep(3000);
			if (PrivacyPolicy != null && PrivacyPolicy.isEnabled()) {
				PrivacyPolicy.click();
				androidLogs.CapturedLogs(pass, "Privacy policy opened");
				Thread.sleep(5000);
				Capabilities.driver.navigate().back();
				androidLogs.CapturedLogs(pass, "Back used to navigate from Privacy policy page.");

			} else {
				androidLogs.CapturedLogs(fail, "Privacy policy not found");
			}

//needs to be named.... 			
//			scroll.ScrollDown();
//			Thread.sleep(2000);
//			appVersionNumber = elements.appVersionNumber().getText();
//			androidLogs.CapturedLogs(info, "Current App version number displayed is: " + appVersionNumber);
			
			
		} else {
			androidLogs.CapturedLogs(fail, "Accounts tab not found");
		}

		return this;
	}
}
