package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class CreateProfile {

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements = new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

		
	public CreateProfile ProfileSetup(String enviroment) throws Exception {

		androidLogs.setupTestYellow("PROFILE SETUP");
		androidLogs.setupTest("COMPLETE YOUR PROFILE HELP SCREEN");
	//Help screen for Profile setup page
		
		Thread.sleep(3000);
		WebElement CompleteYourProfilePage = elements.CompleteYourProfilePage();
		Thread.sleep(3000);
		if (CompleteYourProfilePage != null && CompleteYourProfilePage.isEnabled()) {
			
			androidLogs.CapturedLogs(pass, "Complete your profile page is found");
			
		
		
		Thread.sleep(3000);
		WebElement ProfileHelpScreenContinue = elements.ProfileHelpScreenContinue();
		Thread.sleep(3000);
		if (ProfileHelpScreenContinue != null && ProfileHelpScreenContinue.isEnabled()) {
			ProfileHelpScreenContinue.click();
			androidLogs.CapturedLogs(pass, "Profile help Screen continue Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(info, "Profile help Screen continue Button is not found");
			}
		
		
		//Check for security questions page
		androidLogs.setupTest("SECURITY QUESTIONS");
				Thread.sleep(3000);		
				WebElement SecurityQuestionOne = elements.SecurityQuestionOne();
				Thread.sleep(3000);
				if (SecurityQuestionOne != null && SecurityQuestionOne.isEnabled()) {
					androidLogs.CapturedLogs(pass, "Security Question one found");
					
					
					Thread.sleep(3000);		
					WebElement SecurityQuestionOneAnswer = elements.SecurityQuestionOneAnswer();
					Thread.sleep(3000);
					if (SecurityQuestionOneAnswer != null && SecurityQuestionOneAnswer.isEnabled()) {
						SecurityQuestionOneAnswer.click();
						SecurityQuestionOneAnswer.sendKeys(androidText.SEC_ANSWERS);
						androidLogs.CapturedLogs(pass, "Security Question 1 answered");
						
						 Thread.sleep(3000);
						WebElement SecurityQuestionNextButton = elements.SecurityQuestionNextButton();
						 Thread.sleep(3000);
						SecurityQuestionNextButton.click();
						androidLogs.CapturedLogs(pass, "Security Question next button selected");
						
					} else {
						androidLogs.CapturedLogs(info, "\"Security Question 1 not found");
					}
						
						
						Thread.sleep(3000);
						if (SecurityQuestionOneAnswer != null && SecurityQuestionOneAnswer.isEnabled()) {
							SecurityQuestionOneAnswer.click();
							SecurityQuestionOneAnswer.sendKeys(androidText.SEC_ANSWERS);
							androidLogs.CapturedLogs(pass, "Security Question 2 answered");
							 Thread.sleep(3000);
							WebElement SecurityQuestionNextButton = elements.SecurityQuestionNextButton();
							 Thread.sleep(3000);
							SecurityQuestionNextButton.click();
							androidLogs.CapturedLogs(pass, "Security Question next button selected");
							
						} else {
							androidLogs.CapturedLogs(info, "\"Security Question 2 not found");
						}
							
							
							Thread.sleep(3000);
							if (SecurityQuestionOneAnswer != null && SecurityQuestionOneAnswer.isEnabled()) {
								SecurityQuestionOneAnswer.click();
								SecurityQuestionOneAnswer.sendKeys(androidText.SEC_ANSWERS);
								androidLogs.CapturedLogs(pass, "Security Question 3 answered");
							
								WebElement SecurityQuestionNextButton = elements.SecurityQuestionNextButton();
								SecurityQuestionNextButton.click();
								androidLogs.CapturedLogs(pass, "Security Question next button selected");
						
					} else {
						androidLogs.CapturedLogs(info,
								"Security Question 3 not found");
					}
							
				} else {
					androidLogs.CapturedLogs(info,
							"Security Questions page not found could be already setup or not needed for this account");
				}
		
		
		
		
		Thread.sleep(3000);
		androidLogs.setupTest("PROFILE QUESTIONS");
		WebElement ProfileSetup = elements.ProfileSetup();
		Thread.sleep(3000);
		if (ProfileSetup != null && ProfileSetup.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Profile Page found");
			
			Thread.sleep(3000);
			WebElement FirstNameTextbox = elements.FirstNameTextbox();
			 Thread.sleep(3000);
			if (FirstNameTextbox != null && FirstNameTextbox.isEnabled()) {
				//FirstNameTextbox.click();
				FirstNameTextbox.sendKeys(androidText.FIRST_NAME);
				androidLogs.CapturedLogs(pass, "First Name textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "First Name textbox not found");
			}
			Thread.sleep(3000);
			WebElement LastNameTextbox = elements.LastNameTextbox();
			 Thread.sleep(3000);
			if (LastNameTextbox != null && LastNameTextbox.isEnabled()) {
				LastNameTextbox.click();
				LastNameTextbox.sendKeys(androidText.LAST_NAME);
				androidLogs.CapturedLogs(pass, "Last Name textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Last Name textbox not found");
			}
     	    Thread.sleep(3000);
			WebElement NextButton = elements.NextButton();
			Thread.sleep(3000);
			if (NextButton != null && NextButton.isEnabled()) {
				NextButton.click();
				androidLogs.CapturedLogs(pass, "Next Button found and clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Next Button not found");
			}
			Thread.sleep(3000);
			WebElement DateOfBirth = elements.DateOfBirth();
			 Thread.sleep(3000);
			if (DateOfBirth != null && DateOfBirth.isEnabled()) {
				DateOfBirth.click();
				DateOfBirth.sendKeys(androidText.DATE_OF_BIRTH);
				androidLogs.CapturedLogs(pass, "Date of Birth Textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Date of Birth Textbox not found");
			}
			Thread.sleep(3000);
			WebElement DOBNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (DOBNextButton != null && DOBNextButton.isEnabled()) {
				DOBNextButton.click();
				androidLogs.CapturedLogs(pass, "Next Button on DOB found and clicked");
				Thread.sleep(3000);
			} else {
				androidLogs.CapturedLogs(fail, "Next Button on DOB not found");
			}
			Thread.sleep(3000);
			WebElement PhoneNumberTextBox = elements.PhoneNumberTextBox();
			 Thread.sleep(3000);
			if (PhoneNumberTextBox != null && PhoneNumberTextBox.isEnabled()) {
				PhoneNumberTextBox.click();
				PhoneNumberTextBox.sendKeys(androidText.PHONE_NUMBER);
				androidLogs.CapturedLogs(pass, "Phone Number Textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Phone Number Textbox not found");
			}
			 Thread.sleep(3000);
			WebElement PhoneNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (PhoneNextButton != null && PhoneNextButton.isEnabled()) {
				PhoneNextButton.click();
				androidLogs.CapturedLogs(pass, "Next Button on Phone page found and clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Next Button on Phone page not found");
			}

			Thread.sleep(3000);
			WebElement EmailTextBox = elements.EmailTextBox();
			 Thread.sleep(3000);
			if (EmailTextBox != null && EmailTextBox.isEnabled()) {
				EmailTextBox.click();
				EmailTextBox.sendKeys(androidText.EMAIL_ADDRESS);
				androidLogs.CapturedLogs(pass, "Email Textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Email Textbox not found");
			}

			Thread.sleep(3000);
			WebElement EmailNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (EmailNextButton != null && EmailNextButton.isEnabled()) {
				EmailNextButton.click();
				androidLogs.CapturedLogs(pass, "Next Button on email page found and clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Next Button on email page not found");
			}

			Thread.sleep(3000);
			WebElement SocialTextBox = elements.SocialTextBox();
			 Thread.sleep(3000);
			if (SocialTextBox != null && SocialTextBox.isEnabled()) {
				SocialTextBox.click();
				SocialTextBox.sendKeys(androidText.SOCIAL_SECURITY);
				androidLogs.CapturedLogs(pass, "Social Textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Social Textbox not found");
			}

			Thread.sleep(3000);
			WebElement SocialNextButton = elements.NextButton();
			 Thread.sleep(3000);
			if (SocialNextButton != null && SocialNextButton.isEnabled()) {
				SocialNextButton.click();
				androidLogs.CapturedLogs(pass, "Next Button on Social page found and clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Next Button on Social page not found");
			}
			Thread.sleep(3000);
			WebElement HomeAddressTextBox = elements.HomeAddressTextBox();
			Thread.sleep(3000);
			if (HomeAddressTextBox != null && HomeAddressTextBox.isEnabled()) {
				HomeAddressTextBox.click();
				HomeAddressTextBox.sendKeys(androidText.HOME_ADDRESS);
				androidLogs.CapturedLogs(pass, "Address Textbox found and filled in");
			} else {
				androidLogs.CapturedLogs(fail, "Address Textbox not found");
			}
			
			Thread.sleep(3000);
			WebElement AddressSelector = elements.AddressSelector();
			Thread.sleep(3000);
			if (AddressSelector != null && AddressSelector.isEnabled()) {
				AddressSelector.click();
				androidLogs.CapturedLogs(pass, "Address Selector found and chosen");
			} else {
				androidLogs.CapturedLogs(fail, "Address Selector not found");
			}

			WebElement AddressLineTwo = elements.AddressLineTwo();
			Thread.sleep(3000);
			if (AddressLineTwo != null && AddressLineTwo.isEnabled()) {
				AddressLineTwo.click();
				AddressLineTwo.sendKeys(androidText.HOME_ADDRESS_LINE_TWO);
				androidLogs.CapturedLogs(pass, "Address Selector found and chosen");
			} else {
				androidLogs.CapturedLogs(fail, "Address Selector not found");
			}
			Thread.sleep(3000);
			WebElement ProfileFinishButton = elements.ProfileFinishButton();
			Thread.sleep(3000);
			if (ProfileFinishButton != null && ProfileFinishButton.isEnabled()) {
				ProfileFinishButton.click();
				androidLogs.CapturedLogs(pass, "Finish Button found and Clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Finish Button not found");
			}
			
			Thread.sleep(3000);
			WebElement GetStartedButton = elements.GetStartedButton();
			Thread.sleep(3000);
			if (GetStartedButton != null && GetStartedButton.isEnabled()) {
				GetStartedButton.click();
				androidLogs.CapturedLogs(pass, "Get Started Button found and Clicked");
			} else {
				androidLogs.CapturedLogs(fail, "Get Started Button not found");
			}
				
			androidLogs.setupTest("Login test with setup profile completed");
				
		} else {
			androidLogs.CapturedLogs(info, "Setup profile page not found could be already setup or not needed for this account");
		}
		
		} else {
			androidLogs.CapturedLogs(info, "Complete your profile setup page is not found");
		}
		
		return this;
	}
}
