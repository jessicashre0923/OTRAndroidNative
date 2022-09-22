package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class AccountTabManageYourProfile {
	AndroidLogs androidLogs = new AndroidLogs();
	static AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions scroll = new ScrollOptions();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ProgressSpinner loading = new ProgressSpinner();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	public AccountTabManageYourProfile AccountTabManageYourProfile() throws Exception {
	//edit name
		androidLogs.CapturedLogs(pass, "Manage your profile started");
		
		Thread.sleep(2000);
						
		WebElement EditNameButton = elements.EditNameButton();
		if(EditNameButton!=null && EditNameButton.isEnabled()) {
			EditNameButton.click();
			androidLogs.CapturedLogs(pass, "Edit name button opened");
			String originalFirstName = elements.FirstNameTextBox().getText();
			String originalLastName=elements.LastNameTextBox().getText();
			androidLogs.CapturedLogs(info, "Original First name stored as " +originalFirstName.toString());
			androidLogs.CapturedLogs(info, "Original Last name stored as " +originalLastName.toString());
			System.out.println("Original First name stored as " +originalFirstName);
			System.out.println("Original Last name stored as " +originalLastName);
						
			Thread.sleep(2000);
			elements.FirstNameTextBox().sendKeys(androidText.PROFILE_FIRST_NAME);
			androidLogs.CapturedLogs(pass, "First name entered");
						
			Thread.sleep(2000);
			elements.LastNameTextBox().sendKeys(androidText.PROFILE_LAST_NAME);
			androidLogs.CapturedLogs(pass, "Last name entered");
						
			WebElement SaveEditNameButton = elements.SaveEditNameButton();
			Thread.sleep(3000);
			if (SaveEditNameButton != null && SaveEditNameButton.isEnabled()) {
				SaveEditNameButton.click();
				androidLogs.CapturedLogs(pass, "Name saved");
				Thread.sleep(6000);
			} else {
				androidLogs.CapturedLogs(pass, "Save button not found");	
			}
				
			Thread.sleep(6000);
			EditNameButton.click();
			
			Thread.sleep(2000);
			elements.FirstNameTextBox().sendKeys(originalFirstName);
			
			Thread.sleep(2000);
			elements.LastNameTextBox().sendKeys(originalLastName);
			androidLogs.CapturedLogs(pass, "Name set to original name");
			
			Thread.sleep(3000);
			elements.SaveEditOfOriginalNameButton().click();
			Thread.sleep(3000);
		}
		else {
			androidLogs.CapturedLogs(fail, "Edit name button not found");
		}
		
		//edit email
		Thread.sleep(2000);
		WebElement EditEmailButton = elements.EditEmailButton();
		if(EditEmailButton.isEnabled()) {
			Thread.sleep(2000);
			EditEmailButton.click();
			androidLogs.CapturedLogs(pass, "Edit email opened");
			Thread.sleep(2000);
			String originalEmail=elements.EmailTextBox().getText();
			androidLogs.CapturedLogs(info, "Original Email stored " +originalEmail.toString());
			Thread.sleep(2000);
			elements.EmailTextBox().sendKeys(androidText.PROFILE_EMAIL);
			androidLogs.CapturedLogs(pass, "Email textbox filled in");
			Thread.sleep(2000);
			elements.SaveEditEmailButton().click();
			androidLogs.CapturedLogs(pass, "new email saved");
			Thread.sleep(6000);
			EditEmailButton.click();
			Thread.sleep(3000);
			loading.progressSpinnerSaveEmail();
			Thread.sleep(2000);
			elements.EmailTextBox().sendKeys(originalEmail);
			Thread.sleep(2000);
			elements.SaveEditEmailButton().click();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(pass, "Email set to original email");
			Thread.sleep(3000);
		}
		else {
			androidLogs.CapturedLogs(fail, "Edit email button not found");
		}
		
		//edit phone number
		WebElement EditPhoneButton = elements.EditPhoneButton();
		if(EditPhoneButton.isEnabled()) {
			Thread.sleep(3000);
			EditPhoneButton.click();
			androidLogs.CapturedLogs(pass, "Edit phone number opened");
			String originalPhoneNumber=elements.EditPhoneTextBox().getText();
			androidLogs.CapturedLogs(info, "Original Phone Number stored " +originalPhoneNumber.toString());
			Thread.sleep(2000);
			elements.EditPhoneTextBox().sendKeys(androidText.PROFILE_PHONE);
			androidLogs.CapturedLogs(pass, "Phone number textbox filled in");
			Thread.sleep(2000);
			elements.SaveEditPhoneButton().click();
			androidLogs.CapturedLogs(pass, "New phone number saved");
			Thread.sleep(6000);
			EditPhoneButton.click();
			Thread.sleep(2000);
			elements.EditPhoneTextBox().sendKeys(originalPhoneNumber);
			Thread.sleep(2000);
			elements.SaveEditPhoneButton().click();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(pass, "Phone number set to original");
			Thread.sleep(6000);
		}
		else {
			androidLogs.CapturedLogs(fail, "Edit phone button not found");
		}
		
		Thread.sleep(2000);
		
		//Help screen for home page				
				WebElement ManageYourProfileBackButton = elements.ManageYourProfileBackButton();
				Thread.sleep(3000);
				if (ManageYourProfileBackButton != null && ManageYourProfileBackButton.isEnabled()) {
					ManageYourProfileBackButton.click();
					androidLogs.CapturedLogs(pass, "Manage your profile back button clicked");
				} else {
					androidLogs.CapturedLogs(info, "Manage your profile back button is not found");
				}
				
		return this;
		
	}
}
